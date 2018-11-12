package id.hasaneljabir.footballclub.presenter

import com.google.gson.Gson
import id.hasaneljabir.footballclub.api.ApiRepository
import id.hasaneljabir.footballclub.api.TheSportDBApi
import id.hasaneljabir.footballclub.model.TeamResponse
import id.hasaneljabir.footballclub.view.TeamDetailView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamDetailPresenter(
    private val view: TeamDetailView,
    private val apiRepository: ApiRepository,
    private val gson: Gson) {

    fun getTeamDetail(teamId: String) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeamDetail(teamId)),
                TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamDetail(data.teams)
            }
        }
    }
}