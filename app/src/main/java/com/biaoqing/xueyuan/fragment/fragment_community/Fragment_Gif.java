package com.biaoqing.xueyuan.fragment.fragment_community;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.biaoqing.xueyuan.R;


/**
 * Created by YYL on 2017/4/29.
 */

public class Fragment_Gif extends Fragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_aboutme,container,false);
        initView(view);

        return view;
    }



    private void initView(View view) {

    }


    @Override
    public void onClick(View v) {

    }
}
