#include <iostream>
#include "iostream"
#include "cstdlib"
#include "SortHelper.h"

namespace SortHelper {
    //生成随机数组num为数量，start-end的范围
    int *generateRandomArray(int num, int start, int end) {
        //只能end大于start
        assert(num > 0 && end > start);
        int *arr = new int[num];
        //初始化随机种子
        srand(time(NULL));
        for (int i = 0; i < num; ++i) {
            //rand()生成随机整数，% （end - start + 1 ）取余 随机数就会在start和end之间
            arr[i] = rand() % (end - start + 1) + start;
        }
        return arr;
    }

    //交换
    void swap(int *arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //填充一个新的数组
    int *fillArr(int *arr, int size) {
        int *newArr = new int[size];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    //选择排序算法
    int *selectionSort(int *arr, int len) {
        //循环0-len
        int *result = fillArr(arr, len);
        int minIndex = 0;
        for (int i = 0; i < len; ++i) {
            //记录当前最小的下标默认是当前循环的最小
            minIndex = i;
            //再从当前+1个循环到len逐个比对
            for (int j = i + 1; j < len; ++j) {
                //如果找到比当前小的
                if (result[j] < result[minIndex]) {
                    //记录下表为最小值
                    minIndex = j;
                }
            }
            //就把两个位置数字互换
            swap(result, minIndex, i);
        }
        return result;
    }
}
