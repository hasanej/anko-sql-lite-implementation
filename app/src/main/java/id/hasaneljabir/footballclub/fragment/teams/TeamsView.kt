package id.hasaneljabir.footballclub.fragment.teams

import id.hasaneljabir.footballclub.model.Team

interface TeamsView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}