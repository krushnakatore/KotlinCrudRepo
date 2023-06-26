package tech.develop.restapi.utils.mapper

import org.springframework.stereotype.Service
import tech.develop.restapi.dto.SearchDTO
import tech.develop.restapi.entity.Search

// For Mapping the DTO to Entity and Vice-Versa.

@Service
class SearchMapper:Mapper<SearchDTO,Search>{

    override fun fromEntity(entity: Search): SearchDTO = SearchDTO(
             entity.id,
             entity.name,
             entity.url,
             entity.keywords
         )

    override fun toEntity(domain: SearchDTO): Search = Search(
             domain.id,
             domain.name,
             domain.url,
             domain.keywords
    )

}