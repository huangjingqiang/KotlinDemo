package com.hjq.kotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hjq.kotlin.R
import me.yokeyword.fragmentation.SupportFragment

/**
 * Created by hjq on 17-4-18.
 */
class ThreeTabFragment : SupportFragment(){

    fun newInstance() : ThreeTabFragment{
        val args : Bundle = Bundle()
        val fragment : ThreeTabFragment = ThreeTabFragment()
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_three,container,false)
        return view
    }

}