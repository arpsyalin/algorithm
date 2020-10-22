#ifndef ALGORITHM_SORTHELPER_H
#define ALGORITHM_SORTHELPER_H

namespace SortHelper {
    //生成随机数组num为数量，start-end的范围
    int *generateRandomArray(int num, int start, int end);

    void swap(int *arr, int i, int j);

    //选择排序算法
    int *selectionSort(int *arr, int len);

    int *fillArr(int *arr, int size);
}

#endif //ALGORITHM_SORTHELPER_H
