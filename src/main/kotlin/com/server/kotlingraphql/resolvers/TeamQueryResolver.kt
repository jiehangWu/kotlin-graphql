package com.server.kotlingraphql.resolvers

import com.server.kotlingraphql.entity.Team
import com.server.kotlingraphql.entity.Player
import com.server.kotlingraphql.repository.TeamRepository
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
class TeamQueryResolver(val teamRepository: TeamRepository, 
                            private val MongoOperations: MongoOperations): GraphQLQueryResolver {

    fun teams(): List<Team> {
        val list = teamRepository.findAll();
        for (item in list) {
            item.players = getPlayers(teamId = item.id);
        }
        return list;
    }

    private fun getPlayers(teamId: String): List<Player> {
        val query = Query()
        query.addCriteria(Criteria.where("teamId").`is`(teamId));
        return MongoOperations.find(query, Player::class.java);
    }
}

