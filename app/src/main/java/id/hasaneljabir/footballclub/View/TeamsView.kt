package id.hasaneljabir.footballclub.view

import id.hasaneljabir.footballclub.model.Team

interface TeamsView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}