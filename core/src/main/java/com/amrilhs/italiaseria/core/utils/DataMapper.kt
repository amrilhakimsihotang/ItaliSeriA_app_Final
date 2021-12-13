package com.amrilhs.italiaseria.core.utils

import com.amrilhs.italiaseria.core.data.source.local.entity.ItaliaSeriaEntity
import com.amrilhs.italiaseria.core.data.source.remote.response.TeamsResponse
import com.amrilhs.italiaseria.core.domain.model.SeriAModel

object DataMapper {

    fun mapResponsesToEntities(input: List<TeamsResponse>): List<ItaliaSeriaEntity> {
        val italiaList = ArrayList<ItaliaSeriaEntity>()
        input.map {
            val italiaSeriA = ItaliaSeriaEntity(
                idTeam = it.idTeam,
                strTeam = it.strTeam,
                strLeague = it.strLeague,
                intFormedYear = it.intFormedYear,
                strCountry = it.strCountry,
                strDescriptionEN = it.strDescriptionEN,
                strTeamJersey = it.strTeamJersey,
                strTeamBadge = it.strTeamBadge,
                strStadium = it.strStadium,
                strStadiumLocation = it.strStadiumLocation,
                strStadiumThumb = it.strStadiumThumb,
                isFavorite = false
            )
            italiaList.add(italiaSeriA)
        }
        return italiaList
    }

    fun mapEntitiesToDomain(input: List<ItaliaSeriaEntity>): List<SeriAModel> =
        input.map {
            SeriAModel(
                idTeam = it.idTeam,
                strTeam = it.strTeam,
                strLeague = it.strLeague,
                intFormedYear = it.intFormedYear,
                strCountry = it.strCountry,
                strDescriptionEN = it.strDescriptionEN,
                strTeamJersey = it.strTeamJersey,
                strTeamBadge = it.strTeamBadge,
                strStadium = it.strStadium,
                strStadiumLocation = it.strStadiumLocation,
                strStadiumThumb = it.strStadiumThumb,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: SeriAModel) = ItaliaSeriaEntity(
        idTeam = input.idTeam!!,
        strTeam = input.strTeam!!,
        strLeague = input.strLeague!!,
        intFormedYear = input.intFormedYear!!,
        strCountry = input.strCountry!!,
        strDescriptionEN = input.strDescriptionEN!!,
        strTeamJersey = input.strTeamJersey!!,
        strTeamBadge = input.strTeamBadge!!,
        strStadium = input.strStadium!!,
        strStadiumLocation = input.strStadiumLocation!!,
        strStadiumThumb = input.strStadiumThumb,
        isFavorite = input.isFavorite
    )
}