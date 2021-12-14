package com.amrilhs.italiseria_app.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.amrilhs.italiaseria.core.domain.model.SeriAModel
import com.amrilhs.italiseria_app.R
import com.amrilhs.italiseria_app.databinding.ActivityDetailItaliSeriaBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailItaliSeriaActivity : AppCompatActivity() {


    private lateinit var detailItaliSeriaBinding: ActivityDetailItaliSeriaBinding
    private val detailSerialViewModel: DetailSeriaViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailItaliSeriaBinding = ActivityDetailItaliSeriaBinding.inflate(layoutInflater)
        setContentView(detailItaliSeriaBinding.root)

        val detailItaliaSeriA = intent.getParcelableExtra<SeriAModel>(INTENT_DATA)
        showDetailItaliSeria(detailItaliaSeriA)

        val toolbar: Toolbar = detailItaliSeriaBinding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.title = resources.getString(R.string.detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    @SuppressLint("SetTextI18n")
    private fun showDetailItaliSeria(detailItaliaSeriA: SeriAModel?) {
        detailItaliaSeriA?.let {
            supportActionBar?.title = detailItaliaSeriA.strTeam
            Glide.with(this)
                .load(detailItaliaSeriA.strStadiumThumb)
                .apply(
                    RequestOptions().override(
                        SCREEN_W,
                        SCREEN_H
                    )
                )
                .error(R.drawable.ic_baseline_error_24)
                .into(detailItaliSeriaBinding.ivDetailImage)

            detailItaliSeriaBinding.apply {
                content.tvDetailDescription.text = detailItaliaSeriA.strDescriptionEN
                strTeam.text = detailItaliaSeriA.strTeam + ", " + detailItaliaSeriA.intFormedYear
                strStadium.text =
                    detailItaliaSeriA.strStadium + ", " + detailItaliaSeriA.strStadiumLocation + "," + detailItaliaSeriA.strCountry

            }

            Glide.with(this)
                .load(detailItaliaSeriA.strTeamJersey)
                .apply(
                    RequestOptions().override(
                        SCREEN_W,
                        SCREEN_H
                    )
                )
                .error(R.drawable.ic_baseline_error_24)
                .into(detailItaliSeriaBinding.strTeamJersey)

            var statusFavorite = detailItaliaSeriA.isFavorite
            setStatusFavorite(statusFavorite)
            detailItaliSeriaBinding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailSerialViewModel.setFavoriteItaliaSeriA(detailItaliaSeriA, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }

    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            detailItaliSeriaBinding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_white
                )
            )
        } else {
            detailItaliSeriaBinding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_not_favorite_white
                )
            )
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val INTENT_DATA = "intent_data"
        const val SCREEN_W: Int = 800
        const val SCREEN_H: Int = 600
    }
}