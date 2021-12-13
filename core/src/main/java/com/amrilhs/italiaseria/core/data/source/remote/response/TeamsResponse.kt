package com.amrilhs.italiaseria.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TeamsResponse(

    @field:SerializedName("idTeam")
    val idTeam: String,

    @field:SerializedName("strTeam")
    val strTeam: String,

    @field:SerializedName("intFormedYear")
    val intFormedYear: String,

    @field:SerializedName("strLeague")
    val strLeague: String,

    @field:SerializedName("strDescriptionEN")
    val strDescriptionEN: String,

    @field:SerializedName("strCountry")
    val strCountry: String,

    @field:SerializedName("strTeamJersey")
    val strTeamJersey: String,

    @field:SerializedName("strTeamBadge")
    val strTeamBadge: String,

    //stadium
    @field:SerializedName("strStadium")
    val strStadium: String,

    @field:SerializedName("strStadiumLocation")
    val strStadiumLocation: String,

    @field:SerializedName("strStadiumThumb")
    val strStadiumThumb: String? = null,


    )
