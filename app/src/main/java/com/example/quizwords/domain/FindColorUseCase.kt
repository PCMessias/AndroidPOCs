package com.example.quizwords.domain

import com.example.quizwords.api.RetroFitConfig
import com.example.quizwords.api.StarWarsPeopleResponse
import com.example.quizwords.api.StarWarsPlanetsResponse
import com.example.quizwords.api.StarWarsSpaceshipsResponse
import com.example.quizwords.data.Repository

class FindColorUseCase {
    private val repository: Repository = Repository(RetroFitConfig().service)

    fun execute(inputColor: String): Boolean =
        repository.colorsList.any { cor -> cor == inputColor } &&
                !repository.guessedColorsList.contains(inputColor)

    fun addGuessedColor(inputColor: String) = repository.addGuessedColor(inputColor)

    fun getPeople() = repository
        .getPeople()
        .map { item ->
            mapPeopleList(item)
        }

    private fun mapPeopleList(item: StarWarsPeopleResponse?) = item
        ?.results
        ?.map { person ->
            person?.name ?: ""
        } ?: emptyList()

    fun getSpaceships() = repository
        .getSpaceships()
        .map { item ->
            mapSpaceshipsList(item)
        }

    private fun mapSpaceshipsList(item: StarWarsSpaceshipsResponse?) = item
        ?.results
        ?.map { spaceship ->
            spaceship?.name ?: ""
        } ?: emptyList()

    fun getPlanets() = repository
        .getPlanets()
        .map { item ->
            mapPlanetsList(item)
        }

    private fun mapPlanetsList(item: StarWarsPlanetsResponse?) = item
        ?.results
        ?.map { planet ->
            planet?.name ?: ""
        } ?: emptyList()
}