package com.example.demo.controller

import com.example.demo.model.EmployeeResponse
import com.example.demo.service.EmployeeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

    @PatchMapping("/{id}")
    fun patchEmployeeById(
        @PathVariable id: String,
        @RequestBody data: EmployeeResponse
    ): EmployeeResponse {
        return employeeService.patch(id, data)
    }

    @PutMapping("/{id}")
    fun putEmployeeById(
        @PathVariable id: String,
        @RequestBody data: EmployeeResponse
    ): EmployeeResponse {
        return employeeService.put(id, data)
    }

    @DeleteMapping("/{id}")
    fun deleteEmployeeById(@PathVariable id: String) {
        return employeeService.delete(id)
    }

}