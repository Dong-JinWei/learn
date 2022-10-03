package com.danei.lesson02;

public class ArrayTest {
    public static void main(String[] args) {
        int[] arr = {0, 2, 0, 2, 0, 2, 4, 0, 4, 0, 8, 8, 0, 2, 2, 0, 2};

        int flag = 0;// 标志 0为第一个，1为第二个
        int first = 0;

        /*
            if arr[i] != 0
               if flag == 0
                  first = i;
                  flag = 1;·
                else{
                    if(arr[first] == arr[i])
                        arr[first] += arr[i];
                        arr[i] = 0;
                        flag = 0;
                     else
                        arr[first] = arr[i]
                        flag = 1;
                }

         */
        System.out.print("\n原数组：");
        for (int i : arr) {
            System.out.print(i + " ");

        }


        System.out.print("\n合并：");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                if (flag == 0) {
                    first = i;
                    flag = 1;
                } else {
                    if (arr[first] == arr[i]) {
                        arr[first] += arr[i];
                        arr[i] = 0;
                        flag = 0;
                    } else {
                        first = i;
                        flag = 1;
                    }
                }


            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

//        int[] arr2 = new int[arr.length];
//
//        for (int i = 0, n = 0; i < arr.length; i++) {
//
//            if(arr[i] != 0){
//                arr2[n] = arr[i];
//                n++;
//            }
//        }
//
       int i = 0,j = 0;
        for( i = 0 ; i < arr.length ;i++){
            if(arr[i] != 0) {
                arr[j] = arr[i];
                j++;
            }
        }
        for(;j < arr.length; j++){
            arr[j] = 0;
        }

        System.out.print("\n左移：");
        for (int n : arr) {
            System.out.print(n + " ");

        }

        i = arr.length - 1;
        j = arr.length - 1;
        for (; i >= 0; i--){
            if(arr[i] != 0){
                arr[j] = arr[i];
                j--;
            }
        }
        for(;j >= 0; j--){
           arr[j] = 0;
        }


        System.out.print("\n左移：");
        for (int n : arr) {
            System.out.print(n + " ");

        }


    }
}