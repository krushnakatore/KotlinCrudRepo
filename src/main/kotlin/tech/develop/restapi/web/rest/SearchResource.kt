package tech.develop.restapi.web.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tech.develop.restapi.dto.SearchDTO
import tech.develop.restapi.service.SearchService
@RequestMapping("/v1/api")
@RestController
@CrossOrigin(origins = ["http://localhost:3000"], maxAge=3600, allowCredentials = "true")
class SearchResource(private val searchService: SearchService) {

    @PostMapping("/post_results")
    fun createSearch(@RequestBody searchDTO: SearchDTO):ResponseEntity<SearchDTO>{
        return ResponseEntity(searchService.createSearch(searchDTO), HttpStatus.CREATED)
    }

    @GetMapping("/get_results/{search}")
    fun getSearch(@PathVariable search:String):ResponseEntity<List<SearchDTO>>{
        return ResponseEntity(searchService.getSearch(search),HttpStatus.ACCEPTED)
    }



}