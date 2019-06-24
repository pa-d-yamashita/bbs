package com.example.bbs.infrastructure

import com.example.bbs.application.BbsRepository
import com.example.bbs.domain.Bbs
import org.springframework.stereotype.Repository

@Repository
class BbsDataSource(private val bbsMapper: BbsMapper) : BbsRepository {

    override fun findById(id: Long): Bbs = bbsMapper.findById(id)

    override fun findAll(): List<Bbs> = bbsMapper.findAll()

    override fun write(bbs: Bbs): Bbs {
        bbsMapper.insert(bbs)
        return findById(bbs.id)
    }

    override fun delete(id: Long): Bbs {
        bbsMapper.delete(id)
        return findById(id)
    }
}
