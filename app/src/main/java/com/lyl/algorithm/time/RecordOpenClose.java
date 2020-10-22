package com.lyl.algorithm.time;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * * @Description 记录打开关闭
 * * @Author 刘亚林
 * * @CreateDate 2020/10/22
 * * @Version 1.0
 * * @Remark TODO
 **/
public class RecordOpenClose {

    Map<String, Long> mStartTime = new HashMap<>();
    Map<String, Long> mRecordTime = new HashMap<>();
    Map<String, String> mCompareTime = new HashMap<>();

    public void open(String key) {
        if (mStartTime.containsKey(key)) {
            throw new RuntimeException("记录已经开始，请先关闭！");
        }
        mStartTime.put(key, System.currentTimeMillis());
    }

    public void close(String key) {
        if (!mStartTime.containsKey(key)) {
            throw new RuntimeException("记录未开始，请先关闭！");
        }
        Long time = mStartTime.get(key);
        long costTime = System.currentTimeMillis() - time;
        mStartTime.remove(key);
        mRecordTime.put(key, costTime);
    }

    public void addCompare(String k1, String k2) {
        long result = compare(k1, k2);
        String msg = "";
        if (result == 0) {
            msg = "相等";
        } else if (result > 0) {
            msg = "大于";
        } else {
            msg = "小于";
        }
        mCompareTime.put(k1 + ":" + k2, k1 + " " + msg + " " + k2 + (result == 0 ? "" : "相差" + Math.abs(result) + "ms"));
    }

    private long compare(String k1, String k2) {
        if (!mRecordTime.containsKey(k1) || !mRecordTime.containsKey(k2)) {
            throw new RuntimeException("有没有记录过的key");
        }
        long result = mRecordTime.get(k1) - mRecordTime.get(k2);
        return result;

    }


    public String getRecordString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, Long> entry : mRecordTime.entrySet()) {
            String value = entry.getKey() + "运行时间为" + entry.getValue();
            stringBuffer.append(value);
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    public String getCompareString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : mCompareTime.entrySet()) {
            stringBuffer.append(entry.getValue());
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }


    public String getResultString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getRecordString());
        stringBuffer.append(getCompareString());
        return stringBuffer.toString();
    }
}
