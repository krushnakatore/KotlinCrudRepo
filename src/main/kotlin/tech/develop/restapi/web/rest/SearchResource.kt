package tech.develop.restapi.web.rest

import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tech.develop.restapi.dto.SearchDTO
import tech.develop.restapi.service.SearchService
import java.lang.Exception
import kotlin.IllegalArgumentException

@RestController
class SearchResource(private val searchService: SearchService) {

    @PostMapping("/")
    fun createSearch(@RequestBody searchDTO: SearchDTO):ResponseEntity<SearchDTO>{
        return ResponseEntity(searchService.createSearch(searchDTO), HttpStatus.CREATED)
    }

    @GetMapping("/")
    fun getSearch():ResponseEntity<List<SearchDTO>>{
        return ResponseEntity(searchService.getSearch(),HttpStatus.ACCEPTED)
    }



}