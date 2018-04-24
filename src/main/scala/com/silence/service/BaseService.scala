package com.silence.service

import java.lang.{Boolean, Integer}
import java.util.List

import javax.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.{Page, PageRequest}
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

import scala.reflect.ClassTag

@Service
abstract class BaseService[T: ClassTag] {
    
    /** spring data jpa dao*/
    @Autowired val jpaRepository: JpaRepository[T, Integer] = null
    
    /**
     * @description 添加记录
     * @param S <: T 
     * @return T
     */
    @Transactional
    def save[S <: T](s: S) : T = jpaRepository.save(s)
    
    /**
     * @description 根据Id删除数据
     * @param id 数据Id
     * @return Unit
     */
    @Transactional
    def delete(id: Integer): Unit = jpaRepository.delete(id)
    
    /**
     * @description 实体批量删除
     * @param List[T]
     * @return Unit
     */
    @Transactional
    def delete(lists: List[T]) : Unit = jpaRepository.delete(lists);
    
    /**
     * @description 根据Id更新数据
     * @param S <: T 
     * @return T
     */
    @Transactional
    def update[S <: T](s: S) : T = jpaRepository.save(s)
    
    /**
     * @description 根据Id查询
     * @param id 数据Id
     * @return T
     */
    def find[S <: T](id: Integer) : T = jpaRepository.findOne(id)
    
    /**
     * @description 查询所有数据
     * @return List[T]
     */
    def findAll[S <: T]: List[T] = jpaRepository.findAll
    
    /**
     * @description 集合Id查询数据
     * @return List[T]
     */
    def findAll[S <: T](ids: List[Integer]): List[T] = jpaRepository.findAll(ids)
    
    /**
     * @description 统计大小
     * @return Integer
     */
    def count : Long = jpaRepository.count
    
    /**
     * @description 判断数据是否存在
     * @param id 数据Id
     * @return Boolean
     */
    def exist(id: Integer) : Boolean = jpaRepository.exists(id)
    
    /**
     * @description 查询分页
     * @param page 起始页
     * @param pageSize 每页大小
     * @return Page[T]
     */
    def page[S <: T](page: Int, pageSize: Int): Page[T] = {
        val rpage = if (page < 1) 1 else page;
        val rpageSize = if (pageSize < 1) 5 else pageSize;
  		  jpaRepository.findAll(new PageRequest(rpage - 1, pageSize))
    }    

}