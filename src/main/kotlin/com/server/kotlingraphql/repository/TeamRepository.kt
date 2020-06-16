package com.server.kotlingraphql.repository

import com.server.kotlingraphql.entity.Team
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface TeamRepository : MongoRepository<Team, String>