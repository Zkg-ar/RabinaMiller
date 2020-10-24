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

    public static void main(String[] args) {
        mas = primeNum(10000);


        //Тест Рабина-Миллера
        Integer integer=generateNum();
        BigInteger bigInteger = BigInteger.valueOf(integer);
        boolean probablePrime = bigInteger.isProbablePrime((int)Math.log(integer));
        System.out.println(probablePrime);
    }
}
