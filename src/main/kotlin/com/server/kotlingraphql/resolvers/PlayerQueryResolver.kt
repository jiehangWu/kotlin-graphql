package com.server.kotlingraphql.resolvers

import com.server.kotlingraphql.entity.Player
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
class PlayerQueryResolver(val mongoOperations: MongoOperations): GraphQLQueryResolver {
    fun players(teamId: String): List<Player> {
        val query = Query();
        query.addCriteria(Criteria.where("teamId").`is`(teamId));
        return mongoOperations.find(query, Player::class.java);
    }
}