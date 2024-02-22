package com.example.demo.model

import com.example.demo.entity.EmployeeEntity

data class EmployeeResponse (
    val id: String?,
    val name: String?,
    val age: Int?,
    val salary: Int?
){


    companion object {
        fun fromEmployeeResponse(employeeEntity: EmployeeEntity): EmployeeResponse {
            return EmployeeResponse (
                id = employeeEntity.id,
                name = employeeEntity.name,
                age = employeeEntity.age,
                salary = employeeEntity.salary
            )
        }
        }
}