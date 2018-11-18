package id.hasaneljabir.footballclub.activity.teamDetail

import id.hasaneljabir.footballclub.model.Team

interface TeamDetailView {
    fun showLoading()
    fun hideLoading()
    fun showTeamDetail(data: List<Team>)
}