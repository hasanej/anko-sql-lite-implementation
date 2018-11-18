package id.hasaneljabir.footballclub.fragment.teams

import com.google.gson.Gson
import id.hasaneljabir.footballclub.api.ApiRepository
import id.hasaneljabir.footballclub.api.TheSportDBApi
import id.hasaneljabir.footballclub.model.TeamResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TeamsPresenter(
    private val view: TeamsView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {
    fun getTeamList(league: String?) {
        view.showLoading()

        GlobalScope.launch(Dispatchers.Main) {
            val data = gson.fromJson(
                apiRepository
                    .doRequest(TheSportDBApi.getTeams(league)).await(),
                TeamResponse::class.java
            )

            view.showTeamList(data.teams)
            view.hideLoading()
        }
    }
}