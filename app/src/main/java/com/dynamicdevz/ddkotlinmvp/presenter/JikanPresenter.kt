package com.dynamicdevz.ddkotlinmvp.presenter

import com.dynamicdevz.ddkotlinmvp.model.JikanResponse
import com.dynamicdevz.ddkotlinmvp.model.network.JikanRetrofit
import com.dynamicdevz.ddkotlinmvp.util.State
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JikanPresenter(private val view: PresenterContract.View): PresenterContract.Presenter {


    override fun searchAnime(query: String) {
        view.updateState(State.LOADING)

        JikanRetrofit.getJikan(query)
            .enqueue(object: Callback<JikanResponse>{
                override fun onResponse(
                    call: Call<JikanResponse>,
                    response: Response<JikanResponse>
                ) {
                    response.body()?.let {
                        view.displayResults(it.results)
                        view.updateState(State.COMPLETE)
                    } ?: run {
                        view.updateState(State.ERROR)
                        view.showError("Results were null.")
                    }
                }

                override fun onFailure(call: Call<JikanResponse>, t: Throwable) {
                    view.updateState(State.ERROR)
                    view.showError("There was an issue.")
                }
            })
    }
}