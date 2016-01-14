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
public class MultiActivity extends Activity {
    public static String TAG = MultiActivity.class.getSimpleName();
    public static final int RESULT_CODE_MULTI = 20000;

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
        setContentView(R.layout.activity_multi_layout);

        ButterKnife.bind(this);

        title.setText("Multi");
        back.setText("Back");

        Intent intent = getIntent();
        int num1 = intent.getIntExtra("num1", 0);
        int num2 = intent.getIntExtra("num2", 0);

        data.setText(num1 + " * " + num2 + "=");
        result.setText(Integer.toString(num1 * num2));

        intent.putExtra("multi_result", num1 * num2);
        setResult(RESULT_CODE_MULTI, intent);
        finish();

    }
}
