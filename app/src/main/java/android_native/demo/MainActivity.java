package android_native.demo;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.demo.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {
    public static String TAG = MainActivity.class.getSimpleName();

    private int REQUEST_CODE_ADD = 100;
    private int REQUEST_CODE_MULTI = REQUEST_CODE_ADD + 1;

    @Bind(R.id.title)
    TextView title;


    @Bind(R.id.newBtn)
    Button newBtn;

    @Bind(R.id.openBtn)
    Button openBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        title.setText("Main");

        newBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getFragmentManager().beginTransaction().replace(R.id.content,)
                Intent intent = getIntent();
                intent.setClass(MainActivity.this, AddActivity.class);
                intent.putExtra("num1", 10);
                intent.putExtra("num2", 20);
                startActivityForResult(intent, REQUEST_CODE_ADD);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ADD || resultCode == AddActivity.RESULT_CODE_ADD) {
            Bundle bundle = new Bundle();
            bundle.putInt("add_result", data.getIntExtra("add_result", 0));

            Fragment fragment = new AddResultFragment();
            getFragmentManager().beginTransaction().replace(R.id.content, fragment, AddResultFragment.TAG).addToBackStack(AddResultFragment.TAG).commit();
        }

        if (requestCode == REQUEST_CODE_MULTI || resultCode == MultiActivity.RESULT_CODE_MULTI) {
            Bundle bundle = new Bundle();
            bundle.putInt("multi_result", data.getIntExtra("multi_result", 0));

            Fragment fragment = new MultiResultFragment();
            getFragmentManager().beginTransaction().replace(R.id.content, fragment, MultiResultFragment.TAG).addToBackStack(AddResultFragment.TAG).commit();
        }
    }
}
