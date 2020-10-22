package com.lyl.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lyl.algorithm.helper.SortHelper;
import com.lyl.algorithm.time.RecordOpenClose;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    EditText mEditText;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.edit_num);
        mTextView = findViewById(R.id.tv_result);

    }


    public native int[] randArr(int num, int start, int end);

    public native int[] selectionSort(int[] arr, int size);


    //点击排序比较
    public void compareClick(View view) {
        String num = mEditText.getText().toString();
        if (TextUtils.isEmpty(num)) {
            Toast.makeText(this, "请输入数字", Toast.LENGTH_SHORT).show();
            return;
        }
        final int rSize = Integer.parseInt(num);
        if (rSize <= 0) {
            Toast.makeText(this, "请输入大于0的数字", Toast.LENGTH_SHORT).show();
            return;
        }

        RecordOpenClose recordOpenClose = new RecordOpenClose();
        int[] arr = randArr(rSize, 1000, 2000);
        recordOpenClose.open("selectEndSortC");
        int[] selectEndSortC = selectionSort(arr, arr.length);
        recordOpenClose.close("selectEndSortC");
        recordOpenClose.open("selectEndSortJava");
        int[] selectEndSortJava = SortHelper.selectionSort(arr, arr.length);
        recordOpenClose.close("selectEndSortJava");
        recordOpenClose.addCompare("selectEndSortC", "selectEndSortJava");

        mTextView.setText(recordOpenClose.getResultString());
    }
}
