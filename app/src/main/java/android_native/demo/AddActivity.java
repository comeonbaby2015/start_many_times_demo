package android_native.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_layout);

        ButterKnife.bind(this);

        title.setText("Add");
        back.setText("Back");

        Intent intent = getIntent();

        int num1 = intent.getIntExtra("num1", 0);
        int num2 = intent.getIntExtra("num2", 0);

        data.setText(num1 + " + " + num2 + "=");
        result.setText(Integer.toString(num1 + num2));


        // Intent intent2 = new Intent();
        // intent2.putExtra("A_response", "A返回数据了");
        // setResult(101, intent2);
        intent.putExtra("add_result", num1 + num2);
        setResult(RESULT_CODE_ADD, intent);
        finish();

    }
}
