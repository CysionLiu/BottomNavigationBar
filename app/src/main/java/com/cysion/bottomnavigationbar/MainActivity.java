package com.cysion.bottomnavigationbar;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;

import com.cysion.bottomnavigationbar.adapter.HomePagerAdapter;
import com.cysion.bottomnavigationbar.fragment.HoneFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Main activity.
 * created by cysion
 */
public class MainActivity extends AppCompatActivity {

    private TabLayout mTablayout;
    private ViewPager mViewPager;
    private List<Fragment> mFragments;
    private List<String> mTitles;
    private HomePagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initview();
        loadData();
        setViewEvent();
    }

    /**
     * init views
     */
    private void initview() {
        mTablayout = (TabLayout) findViewById(R.id.tab_layout_main);
        mViewPager = (ViewPager) findViewById(R.id.viewpager_main);
    }

    /**
     * load native data,create fragments and titles
     */
    private void loadData() {
        mFragments = new ArrayList<>();
        mTitles = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            mTitles.add("tab" + i);
            HoneFragment tabfrag = new HoneFragment();
            Bundle bud = new Bundle();
            bud.putString("title", "fragment" + i);
            tabfrag.setArguments(bud);
            mFragments.add(tabfrag);
        }
    }

    /**
     * set up events for views
     * combine viewpager-adapter-tablayout
     */
    private void setViewEvent() {
        mAdapter = new HomePagerAdapter(getSupportFragmentManager(), mFragments, mTitles);
        mViewPager.setAdapter(mAdapter);
        mTablayout.setupWithViewPager(mViewPager);
        int tabCount = mTablayout.getTabCount();
        for (int i = 0; i < tabCount; i++) {
            //it is necessary
            mTablayout.getTabAt(i).setIcon(R.drawable.tab_item_selector);
            /*
             TextView whose id is @android:id/text1 will be regard as
            the system text for tablayout and it is the same to the ImageView
            whose id is @android:id/icon. it is noted that the top indicator
            needs a rotation of layout.
             */
            mTablayout.getTabAt(i).setCustomView(R.layout.tab_item);
        }
        //to make the first tab selected.
        mViewPager.setCurrentItem(1);
        mViewPager.setCurrentItem(0);
    }
}
