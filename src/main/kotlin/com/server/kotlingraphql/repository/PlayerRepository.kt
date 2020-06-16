package com.server.kotlingraphql.repository

import com.server.kotlingraphql.entity.Player
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository : MongoRepository<Player, String>

// methods include findAll, saveAll, findById