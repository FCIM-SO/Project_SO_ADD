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

