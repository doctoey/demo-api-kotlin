package com.example.demo.controller

import com.example.demo.model.EmployeeRequest
import com.example.demo.model.EmployeeResponse
import com.example.demo.service.EmployeeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/employee")
class GetEmployeeController(
        val employeeService: EmployeeService
) {

    @GetMapping
    fun getEmployeeAll(): List<EmployeeResponse> {
        return employeeService.getAllEmployees()
    }

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id:String): EmployeeResponse {
        return employeeService.getEmployeeById(id)
    }

    @PatchMapping("/{id}")
    fun updateEmployeeById(
        @PathVariable id: String,
        @RequestBody data: EmployeeResponse
    ): EmployeeResponse {
        return employeeService.updateEmployeeData(id, data)
    }

    @PutMapping("/{id}")
    fun replaceEmployeeById(
        @PathVariable id: String,
        @RequestBody data: EmployeeResponse
    ): EmployeeResponse {
        return employeeService.replaceEmployeeData(id, data)
    }

    @DeleteMapping("/{id}")
    fun removeEmployeeById(@PathVariable id: String) {
        return employeeService.removeEmployeeById(id)
    }

    @PostMapping
    fun createEmployee(@RequestBody data: EmployeeRequest): ResponseEntity<ResponseEntity<EmployeeResponse>> {
        val newEmployee = employeeService.createEmployee(data)
        return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee)
    }
}