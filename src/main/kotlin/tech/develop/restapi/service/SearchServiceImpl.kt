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

        print("The name is ${searchDTO.name}")
//        if(searchDTO.id != -1)
//            throw CustomException("Id must be null or -1")

        val entity = searchMapper.toEntity(searchDTO)
        print("Entity created check $entity")

        val search = searchRespository.save(entity)
        print("Search created check $search")


        return searchMapper.fromEntity(search)

    }

    override fun getSearch(): List<SearchDTO> {
        val searches = searchRespository.getAllSearches()

        if(searches.isEmpty())
            throw CustomException("The list is Empty")

        return searches.map {
            searchMapper.fromEntity(it)
        }
    }
}