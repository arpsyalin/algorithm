#include <jni.h>
#include <string>
#include "iostream"
#include "SortHelper.h"

extern "C"
JNIEXPORT jintArray JNICALL
Java_com_lyl_algorithm_MainActivity_randArr(JNIEnv *env, jobject thiz, jint num, jint start,
                                            jint end) {
    // TODO: implement randArr()
    //生成随机数组
    jint *arr = SortHelper::generateRandomArray(num, start, end);
    //新建一个数组
    jintArray result = (env)->NewIntArray(num);
    //将生成的随机数组设置到新建的数组
    env->SetIntArrayRegion(result, 0, num, arr);
    //释放内存一种方式
//    delete[] arr;
    //释放内存第二种方式
    free(arr);
    return result;
}extern "C"
JNIEXPORT jintArray JNICALL
Java_com_lyl_algorithm_MainActivity_selectionSort(JNIEnv *env, jobject thiz, jintArray arr,
                                                  jint size) {
    // TODO: implement selectionSort()
    jint *inArr = env->GetIntArrayElements(arr, NULL);
    jint *sortArr = SortHelper::selectionSort(inArr, size);
    jintArray result = (env)->NewIntArray(size);
    env->SetIntArrayRegion(result, 0, size, sortArr);
    delete[]sortArr;
    return result;
}