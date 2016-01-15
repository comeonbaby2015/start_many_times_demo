package android_native.demo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import android_natiove.demo.android_natiove.demo.R;

/**
 * Created by hades on 2016/1/14.
 */
public class AddActivity extends Activity {
    public static String TAG = AddActivity.class.getSimpleName();
    public static final int RESULT_CODE_ADD = 10000;

    @Bind(R.id.title)
    TextView title;

    @Bind(R.id.back)
    Button back;

    @Bind(R.id.result)
    EditText result;

    @Bind(R.id.data)
    TextView data;

    int num1;
    int num2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "-----> onCreate----");

        setContentView(R.layout.activity_add_layout);

        ButterKnife.bind(this);

        title.setText("Add");
        back.setText("Back");

        Intent intent = getIntent();

        num1 = intent.getIntExtra("num1", 0);
        num2 = intent.getIntExtra("num2", 0);

        data.setText(num1 + " + " + num2 + "=");
        result.setText(Integer.toString(num1 + num2));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("add_result", num1 + num2);
                setResult(RESULT_CODE_ADD, intent);
                finish();
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "-----> onResume----");
    }

    @Override
    protected void onPause() {

        super.onPause();
        Log.d(TAG, "-----> onPause----");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "-----> onDestroy----");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "-----> onConfigurationChanged----");
    }

    @Override
    public Object onRetainNonConfigurationInstance() {
        Log.d(TAG, "-----> onRetainNonConfigurationInstance----");
        return super.onRetainNonConfigurationInstance();
    }
}
