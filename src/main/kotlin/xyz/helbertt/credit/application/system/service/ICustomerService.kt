package xyz.helbertt.credit.application.system.service

import xyz.helbertt.credit.application.system.entity.Customer

interface ICustomerService {

    fun save(custumer: Customer): Customer

    fun findById(id: Long): Customer

    fun delete(id: Long)
}