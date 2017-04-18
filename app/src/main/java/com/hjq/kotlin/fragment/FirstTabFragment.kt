package com.hjq.kotlin.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hjq.kotlin.R
import com.hjq.kotlin.adapter.FirstAdapter
import com.hjq.kotlin.bean.GankBean
import com.hjq.kotlin.service.ServiceManager
import me.yokeyword.fragmentation.SupportFragment
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by hjq on 17-4-18.
 */
class FirstTabFragment : SupportFragment() {
    val fuli = ArrayList<GankBean.ResultsBean>()
    val adapter = FirstAdapter(fuli)

     fun newInstance(): FirstTabFragment {
        val args: Bundle = Bundle()
        val fragment: FirstTabFragment = FirstTabFragment()
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_first, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View?) {
        val recyclerView = view?.findViewById(R.id.recyclerview) as RecyclerView?
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        recyclerView?.adapter = adapter

        ServiceManager.api.getFuLi(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    resultsBeanResponseWrapper -> Log.e("------1>", resultsBeanResponseWrapper.results.toString())
                    fuli.clear()
                    fuli.addAll(resultsBeanResponseWrapper.results)
                    adapter.notifyDataSetChanged()
                }) {
                    throwable -> Log.e("---------2>", throwable.message)
                }
    }
}