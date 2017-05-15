package com.hjq.kotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import com.hjq.kotlin.R
import com.hjq.kotlin.service.ServiceManager
import me.yokeyword.fragmentation.SupportFragment
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

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
        initView(view)
        return view
    }

    private fun  initView(view: View?) {
        val webView = view?.findViewById(R.id.three_webview) as WebView

        ServiceManager.api.getVideo(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    resultsBeanResponseWrapper ->
                    webView.loadUrl(resultsBeanResponseWrapper.results[0].url)
                    //Log.e("------1>", resultsBeanResponseWrapper.results.toString())
                })
    }

}