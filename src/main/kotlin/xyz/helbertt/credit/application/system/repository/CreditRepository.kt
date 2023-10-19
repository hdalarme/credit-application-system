package xyz.helbertt.credit.application.system.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import xyz.helbertt.credit.application.system.entity.Credit
import java.util.UUID

@Repository
interface CreditRepository: JpaRepository<Credit, Long> {

    fun findByCreditCode(creditCode: UUID) : Credit?

    @Query(value = "SELECT * FROM CREDITO WHERE CUSTOMER_ID = ?1", nativeQuery = true)
    fun findAllByCustomerId(customerId: Long): List<Credit>

}