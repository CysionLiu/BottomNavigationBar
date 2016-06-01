package com.cysion.bottomnavigationbar.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cysion.bottomnavigationbar.R;


/**
 * Created by Administrator on 2016/5/31 0031.
 */
public class HoneFragment extends Fragment {

    private View mView;
    private Activity mActivity;
    private Bundle mArguments;
    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.home_fragment, container, false);
        mActivity = getActivity();
        mArguments = getArguments();
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTextView = (TextView) mView.findViewById(R.id.text_home_fragment);
        mTextView.setText(mArguments.getString("title"));
    }
}
