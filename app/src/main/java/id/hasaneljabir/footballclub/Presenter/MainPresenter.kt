package id.hasaneljabir.footballclub.Presenter

import com.google.gson.Gson
import id.hasaneljabir.footballclub.API.ApiRepository
import id.hasaneljabir.footballclub.API.TheSportDBApi
import id.hasaneljabir.footballclub.View.MainView
import id.hasaneljabir.footballclub.Model.TeamResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(
    private val view: MainView,
    private val apiRepository: ApiRepository,
    private val gson: Gson) {

    fun getTeamList(league: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeams(league)),
                TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }
}