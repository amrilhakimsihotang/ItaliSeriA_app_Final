package com.amrilhs.italiseria.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.amrilhs.italiaseria.core.ui.SeriaAdapter
import com.amrilhs.italiseria.favorite.databinding.ActivityFavoriteBinding
import com.amrilhs.italiseria_app.R
import com.amrilhs.italiseria_app.detail.DetailItaliSeriaActivity
import com.amrilhs.italiseria_app.di.FavoriteModuleDependencies
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val favoriteViewModel: FavoriteViewModel by viewModels {
        factory
    }

    private lateinit var favoriteBinding: ActivityFavoriteBinding
    private lateinit var seriaAdapter: SeriaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFavoriteComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    FavoriteModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)

        super.onCreate(savedInstanceState)
        favoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(favoriteBinding.root)

        supportActionBar?.title = resources.getString(R.string.header_favorite)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        seriaAdapter = SeriaAdapter()
        seriaAdapter.onItemClick = { selectedData ->
            val mIntent = Intent(this, DetailItaliSeriaActivity::class.java)
            mIntent.putExtra(DetailItaliSeriaActivity.INTENT_DATA, selectedData)
            startActivity(mIntent)
        }

        favoriteViewModel.favoriteTeam.observe(this, { dataTeam ->
            if (dataTeam != null) {
                seriaAdapter.setData(dataTeam)
                favoriteBinding.viewEmpty.root.visibility =
                    if (dataTeam.isNotEmpty()) View.GONE else View.VISIBLE

                with(favoriteBinding.rvItaliaseria) {
                    layoutManager = LinearLayoutManager(this@FavoriteActivity)
                    setHasFixedSize(true)
                    adapter = seriaAdapter
                }

            }

        })

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}