package com.knubisoft.base.numbers;

import java.util.Arrays;

/*Создайте 3 массива: числа, размеры и пути
Как следует из названия, nums — это исходный массив. размеры должны отслеживать размер массива
и пути для отслеживания возрастающего массива подпоследовательностей.
Изначально длина равна 1. Создайте две переменные i и j.
Теперь j всегда находится в индексе 0, а i в индексе 1.
Таким образом, j всегда начинается с 0 до j=i-1, а i увеличивается после j=i.
Здесь важно сравнить j и i. Итак, если j < i, то длина увеличивается, но берется max (j + 1, предыдущий len).
В противном случае проигнорируйте его, и i будет увеличен.
И соответственно упоминание и обновление пути в третьем массиве. */
public class NumbersTest  {
        public static void main(String[] args){
            int[] nums = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
          printLIS(nums);

        }

        public static void printLIS(int[] nums){

            //Делаем массивы для размера массива(int[]) и для вывода массива(String[]) в консоль
            String[] paths = new String[nums.length];
            int[] sizes = new int[nums.length];

            //назначаем размер для массива и путь для вывода конечного массива
            for(int i=0; i<nums.length; i++){
                sizes[i] = 1;
                paths[i] = nums[i] + " " ;
            }

            //Сделаем maxLength
            int maxLength = 1;

            for(int i=1; i<nums.length; i++){
                for(int j=0; j<nums.length; j++){
            // i для первой позиции
            // j для нулевой позиции

            //здесь j<i и размер должен увеличиваться
                    if(nums[i]>nums[j] && sizes[i] < sizes[j] + 1){;
                        //если это так, нам нужно обновить размеры и путь
                        sizes[i] = sizes[j] + 1;
                        paths[i] = paths[j] + nums[i] + " ";
                        // добавить текущие значения в конец!!
                        if(maxLength < sizes[i])
                            maxLength = sizes[i];
                    }
                }
            }
            // В конце,просканируем размер массива и распечатаем путь, когда размер соответствует
            for(int i=1; i<nums.length; i++){
                if(sizes[i] == maxLength)
                    System.out.println("LIS: " + paths[i]);
            }
        }
}
