package com.hjq.kotlin.service

import com.hjq.kotlin.bean.GankBean
import com.hjq.kotlin.config.PanConfig
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * Created by hjq on 17-4-18.
 */
interface ApiService {
    data class ResponseWrapper<T>(val error : Boolean , val results: List<T>)

    @GET("data/福利/" + PanConfig.GANK_SIZE + "/{page}")
    fun getFuLi(@Path("page") page : Int) : Observable<ResponseWrapper<GankBean.ResultsBean>>

    @GET("data/休息视频/" + PanConfig.MEIZI_SIZE + "/{page}")
    fun getVideo(@Path("page") page: Int) : Observable<ResponseWrapper<GankBean.ResultsBean>>

    @GET("day/{year}/{month}/{day}")
    fun getDailyData(
    @Path("year") year : Int,
    @Path("month") month : Int,
    @Path("day") day : Int) : Observable<ResponseWrapper<GankBean.ResultsBean>>

    @GET("data/{type}/" + PanConfig.GANK_SIZE + "/{page}")
    fun getBatteryData(@Path("type") type : String, @Path("page") page : Int) : Observable<ResponseWrapper<GankBean.ResultsBean>>

}