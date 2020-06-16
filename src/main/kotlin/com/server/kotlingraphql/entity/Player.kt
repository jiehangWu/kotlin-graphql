package com.server.kotlingraphql.entity;

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "players")
data class Player(
    var teamId: String,
    var name: String,
    var year: Int,
    var avgScore: Float
) {
    @Id
    var id: String = ""
}