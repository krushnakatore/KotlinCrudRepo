package tech.develop.restapi.service

import org.springframework.stereotype.Service
import tech.develop.restapi.dto.SearchDTO
import tech.develop.restapi.repository.SearchRespository
import tech.develop.restapi.utils.exceptions.CustomException
import tech.develop.restapi.utils.mapper.SearchMapper

@Service
class SearchServiceImpl(
    private val searchRespository: SearchRespository,
    private val searchMapper: SearchMapper
) : SearchService {

    override fun createSearch(searchDTO: SearchDTO): SearchDTO {

//        if(searchDTO.id != -1)
//            throw CustomException("Id must be null or -1")

        val entity = searchMapper.toEntity(searchDTO)

        val search = searchRespository.save(entity)

        return searchMapper.fromEntity(search)

    }

    override fun getSearch(search:String): List<SearchDTO> {
        val searches = searchRespository.getAllSearches()

        if(searches.isEmpty())
            throw CustomException("The list is Empty")

        val filteredSearches = searches.filter {
                   it.name.toLowerCase().contains(search.toLowerCase())
                           || it.keywords.toLowerCase().contains(search.toLowerCase()) }

        return filteredSearches.map {
            searchMapper.fromEntity(it)
        }
    }
}