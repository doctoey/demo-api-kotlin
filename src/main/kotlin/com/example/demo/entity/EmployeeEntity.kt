package com.example.demo.entity

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "employee")
class EmployeeEntity {
    var id: String = ""
    var name: String = ""
    var age: Int = 0
    var salary: Int = 0
}