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
public class AddResultFragment extends Fragment implements Iset {
    public static String TAG = AddResultFragment.class.getSimpleName();

    public final int REQUEST_CODE_ADD_SET = 12;


    TextView title;

    @Bind(R.id.showResult)
    TextView showResult;

    boolean isSet = false;


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
        View view = inflater.inflate(R.layout.fragment_add_result_layout, container, false);


        title = (TextView) getActivity().findViewById(R.id.title);
        ButterKnife.bind(this, view);

        int num = getArguments().getInt("add_result");
        Log.d(TAG, "-----> onCreateView---num=" + num);
        showResult.setText(num + "");

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

//        if (isSet) {
//            Log.d(TAG, "-----> set----");
//            isSet = false;
//            Intent intent = getActivity().getIntent();
//            intent.setClass(getActivity(), SetActivity.class);
//
//            intent.putExtra("TAG", AddResultFragment.TAG);
//            startActivityForResult(intent, REQUEST_CODE_ADD_SET);
//
//        }
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
    public void set() {
        isSet = true;
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (data == null) {
//            return;
//        }
//        Log.d(TAG, "-----> onActivityResult---" + "requestCode=" + requestCode + ",resultCode=" + resultCode + "data=" + data.toString());
//
//        if (requestCode == REQUEST_CODE_ADD_SET && resultCode == SetActivity.RESULT_CODE_SET) {
//            showResult.setText(showResult.getText().toString() + "," + data.getIntExtra("set", 0));
//        }
//    }
}

