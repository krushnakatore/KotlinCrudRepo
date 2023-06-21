package tech.develop.restapi.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.jetbrains.annotations.NotNull

//Totally for database
@Entity
@Table(name = "USERS")
data class Search (
    @Id
    val id : Int ,
    @Column(name = "name" )
    val name : String,
    @Column(name = "url")
    val url : String
)

