package tech.develop.restapi.utils.mapper

// Mapping the Domain to Entity

interface Mapper<D, E> {

    fun fromEntity(entity:E) : D

    fun toEntity(domain:D) : E

}