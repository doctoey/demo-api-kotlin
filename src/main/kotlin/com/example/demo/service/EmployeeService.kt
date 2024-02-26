package com.example.demo.service

import com.example.demo.entity.EmployeeEntity
import com.example.demo.model.EmployeeRequest
import com.example.demo.model.EmployeeResponse
import com.example.demo.repository.EmployeeRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class EmployeeService(
    val employeeRepository: EmployeeRepository
) {
    fun getAllEmployees(): List<EmployeeResponse> {
        return employeeRepository.findAll().map {
            EmployeeResponse.fromEmployeeResponse(it)
        }
    }

    fun getEmployeeById(id: String): EmployeeResponse {
        return employeeRepository.findById(id).let{
            EmployeeResponse.fromEmployeeResponse(it.get())
        }
    }

//patch
    fun updateEmployeeData(id: String, data: EmployeeResponse): EmployeeResponse {
        return employeeRepository.findById(id).let {
            val oldEmployee = it.get()
            val updatedEmployee = EmployeeEntity(
                id = oldEmployee.id,
                name = data.name!!,
                age = data.age!!,
                salary = data.salary
            )
            val savedEntity = employeeRepository.save(updatedEmployee)
            return EmployeeResponse.fromEmployeeResponse(savedEntity)
        }
    }

//patch ไม่มี salary ได้ แต่ put ต้องมีทั้งครบทุกอย่าง
//put
    fun replaceEmployeeData(id: String, data: EmployeeResponse): EmployeeResponse {
        return employeeRepository.findById(id).let {
            val oldEmployee = it.get()
            val updatedEmployee = EmployeeEntity(
                id = oldEmployee.id,
                name = data.name!!,
                age = data.age!!,
                salary = data.salary
            )
            val savedEntity = employeeRepository.save(updatedEmployee)
            return EmployeeResponse.fromEmployeeResponse(savedEntity)
        }
    }

//delete
    fun removeEmployeeById(id: String) {
        employeeRepository.deleteById(id)
    }

//post
    fun createEmployee(data: EmployeeRequest): ResponseEntity<EmployeeResponse> {
        val newEmployee = EmployeeEntity(name = data.name!!, age = data.age!!, salary = data.salary)
        val savedEntity = employeeRepository.save(newEmployee)
        return ResponseEntity.status(HttpStatus.CREATED).body(EmployeeResponse.fromEmployeeResponse(savedEntity))
    }
}

