package com.example.demo.entity

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "employee")
data class EmployeeEntity(
    val id: String? = null,
    val name: String,
    val age: Int?,
    val salary: Int?
)