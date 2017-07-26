package com.biaoqing.xueyuan.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.biaoqing.xueyuan.R;
import com.biaoqing.xueyuan.adapter.MyFragmentPagerAdapter;


/**
 * Created by YYL on 2017/4/29.
 */

public class Fragment_Community extends Fragment implements View.OnClickListener{
    TabLayout mTablayout;
    ViewPager mViewPager;
    private TabLayout.Tab tab_Selected,tab_Ranking,tab_Gif,tab_Original;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_community,container,false);
        initViews(view);
        initEvents(view);

        return view;
    }




    private void initViews(View view) {
        mTablayout= (TabLayout) view.findViewById(R.id.tabLayout_home_fragment);



        mViewPager= (ViewPager) view.findViewById(R.id.viewPager_home_fragment);
//getSupportFragmentManager()方法在Activity中使用
        //        嵌套Fragment拿到FragmentManager要用这个方法 getChildFragmentManager()

        mViewPager.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager()));

        mTablayout.setupWithViewPager(mViewPager);
//初始化tab
        tab_Selected=mTablayout.getTabAt(0);
        tab_Ranking=mTablayout.getTabAt(1);
        tab_Gif=mTablayout.getTabAt(2);
        tab_Original=mTablayout.getTabAt(3);

        //初始化第一个
        mViewPager.setCurrentItem(0);


        setIndicator(mTablayout, 10, 10);
//        http://blog.csdn.net/hedong_77/article/details/52972032

    }

    private void initEvents(View view) {
        mTablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab == mTablayout.getTabAt(0)) {
                    mViewPager.setCurrentItem(0);
                } else if (tab == mTablayout.getTabAt(1)) {
                    mViewPager.setCurrentItem(1);
                } else if (tab == mTablayout.getTabAt(2)) {

                    mViewPager.setCurrentItem(2);
                }else if (tab == mTablayout.getTabAt(3)){
                    mViewPager.setCurrentItem(3);
                }
//                else if (tab == mTablayout.getTabAt(4)){
//                    tablayoutMe.setIcon(getResources().getDrawable(R.drawable.img_me_pressed));
//
//                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
//                if (tab == mTablayout.getTabAt(0)) {
//                    tablayoutHome.setIcon(getResources().getDrawable(R.drawable.img_home_normal));
//                } else if (tab == mTablayout.getTabAt(1)) {
//                    tablayoutShopping.setIcon(getResources().getDrawable(R.drawable.img_shop_normal));
//                } else if (tab == mTablayout.getTabAt(2)) {
//                    tablayoutUseDetail.setIcon(getResources().getDrawable(R.drawable.img_use_detail_normal));
//                }else if (tab == mTablayout.getTabAt(3)){
//                    tablayoutMe.setIcon(getResources().getDrawable(R.drawable.img_me_normal));
//                }
//                else if (tab == mTablayout.getTabAt(4)){
//                    tablayoutMe.setIcon(getResources().getDrawable(R.drawable.img_me_normal));
//
//                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onClick(View v) {

    }


//设置TabLayout下划线长度
//    注意1：Tablayout的Mode必须得设置为fixed,否则会滑动
//    示例：app:tabMode=”fixed”
//
//    注意2：Tablayout的宽不能写死，得设置为包裹内容
    public void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        java.lang.reflect.Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());
        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }


    }




}
