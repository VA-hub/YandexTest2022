package test1;

import java.util.Scanner;

public class Resheto {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //int n = scan.nextInt();
        int summ = 0;

        int prime[] = new int[1010];// Сохраняем простые числа
        boolean vis[] = new boolean[1000000];

        int t = 0;// 1 для p [1010] - в этом массиве постоянно хранятся простые числа и индекс, определенный вами (без i;
        // 2 - это запись количества простых чисел и создание условий для последующего цикла.
        for (int i = 2; i <= 1000; i++)// Определенный здесь i является одновременно источником простых чисел (строка 13) и множителем, используемым для просеивания составных чисел сзади (строка 20)
        {
            //printf("##i=%d\n",i);
            if (vis[i] == false)// Если i простое число
            {
                prime[t] = i;// Сохраняем в p []
                t++;
            }
            //printf("t=%d ",t-1);
            for (int j = 0; j < t; j++)// Запускаем сито
            {
                //printf("##i=%d prime[j]=%d i*prime[j]=%d\n",i,prime[j],i*prime[j]);
                vis[prime[j] * i] = true;// Отсеиваем композит
                if (i % prime[j] == 0)// В этом разница между Решетом Эрлиха и Решетом Эйлера. Большинство оптимизаций полагается на это предложение (доказательства будут позже
                    break;
            }
            //printf("\n------------\n");
        }
        for (int i = 0; prime[i] != 0; i++) {// Вывод простого числа
            summ = prime[i] + summ;
            System.out.print(prime[i] + " ");
        }
        System.out.println();
        System.out.println(summ);

    }
}