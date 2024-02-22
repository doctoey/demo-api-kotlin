package com.example.demo.service

import com.example.demo.entity.EmployeeEntity
import com.example.demo.model.EmployeeResponse
import com.example.demo.repository.EmployeeRepository
import org.springframework.stereotype.Service


@Service
class EmployeeService(
    val employeeRepository: EmployeeRepository
) {
    fun getListEmployee(): List<EmployeeResponse> {
        return employeeRepository.findAll().map {
            EmployeeResponse.fromEmployeeResponse(it)
        }
    }

    fun getById(id: String): EmployeeResponse {
        return employeeRepository.findById(id).let{
            EmployeeResponse.fromEmployeeResponse(it.get())
        }
    }
}

