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

    fun patch(id: String, data: EmployeeResponse): EmployeeResponse {
        return employeeRepository.findById(id).let {
            val employee = it.get()
            employee.name = data.name!!
            employee.age = data.age!!
            employeeRepository.save(employee)
            EmployeeResponse.fromEmployeeResponse(employee)
        }
    }

//    patch ไม่มี salary ได้ แต่ put มีทั้ง 3 อย่าง
    fun put(id: String, data: EmployeeResponse): EmployeeResponse {
        return employeeRepository.findById(id).let {
            val employee = it.get()
            employee.name = data.name!!
            employee.age = data.age!!
            employee.salary = data.salary!!
            employeeRepository.save(employee)
            EmployeeResponse.fromEmployeeResponse(employee)
        }
    }

    fun delete(id: String) {
        employeeRepository.deleteById(id)
    }
}

