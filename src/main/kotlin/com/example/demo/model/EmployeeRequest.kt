package com.example.demo.model

import com.example.demo.entity.EmployeeEntity

data class EmployeeRequest(
    var name: String,
    var age: Int?,
    var salary: Int?
) {
    companion object {
        fun fromEmployeeRequest(employeeEntity: EmployeeEntity): EmployeeRequest {
            return EmployeeRequest(
                name = employeeEntity.name,
                age = employeeEntity.age,
                salary = employeeEntity.salary
            )
        }
    }
}
