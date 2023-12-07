import os
import time

import numpy as np
import random
import re
import joblib
import pygame
from PIL import Image


folder_path = "D:\my_python\Train"
training_data=[]
with os.scandir(folder_path) as entries:#формируем данные
    for entry in entries:
        vector = np.zeros(10)
        image = Image.open(entry.path).convert('L')
        filename_temp = os.path.basename(entry)
        filename=re.findall('[0-9]+', filename_temp)[1]
        vector[int(filename)]=1
        img_array = np.array(image)
        pixels = img_array.reshape(28, 28) / 255
        #shifts = [(0, 0), (0, -3), (0, 3)]#для шума вправо влево в итоге плохо работало
        shifts = [(0, 0)]
        for shift in shifts:
            shifted_array = np.roll(pixels, shift, axis=(0, 1))
            training_data.append([shifted_array.reshape(-1), vector])
joblib.dump(training_data, 'training_data_photo_small.joblib')

folder_path = "D:\my_python\Test_folder"
test_data=[]
with os.scandir(folder_path) as entries:#формируем данные
    for entry in entries:

        image = Image.open(entry.path).convert('L')
        filename_temp = os.path.basename(entry)
        filename=re.findall('[0-9]+', filename_temp)[1]
        img_array = np.array(image)
        pixels = img_array.reshape(-1)/255
        test_data.append([pixels,int(filename)])
joblib.dump(test_data, 'test_data_photo.joblib')

training_data_small = joblib.load('training_data_photo_small.joblib')
#training_data = joblib.load('training_data_photo.joblib')
test_data = joblib.load('test_data_photo.joblib')



def f(z):#сигмоида
    return 1.0/(1.0+np.exp(-z))

def df(z):#функция производной
    return (1.0/(1.0+np.exp(-z)))*(1-(1.0/(1.0+np.exp(-z))))

class Network(object):
    def init(self, sizes):
        self.num_layers = len(sizes) #количество слоев
        self.sizes = sizes #сохраняем списко нашей нейросети
        self.biases = [np.random.randn(y ) for y in sizes[1:]] #для первых не нужны biases
        self.weights = [np.random.randn(x, y) #формируем нейросеть
                        for y, x in zip(sizes, sizes[1:])]

    def feedforward(self, a):
        for b, w in zip(self.biases, self.weights):
            a = f(np.dot(a, w.T) + b)#прямое распространение
        return a

    def SGD(self, training_data,test_data, epochs, mini_batch_size, eta):

        for j in range(epochs):#для каждой эпохи будет заного обучение
            random.shuffle(training_data)#рандомно данные
            mini_batches = [
                training_data[k:k+mini_batch_size]#разбиваем на кусочки
                for k in range(0, len(training_data), mini_batch_size)]

            for mini_batch in mini_batches:#каждый кусочек настраиваем
                self.update_mini_batch(mini_batch, eta)
            if test_data:
                k = 0
                for photo, num in test_data:
                    tmp = np.argmax(self.feedforward(photo))
                    if tmp == num:
                        k = k + 1
                print("Epoch {0}: {1} / {2}".format(j+1,len(test_data), k))
            else:
                print("Epoch {0} complete".format(j+1))

    def update_mini_batch(self, mini_batch, eta=0):
        tmp_b = [np.zeros(b.shape) for b in self.biases]#создаем временное хранилище для весов
        tmp_w = [np.zeros(w.shape) for w in self.weights]
        for mb in mini_batch:
            dw, db = self.backprop(mb[0],mb[1])#в цикле сохраняем корректировку весов для мини батча
            for i in range(self.num_layers-1):
                tmp_w[i] +=  dw[i]
                tmp_b[i]  +=  db[i]
        for i in range(self.num_layers-1):
            self.weights[i]=self.weights[i]+(eta*tmp_w[i])#корректируем со скоростью
            self.biases[i]=self.biases[i]+(eta*tmp_b[i])

    def backprop(self, x, y):#функция для передачи списка корректировки весов и б. для 1 тестового элемента

        activation = x
        activations = [x]#сохраняем в список входные данные

        for b, w in zip(self.biases, self.weights):

            activation = f(np.dot(w,activation) + b)
            activations.append(activation)#по мере прямого распространения сохраняем значения на каждом весе

      #находим ошибку на последнем слое
        deltas = [y-activations[-1]]#сохраняем ее в список

        for i in range(self.num_layers - 2, 0, -1):

            error = np.dot(self.weights[i].T, deltas[-1]) * df(activations[i])#обратно распространяем ее и сохраняем дельту
            deltas.append(error)
        deltas.reverse()

        grades=[]
        biases=[]
        for i in range(self.num_layers - 1):#находим корректировки весов из значений на нейронах с ошибкой
            layer_inputs = activations[i].reshape(-1,1)
            delta = deltas[i].reshape(-1,1)
            grade=np.dot( delta,layer_inputs.T)
            grades.append(grade)
            biases.append(delta.reshape(-1))
        return [grades,biases]#возвращаем список весов для корректировки
