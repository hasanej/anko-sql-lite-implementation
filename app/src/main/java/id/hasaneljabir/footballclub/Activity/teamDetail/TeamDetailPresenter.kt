package id.hasaneljabir.footballclub.activity.teamDetail

import com.google.gson.Gson
import id.hasaneljabir.footballclub.api.ApiRepository
import id.hasaneljabir.footballclub.api.TheSportDBApi
import id.hasaneljabir.footballclub.model.TeamResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TeamDetailPresenter(
    private val view: TeamDetailView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {
    fun getTeamDetail(teamId: String) {
        view.showLoading()

        GlobalScope.launch(Dispatchers.Main) {
            val data = gson.fromJson(
                apiRepository
                    .doRequest(TheSportDBApi.getTeamDetail(teamId)).await(),
                TeamResponse::class.java
            )

            view.showTeamDetail(data.teams)
            view.hideLoading()
        }
    }
}