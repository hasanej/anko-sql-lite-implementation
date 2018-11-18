package id.hasaneljabir.footballclub.fragment.teams

import com.google.gson.Gson
import id.hasaneljabir.footballclub.api.ApiRepository
import id.hasaneljabir.footballclub.api.TheSportDBApi
import id.hasaneljabir.footballclub.model.TeamResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamsPresenter(
    private val view: TeamsView,
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