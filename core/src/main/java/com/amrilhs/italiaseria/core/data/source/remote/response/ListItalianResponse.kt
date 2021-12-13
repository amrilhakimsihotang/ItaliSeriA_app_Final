package com.amrilhs.italiaseria.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListItalianResponse(
    @SerializedName("teams")
    val team: List<TeamsResponse>
)