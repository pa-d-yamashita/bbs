package com.example.bbs.infrastructure

import com.example.bbs.domain.Bbs
import org.apache.ibatis.annotations.*

@Mapper
interface BbsMapper {

    @Select("SELECT * FROM bbs WHERE deleted IS FALSE ORDER BY id DESC")
    fun findAll(): List<Bbs>

    @Select("SELECT * FROM bbs WHERE id = #{id}")
    fun findById(id: Long): Bbs

    @Insert("INSERT INTO bbs(name, content, date) VALUES(#{name}, #{content}, #{datetime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    fun insert(bbs: Bbs): Long

    @Delete("DELETE FROM bbs WHERE id = #{id}")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    fun delete(id: Long): Long
}