#тренируем нашу сеть

    photo_analyzer = joblib.load('photo_analyzer.joblib')

    my_str = '0 1 2 3 4 5 6 7 8 9'
    canvas = np.zeros((28, 28))
    pygame.init()
    clock = pygame.time.Clock()
    FPS = 60
    screen = pygame.display.set_mode((252, 252))
    pygame.display.set_caption('Рисовалка')

    WHITE = (255, 255, 255)
    x, y = 0, 0
    line_thickness = 21
    running = True
    pygame.init()

    # Set up the display
    width, height = 800, 600
    screen = pygame.display.set_mode((width, height))
    pygame.display.set_caption("Drawing and Output String")

    # Colors
    WHITE = (255, 255, 255)

    # Set up the canvas
    canvas = np.zeros((252, 252))

    # Set up the drawing variables
    line_thickness = 10
    x, y = 0, 0
    running = True

    # Set up the clock
    clock = pygame.time.Clock()
    FPS = 15

    # Set up the font
    font = pygame.font.Font(None, 36)
    font1 = pygame.font.Font(None, 52)
    while running:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                running = False
            elif event.type == pygame.MOUSEBUTTONDOWN:
                if event.button == 1:
                    pygame.draw.circle(screen, WHITE, event.pos, line_thickness // 2)
                    x, y = event.pos
                    canvas[y // 10, x // 10] = 1
                elif event.type == pygame.MOUSEMOTION:
                    if pygame.mouse.get_pressed()[0]:
                        pygame.draw.line(screen, WHITE, (x, y), event.pos, line_thickness)
                    x, y = event.pos
                    canvas[y // 10, x // 10] = 1
                elif event.type == pygame.KEYDOWN:
                    if event.key == pygame.K_d:
                        screen.fill((0, 0, 0))
                    canvas = np.zeros((252, 252))

    pygame.image.save(screen, "Test_photo.png")
    img = Image.open('Test_photo.png')
    new_img = img.resize((28, 28))
    new_img.save('Test_photo.png', 'PNG')
    image = Image.open('Test_photo.png').convert('L')
    img_array = np.array(image)
    pixels = img_array.reshape(-1) / 255
    # Assuming photo_analyzer is defined somewhere in your code
    a = photo_analyzer.feedforward(pixels)
    summa = np.sum(a)
    percent = a / summa * 100
    output_string = f"{round(percent[0], 2)}% {round(percent[1], 2)}% {round(percent[2], 2)}% {round(percent[3], 2)}% {round(percent[4], 2)}% {round(percent[5], 2)}% {round(percent[6], 2)}% {round(percent[7], 2)}% {round(percent[8], 2)}% {round(percent[9], 2)}%"
    # Create a surface to render the text
    text_surface = font.render(output_string, True, WHITE)
    text_surface1 = font1.render(my_str, True, WHITE)

    # Blit the text surface onto the screen
    screen.fill((0, 0, 0), (0, 0, screen.get_width(), 50))
    screen.blit(text_surface, (10, 10))
    screen.blit(text_surface1, (10, 50))

    pygame.display.update()
    clock.tick(FPS)

    pygame.quit()