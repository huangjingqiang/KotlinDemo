package com.hjq.kotlin.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hjq.kotlin.R;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by hjq on 17-4-18.
 */

public class SecondTabFragment extends SupportFragment{

    public static SecondTabFragment newInstance(){
        Bundle args = new Bundle();
        SecondTabFragment fragment = new SecondTabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second,container,false);
        return view;
    }
}
