package com.cysion.bottomnavigationbar.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * Created by Administrator on 2016/5/31 0031.
 */
public class HomePagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentList;
    private List<String> mTitles;


    /**
     * Instantiates a new Home pager adapter.
     *
     * @param fm            the fm
     * @param aFragmentList the a fragment list
     * @param titles        the titles
     */
    public HomePagerAdapter(FragmentManager fm, List<Fragment> aFragmentList, List<String> titles) {
        super(fm);
        mFragmentList = aFragmentList;
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
