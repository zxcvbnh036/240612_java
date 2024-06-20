package p04_Array;

import common.Utils;

import java.util.Arrays;

public class Ex02applicate {
  public static void main(String[] args) {
    int[] score = new int[10];
    for (int i = 0; i < 10; i++) {
      score[i] = (int)(Math.random() * 30) + 70;
      System.out.println(score[i]);
    }
    /*System.out.println(Arrays.toString(score));*/
    prArr(score);
    maxArr(score);
    minArr(score);
    sumArr(score);
    avgArr(score);
  }

  public static void minArr(int[] arr) {
    System.out.println();
    int min = arr[0];
    for (int i = 0; i <arr.length ; i++) {
      if (min > arr[i]) min = arr[i];
    }
    System.out.println("Min: " + min);
  }

  public static int sumArr(int[] arr) {
    System.out.println();
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum = sum + arr[i];
    }
    System.out.println("Sum: " + sum);
    return sum;
  }

  public static double avgArr(int[] arr) {
    double result = sumArr(arr) / (double) arr.length;
    System.out.println("avg: " + result);
    return result;

    /*System.out.println();
    int sum = 0;
    int avg = 0;
    for (int i = 0; i < arr.length ; i++) {
      sum = sum + arr[i];
      avg = sum / arr.length;
    }
    System.out.println("Avg: " + avg);
    return avg;*/
  }


  public static void maxArr(int[] arr) {
    System.out.println();
    int max = arr[0];
    for (int i = 0; i <arr.length ; i++) {
    // 삼항 연산자  max = max < arr[i] ? arr[i] : max;
      if (max < arr[i]) max = arr[i];
      }
      System.out.println("Max: " + max);
  }


  public static void prArr(int[] arr) {
    System.out.print("[");
    for (int i = 0; i < arr.length; i++) {
      if (i != 0) {System.out.print(",");}
      System.out.print(arr[i]);
    }
    System.out.print("]");
  }
}
