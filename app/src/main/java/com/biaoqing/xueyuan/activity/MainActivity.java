package com.biaoqing.xueyuan.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.biaoqing.xueyuan.R;
import com.biaoqing.xueyuan.fragment.Fragment_AboutMe;
import com.biaoqing.xueyuan.fragment.Fragment_Collections;
import com.biaoqing.xueyuan.fragment.Fragment_Community;
import com.biaoqing.xueyuan.fragment.Fragment_Messages;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
private RadioGroup radioGroup;
    private RadioButton radio_community,radio_messages,radio_collections,radio_aboutme;

    private Fragment fragment_Community;
    private Fragment fragment_Messages;
    private Fragment fragment_Collections;
    private Fragment fragment_AboutMe;

    private List<Fragment> list;
    private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化页面
        initView();
    }

    private void initView() {


        frameLayout = (FrameLayout) findViewById(R.id.framelayout);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        //找到四个按钮
        radio_community= (RadioButton) findViewById(R.id.radio_community);
        radio_messages= (RadioButton) findViewById(R.id.radio_messages);
        radio_collections= (RadioButton) findViewById(R.id.radio_collections);
        radio_aboutme= (RadioButton) findViewById(R.id.radio_aboutme);

        //创建Fragment对象及集合
        fragment_Community=new Fragment_Community();
        fragment_Messages=new Fragment_Messages();
        fragment_Collections=new Fragment_Collections();
        fragment_AboutMe=new Fragment_AboutMe();

        //将Fragment对象添加到list中
        list=new ArrayList<>();
        list.add(fragment_Community);
        list.add(fragment_Messages);
        list.add(fragment_Collections);
        list.add(fragment_AboutMe);

        //设置RadioGroup开始时设置的按钮，设置第一个按钮为默认值
        radioGroup.check(R.id.radio_community);

        //设置按钮点击监听
        radio_community.setOnClickListener(this);
        radio_messages.setOnClickListener(this);
        radio_collections.setOnClickListener(this);
        radio_aboutme.setOnClickListener(this);

        //初始时向容器中添加第一个Fragment对象
        addFragment(fragment_Community);
    }


    //向Activity中添加Fragment的方法
    public void addFragment(Fragment fragment) {

        //获得Fragment管理器
        FragmentManager fragmentManager = getSupportFragmentManager();
        //使用管理器开启事务
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //使用事务替换Fragment容器中Fragment对象
        fragmentTransaction.replace(R.id.framelayout,fragment);
        //提交事务，否则事务不生效
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        //我们根据参数的id区别不同按钮
        //不同按钮对应着不同的Fragment对象页面
        switch (v.getId()){
            case R.id.radio_community:
                 addFragment(fragment_Community);
                break;
            case R.id.radio_messages:
                addFragment(fragment_Messages);
                break;
            case R.id.radio_collections:
                addFragment(fragment_Collections);

                break;
            case R.id.radio_aboutme:
                addFragment(fragment_AboutMe);
                break;

        }
    }

    @Override
    public void finish() {
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        viewGroup.removeAllViews();
        super.finish();
    }
}
