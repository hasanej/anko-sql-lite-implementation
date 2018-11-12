package id.hasaneljabir.footballclub.view

import id.hasaneljabir.footballclub.model.Team

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}