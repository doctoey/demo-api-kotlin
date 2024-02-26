package com.example.demo.model

import com.example.demo.entity.EmployeeEntity

data class EmployeeRequest(
    val name: String,
    val age: Int?,
    val salary: Int?
) {
    companion object {
        fun fromEmployeeRequest(employeeEntity: EmployeeEntity): EmployeeRequest {
            return EmployeeRequest (
                name = employeeEntity.name,
                age = employeeEntity.age,
                salary = employeeEntity.salary
            )
        }
    }
}
