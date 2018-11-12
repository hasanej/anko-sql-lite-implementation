package id.hasaneljabir.footballclub.View

import id.hasaneljabir.footballclub.Model.Team

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}