package com.lyl.algorithm.helper;

/**
 * * @Description 排序工具
 * * @Author 刘亚林
 * * @CreateDate 2020/10/22
 * * @Version 1.0
 * * @Remark TODO
 **/
public class SortHelper {
    //交换
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //填充一个新的数组
    public static int[] fillArr(int[] arr, int size) {
        int[] newArr = new int[size];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    //选择排序
    public static int[] selectionSort(int[] arr, int size) {
        //填充一个新数组
        int[] result = fillArr(arr, size);
        int minIndex = 0;
        for (int i = 0; i < size; i++) {
            minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (result[j] < result[minIndex]) {
                    minIndex = j;
                }
            }
            swap(result, i, minIndex);
        }
        return result;
    }
}
