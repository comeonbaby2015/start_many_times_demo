package android_native.demo;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import android_natiove.demo.android_natiove.demo.R;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hades on 2016/1/14.
 */
public class MultiResultFragment extends Fragment implements Iset {
    public static String TAG = MultiResultFragment.class.getSimpleName();
    public final int REQUEST_CODE_MULTI_SET = 10;


    TextView title;

    @Bind(R.id.showResult)
    TextView showResult;

    @Override
    public void onAttach(Activity activity) {
        Log.d(TAG, "-----> onAttach----");
        super.onAttach(activity);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "-----> onCreate----");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "-----> onCreateView----");

        View view = inflater.inflate(R.layout.fragment_multi_result_layout, container, false);

        title = (TextView) getActivity().findViewById(R.id.title);
        ButterKnife.bind(this, view);

        showResult.setText(Integer.toString(getArguments().getInt("multi_result")));

        setRetainInstance(true);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d(TAG, "-----> onActivityCreated----");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "-----> onStart----");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "-----> onResume----");
    }


    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "-----> onConfigurationChanged----");
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "-----> onDestroyView----");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "-----> onDestroy----");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "-----> onDetach----");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "-----> onActivityResult---" + "requestCode=" + requestCode + ",resultCode=" + resultCode + "data=" + data.toString());

        if (requestCode == REQUEST_CODE_MULTI_SET && resultCode == SetActivity.RESULT_CODE_SET) {
            showResult.setText(showResult.getText().toString() + "," + data.getIntExtra("set", 0));
        }
    }

    @Override
    public void set() {

        Intent intent = getActivity().getIntent();
        intent.setClass(getActivity(), SetActivity.class);

        intent.putExtra("TAG", MultiResultFragment.TAG);
        startActivityForResult(intent, REQUEST_CODE_MULTI_SET);

    }
}
