package com.example.demo.repository

import com.example.demo.entity.EmployeeEntity
import com.example.demo.model.EmployeeResponse
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository: MongoRepository<EmployeeEntity, String> {
    fun getById(id:String): EmployeeEntity
    fun getByName(name:String): EmployeeEntity
}