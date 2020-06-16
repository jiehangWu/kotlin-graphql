package com.server.kotlingraphql.resolvers

import com.server.kotlingraphql.entity.Team
import com.server.kotlingraphql.repository.TeamRepository
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component
import java.util.*

@Component
class TeamMutationResolver(private val teamRepository: TeamRepository): GraphQLMutationResolver {
    fun newTeam(name: String, location: String): Team {
        val team = Team(name, location);
        team.id = UUID.randomUUID().toString();
        teamRepository.save(team);
        return team;
    }

    fun deleteTeam(id: String): Boolean {
        teamRepository.deleteById(id);
        return true;
    }

    fun updateTeam(id: String, location: String): Team {
        val team = teamRepository.findById(id);
        team.ifPresent {
            it.location = location;
            teamRepository.save(it);
        }
        return team.get();
    }
}