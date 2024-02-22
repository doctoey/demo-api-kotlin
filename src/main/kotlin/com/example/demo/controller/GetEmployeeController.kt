package com.example.demo.controller

import com.example.demo.model.EmployeeResponse
import com.example.demo.service.EmployeeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/employee")
class GetEmployeeController(
        val employeeService: EmployeeService
) {

    @GetMapping
    fun getEmployeeAll(): List<EmployeeResponse> {
        return employeeService.getListEmployee()
    }

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id:String): EmployeeResponse {
        return employeeService.getById(id)
    }
}