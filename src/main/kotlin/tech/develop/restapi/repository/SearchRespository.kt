package tech.develop.restapi.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import tech.develop.restapi.entity.Search

interface SearchRespository:CrudRepository<Search,Int> {

     @Query("SELECT s FROM Search as s")
     fun getAllSearches():List<Search>


}