package xyz.helbertt.credit.application.system.service.impl

import org.springframework.stereotype.Service
import xyz.helbertt.credit.application.system.entity.Customer
import xyz.helbertt.credit.application.system.exception.BusinessException
import xyz.helbertt.credit.application.system.repository.CustomerRepository
import xyz.helbertt.credit.application.system.service.ICustomerService

@Service
class CustomerService(
        private val customerRepository: CustomerRepository
): ICustomerService {
    override fun save(customer: Customer): Customer = this.customerRepository.save(customer)


    override fun findById(id: Long): Customer = this.customerRepository.findById(id).orElseThrow {
        throw BusinessException("ID $id not found")
    }

    override fun delete(id: Long) {
        val customer: Customer = this.findById(id)
        this.customerRepository.delete(customer)
    }

}