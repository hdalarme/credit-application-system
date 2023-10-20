package xyz.helbertt.credit.application.system.service.impl

import org.springframework.stereotype.Service
import xyz.helbertt.credit.application.system.entity.Customer
import xyz.helbertt.credit.application.system.repository.CustomerRepositoty
import xyz.helbertt.credit.application.system.service.ICustomerService

@Service
class CustumerService(
        private val custumerRepository: CustomerRepositoty
): ICustomerService {
    override fun save(customer: Customer): Customer = this.custumerRepository.save(customer)


    override fun findById(id: Long): Customer = this.custumerRepository.findById(id).orElseThrow {
        throw RuntimeException("ID $id not found")
    }

    override fun delete(id: Long) = this.custumerRepository.deleteById(id)

}