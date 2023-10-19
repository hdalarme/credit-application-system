package xyz.helbertt.credit.application.system.service.impl

import xyz.helbertt.credit.application.system.entity.Credit
import xyz.helbertt.credit.application.system.repository.CreditRepository
import xyz.helbertt.credit.application.system.service.ICreditService
import java.lang.RuntimeException

import java.util.*

class CreditService(
        private val creditRepository: CreditRepository,
        private val customerService: CustumerService
): ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> = this.creditRepository.findAllByCustomerId(customerId)

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        var credit: Credit = this.creditRepository.findByCreditCode(creditCode) ?: throw RuntimeException("Creditcode $creditCode not found")
        return if (credit.customer?.id == customerId) credit else throw RuntimeException("Contact admin")
    }
}