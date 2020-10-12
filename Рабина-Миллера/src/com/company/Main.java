package com.company;

import java.math.BigInteger;

public class Main {
    private static int[] mas;
//
    public static String reverseString(String str) {
        char[] array = str.toCharArray();
        String result = "";
        for (int i = array.length - 1; i >= 0; i--) {
            result = result + array[i];
        }
        return result;
    }
    //Получаем массив простых чисел
    public static  int [] primeNum(int N){

        int[] simpleArray = new int[N];
        int nextNumber = 2;
        int counter = 0;
        boolean isSimple;
        while (counter < N) {
            int i = 0;
            isSimple = true;
            while (isSimple && i < counter) {
                if (nextNumber % simpleArray[i] == 0) {
                    isSimple = false;
                }
                i++;
            }
            if (isSimple) {
                simpleArray[counter] = nextNumber;
                counter++;
                nextNumber++;
            } else {
                nextNumber++;
            }
        }



        return  simpleArray;
    }
//Генерируем рандомное число, преобразовываем его
public static int generateNum()
{
    boolean flag = true;
    int number = 0;

    while(flag)
    {

        number = (int) (Math.random() * 100000);
        char [] BinaryNum  = reverseString(Integer.toBinaryString(number)).toCharArray();

        BinaryNum[BinaryNum.length-1] = '1';

        number = 0;
        for(int i = 0;i<BinaryNum.length;i++)
            number +=Integer.parseInt(String.valueOf(BinaryNum[i])) * Math.pow(2,i);


        flag = checkNum(number);
    }

    return number;
}

//Проверяем сгенерированное число
public static boolean checkNum(int number)
{
    for (int ma : mas)
        if(number == ma)
            return false;

    return true;
}

//Данный метод работает верно, если простые числа меньше 100;
//    public static boolean MillerRabinTest()
//    {
//        int n = generateNum();
//
//
//        // представим n − 1 в виде (2^s)·t, где t нечётно, это можно сделать последовательным делением n - 1 на 2
//        int t = n - 1;
//        int k = 5;
//        int s = 0;
//
//        while (t % 2 == 0)
//        {
//            t /= 2;
//            s += 1;
//        }
//
//        // повторить k раз
//        for (int i = 0; i < k; i++)
//        {
//            // выберем случайное целое число a в отрезке [2, n − 2]
//            int a;
//            do
//            {
//                a = (int) (Math.random() * 1000);
//            }
//            while (a < 2 || a >= n - 2);
//
//            // x ← a^t mod n, вычислим с помощью возведения в степень по модулю
//
//            int x = (int)Math.pow(a,t)%n;
//
//            // если x == 1 или x == n − 1, то перейти на следующую итерацию цикла
//            if (x == 1 || x == n - 1)
//                continue;
//
//            // повторить s − 1 раз
//            for (int r = 1; r < s; r++)
//            {
//                // x ← x^2 mod n
//
//                x = (int)Math.pow(x,2)%n;
//
//                // если x == 1, то вернуть "составное"
//                if (x == 1)
//                    return false;
//
//                // если x == n − 1, то перейти на следующую итерацию внешнего цикла
//                if (x == n - 1)
//                    break;
//            }
//
//            if (x != n - 1)
//                return false;
//        }
//
//        // вернуть "вероятно простое"
//        return true;
//    }

    public static void main(String[] args) {
        mas = primeNum(10000);
//        System.out.println(MillerRabinTest());

        //Тест Рабина-Миллера
        Integer integer=generateNum();
        BigInteger bigInteger = BigInteger.valueOf(integer);
        boolean probablePrime = bigInteger.isProbablePrime((int)Math.log(integer));
        System.out.println(probablePrime);
    }
}
