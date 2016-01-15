package android_native.demo;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import android_natiove.demo.android_natiove.demo.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {
    public static String TAG = MainActivity.class.getSimpleName();

    private int REQUEST_CODE_ADD = 100;
    private int REQUEST_CODE_MULTI = REQUEST_CODE_ADD + 1;

    public final int REQUEST_CODE_ADD_SET = 12;
    public final int REQUEST_CODE_MULTI_SET = 10;

    @Bind(R.id.title)
    TextView title;

    @Bind(R.id.back)
    Button back;

    @Bind(R.id.add)
    Button addBtn;

    @Bind(R.id.multi)
    Button multiBtn;

    @Bind(R.id.setBtn)
    Button setBtn;

    // http://stackoverflow.com/questions/22505327/android-save-restore-fragment-state
    // http://stackoverflow.com/questions/11160412/why-use-fragmentsetretaininstanceboolean#comment23042138_11160506
    // http://stackoverflow.com/questions/15313598/once-for-all-how-to-correctly-save-instance-state-of-fragments-in-back-stack
    // http://stackoverflow.com/questions/9294603/get-currently-displayed-fragment


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "-----> onCreate----");

        ButterKnife.bind(this);

        title.setText("Main");

        back.setVisibility(View.INVISIBLE);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                intent.putExtra("num1", 10);
                intent.putExtra("num2", 20);
                startActivityForResult(intent, REQUEST_CODE_ADD);
            }
        });

        multiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MultiActivity.class);
                intent.putExtra("num1", 10);
                intent.putExtra("num2", 20);
                startActivityForResult(intent, REQUEST_CODE_MULTI);
            }
        });

        setBtn = (Button) findViewById(R.id.setBtn);

        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "" + getActiveFragment2());
                //((Iset)getActiveFragment()).set();

                Intent intent = getIntent();
                intent.setClass(MainActivity.this, SetActivity.class);

                if (AddResultFragment.TAG == getActiveFragment2()) {
                    intent.putExtra("TAG", AddResultFragment.TAG);
                    startActivityForResult(intent, REQUEST_CODE_ADD_SET);

                } else if (MultiResultFragment.TAG == getActiveFragment2()) {
                    intent.putExtra("TAG", MultiResultFragment.TAG);
                    startActivityForResult(intent, REQUEST_CODE_MULTI_SET);
                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "-----> onActivityResult----data=" + data.toString() + "requestCode=" + requestCode + ",resultCode=" + resultCode);

        if (data == null) {
            return;
        }

        if (requestCode == REQUEST_CODE_ADD && resultCode == AddActivity.RESULT_CODE_ADD) {
            Bundle bundle = new Bundle();
            bundle.putInt("add_result", data.getIntExtra("add_result", 0));

            Log.d(TAG, "-----> onActivityResult---- if1111 ");

            Fragment fragment = getFragmentManager().findFragmentByTag(AddResultFragment.TAG);
            if (null == fragment) {
                fragment = new AddResultFragment();
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.content, fragment, AddResultFragment.TAG).addToBackStack(AddResultFragment.TAG).commit();
                Log.d(TAG, "-----> onActivityResult---- if22222 ");

            } else {
                getFragmentManager().popBackStack(AddResultFragment.TAG, 0);
            }

        }

        if (requestCode == REQUEST_CODE_MULTI && resultCode == MultiActivity.RESULT_CODE_MULTI) {

            Bundle bundle = new Bundle();
            bundle.putInt("multi_result", data.getIntExtra("multi_result", 0));

            Fragment fragment = getFragmentManager().findFragmentByTag(MultiResultFragment.TAG);

            Log.d(TAG, "-----> onActivityResult---- if5555 ");


            if (null == fragment) {
                fragment = new MultiResultFragment();
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.content, fragment, MultiResultFragment.TAG).addToBackStack(MultiResultFragment.TAG).commit();
                Log.d(TAG, "-----> onActivityResult---- if6666 ");
            } else {
                getFragmentManager().popBackStack(MultiResultFragment.TAG, 0);
            }

        }

        if (requestCode == REQUEST_CODE_ADD_SET && resultCode == SetActivity.RESULT_CODE_SET) {


        }
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

    public Fragment getActiveFragment() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            return null;
        }
        String tag = getFragmentManager().getBackStackEntryAt(getFragmentManager().getBackStackEntryCount() - 1).getName();
        return getFragmentManager().findFragmentByTag(tag);
    }

    public String getActiveFragment2() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            return null;
        }
        String tag = getFragmentManager().getBackStackEntryAt(getFragmentManager().getBackStackEntryCount() - 1).getName();
        return tag;
    }
}
