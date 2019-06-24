package com.example.bbs.application

import com.example.bbs.domain.Bbs

interface BbsRepository {

    fun findAll(): List<Bbs>

    fun findById(id: Long): Bbs

    fun write(bbs: Bbs): Bbs

    fun delete(id: Long): Bbs
}
