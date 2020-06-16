package com.server.kotlingraphql.entity;

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "teams")
data class Team(
    var name: String,
    var location: String
) {
    @Id
    var id: String = ""

    @Transient
    var players: List<Player> = ArrayList()
}