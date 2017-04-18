package com.hjq.kotlin;

import android.os.Bundle;

import com.hjq.kotlin.fragment.FirstTabFragment;
import com.hjq.kotlin.fragment.SecondTabFragment;
import com.hjq.kotlin.fragment.ThreeTabFragment;
import com.hjq.kotlin.view.BottomBar;
import com.hjq.kotlin.view.BottomBarTab;

import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity extends SupportActivity {
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int THIRD = 2;

    private SupportFragment[] fragments = new SupportFragment[3];
    private BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){
            FirstTabFragment first = new FirstTabFragment();
            ThreeTabFragment three = new ThreeTabFragment();
            fragments[FIRST] = first.newInstance();
            fragments[SECOND] = SecondTabFragment.newInstance();
            fragments[THIRD] = three.newInstance();

            loadMultipleRootFragment(R.id.fl_tab_container,FIRST,
                    fragments[FIRST],
                    fragments[SECOND],
                    fragments[THIRD]);
        }else {
            fragments[FIRST] = findFragment(FirstTabFragment.class);
            fragments[SECOND] = findFragment(SecondTabFragment.class);
            fragments[THIRD] = findFragment(ThreeTabFragment.class);
        }
        initView();
    }

    private void initView() {
        bottomBar = (BottomBar) this.findViewById(R.id.bottomBar);
        bottomBar.addItem(new BottomBarTab(this,R.drawable.ic_android_red_800_24dp,"shouye"))
                .addItem(new BottomBarTab(this,R.drawable.ic_favorite_border_white_24dp,"shoucang"))
                .addItem(new BottomBarTab(this, R.drawable.ic_account_circle_white_24dp,"wode"));
        bottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener(){

            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideFragment(fragments[position],fragments[prePosition]);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }
}