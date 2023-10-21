package xyz.helbertt.credit.application.system.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import xyz.helbertt.credit.application.system.entity.Customer

@Repository
interface CustomerRepository: JpaRepository<Customer, Long> {
}