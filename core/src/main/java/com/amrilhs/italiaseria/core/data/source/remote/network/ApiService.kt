package com.amrilhs.italiaseria.core.data.source.remote.network

import com.amrilhs.italiaseria.core.data.source.remote.response.ListItalianResponse
import retrofit2.http.GET

interface ApiService {
    @GET("search_all_teams.php?l=Italian%20Serie%20A")
    suspend fun getList(): ListItalianResponse
}