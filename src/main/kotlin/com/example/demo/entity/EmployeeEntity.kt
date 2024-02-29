package com.example.demo.entity

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "employee")
data class EmployeeEntity(
    var id: String? = null,
    var name: String,
    var age: Int?,
    var salary: Int?
)