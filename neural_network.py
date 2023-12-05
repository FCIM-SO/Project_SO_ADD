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
