package com.biaoqing.xueyuan.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.biaoqing.xueyuan.fragment.fragment_community.Fragment_Gif;
import com.biaoqing.xueyuan.fragment.fragment_community.Fragment_Original;
import com.biaoqing.xueyuan.fragment.fragment_community.Fragment_Ranking;
import com.biaoqing.xueyuan.fragment.fragment_community.Fragment_Selected;


/**
 * Created by YYL on 2016/7/13.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"热门精选", "人气榜","动图", "真人原创"};
//    private String[] mTitles = new String[]{"", "", "",""};

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new Fragment_Selected();
        }
        if (position == 1) {
            return new Fragment_Ranking();
        } else if (position == 2) {
            return new Fragment_Gif();
        }else if (position==3){
            return new Fragment_Original();
        }
//        else if(position==4){
//            return new FragmentAboutMe();
//
//        }
        return new Fragment_Selected();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);

    }




}
