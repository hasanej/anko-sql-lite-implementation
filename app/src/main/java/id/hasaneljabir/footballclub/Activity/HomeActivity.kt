package id.hasaneljabir.footballclub.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import id.hasaneljabir.footballclub.R
import id.hasaneljabir.footballclub.R.id.favorites
import id.hasaneljabir.footballclub.R.id.teams
import id.hasaneljabir.footballclub.fragment.favoriteTeams.FavoriteTeamsFragment
import id.hasaneljabir.footballclub.fragment.teams.TeamsFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                teams -> { loadTeamsFragment(savedInstanceState) }
                favorites -> { loadFavoritesFragment(savedInstanceState) }
            }
            true
        }

        bottom_navigation.selectedItemId = teams
    }

    private fun loadTeamsFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container,
                    TeamsFragment(), TeamsFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun loadFavoritesFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container,
                    FavoriteTeamsFragment(), FavoriteTeamsFragment::class.java.simpleName)
                .commit()
        }
    }
}