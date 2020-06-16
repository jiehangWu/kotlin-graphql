package com.server.kotlingraphql.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.server.kotlingraphql.entity.Player
import com.server.kotlingraphql.repository.PlayerRepository
import org.springframework.stereotype.Component

@Component
class PlayerMutationSolver(private val playerRepository: PlayerRepository): GraphQLMutationResolver {
    fun newPlayer(teamId: String, name: String, year: Int, avgScore: Float): Player {
        val player = Player(teamId, name, year, avgScore);
        playerRepository.save(player);
        return player;
    }
}