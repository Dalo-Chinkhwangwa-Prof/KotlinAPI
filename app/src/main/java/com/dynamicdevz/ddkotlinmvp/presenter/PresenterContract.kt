package com.dynamicdevz.ddkotlinmvp.presenter

import com.dynamicdevz.ddkotlinmvp.model.Result
import com.dynamicdevz.ddkotlinmvp.util.State

interface PresenterContract {

    interface Presenter {
        fun searchAnime(query: String)
    }

    interface View {
        fun displayResults(jikans: List<Result>)
        fun updateState(state: State)
        fun showError(message: String)
    }

}