package tech.develop.restapi.service

import tech.develop.restapi.dto.SearchDTO

interface SearchService {

    fun createSearch(searchDTO: SearchDTO) : SearchDTO

    fun getSearch():List<SearchDTO>

}