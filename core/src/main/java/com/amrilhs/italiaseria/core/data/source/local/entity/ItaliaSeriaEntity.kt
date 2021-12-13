package com.amrilhs.italiaseria.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "italiaseria")
data class ItaliaSeriaEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idTeam")
    val idTeam: String,

    @ColumnInfo(name = "strTeam")
    val strTeam: String,

    @field:SerializedName("intFormedYear")
    val intFormedYear: String,

    @ColumnInfo(name = "strLeague")
    val strLeague: String,

    @ColumnInfo(name = "strCountry")
    val strCountry: String,

    @ColumnInfo(name = "strDescriptionEN")
    val strDescriptionEN: String,

    @ColumnInfo(name = "strTeamJersey")
    val strTeamJersey: String,

    @ColumnInfo(name = "strTeamBadge")
    val strTeamBadge: String,

    @ColumnInfo(name = "strStadium")
    val strStadium: String,

    @ColumnInfo(name = "strStadiumLocation")
    val strStadiumLocation: String,

    @ColumnInfo(name = "strStadiumThumb")
    val strStadiumThumb: String? = null,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)