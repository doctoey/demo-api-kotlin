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
        return employeeRepository.findById(id).let {
            EmployeeResponse.fromEmployeeResponse(it.get())
        }
    }

    //patch
    fun updateEmployeeById(id: String, data: EmployeeRequest): String {
//        return employeeRepository.findById(id).let {
//            val oldEmployee = it.get()
//            val updatedEmployee = EmployeeEntity(
//                name = data.name!!,
//                age = data.age!!,
//                salary = data.salary
//            )
//            val savedEntity = employeeRepository.save(updatedEmployee)
//            return EmployeeResponse.fromEmployeeResponse(savedEntity)
//        }
// return EmployeeResponse.fromEmployeeResponse(updateEmployee)
//    return EmployeeResponse(
//        id = updateEmployee.id,
//        name = updateEmployee.name,
//        age = updateEmployee.age,
//        salary = updateEmployee.salary)
        var updateEmployee = employeeRepository.findById(id).orElseThrow()
        updateEmployee.name = data.name
        updateEmployee.age = data.age
        updateEmployee.salary = data.salary
        employeeRepository.save(updateEmployee)
        return "Update Success"
    }

    //patch ไม่มี salary ได้ แต่ put ต้องมีทั้งครบทุกอย่าง
//put
    fun updateAllFieldEmployeeById(id: String, data: EmployeeResponse): String {
//        return employeeRepository.findById(id).let {
//            val oldEmployee = it.get()
//            val updatedEmployee = EmployeeEntity(
//                id = oldEmployee.id,
//                name = data.name!!,
//                age = data.age!!,
//                salary = data.salary
//            )
//            val savedEntity = employeeRepository.save(updatedEmployee)
//            return EmployeeResponse.fromEmployeeResponse(savedEntity)
//        }
        var updateAllFieldEmployee = employeeRepository.findById(id).orElseThrow()
        updateAllFieldEmployee.id = data.id
        updateAllFieldEmployee.name = data.name
        updateAllFieldEmployee.age = data.age
        updateAllFieldEmployee.salary = data.salary
        return "Update Success"
    }

    //delete
    fun deleteEmployeeById(id: String) {
        employeeRepository.deleteById(id)
    }

    //post
    fun createEmployee(data: EmployeeRequest): ResponseEntity<EmployeeResponse> {
        val newEmployee = EmployeeEntity(
            name = data.name!!,
            age = data.age!!,
            salary = data.salary
        )
        val savedEntity = employeeRepository.save(newEmployee)
        return ResponseEntity.status(HttpStatus.CREATED).body(EmployeeResponse.fromEmployeeResponse(savedEntity))
    }
}

