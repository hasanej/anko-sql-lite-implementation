package id.hasaneljabir.footballclub.view

import id.hasaneljabir.footballclub.model.Team

interface TeamDetailView {
    fun showLoading()
    fun hideLoading()
    fun showTeamDetail(data: List<Team>)
}