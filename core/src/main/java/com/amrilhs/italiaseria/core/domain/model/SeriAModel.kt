package com.amrilhs.italiaseria.core.domain.model

import android.os.Parcelable
//import kotlinx.android.parcel.Parcelize
import kotlinx.parcelize.Parcelize

@Parcelize
data class SeriAModel(

    val idTeam: String? = null,
    val strTeam: String? = null,
    val intFormedYear: String? = null,
    val strLeague: String? = null,
    val strCountry: String? = null,
    val strDescriptionEN: String? = null,
    val strTeamJersey: String? = null,
    val strTeamBadge: String? = null,
    val strStadium: String? = null,
    val strStadiumLocation: String? = null,
    val strStadiumThumb: String? = null,
    var isFavorite: Boolean

) : Parcelable