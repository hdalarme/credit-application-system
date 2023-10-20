package xyz.helbertt.credit.application.system.controller.Dto.customer

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import xyz.helbertt.credit.application.system.entity.Address
import xyz.helbertt.credit.application.system.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDto(
    @field:NotEmpty(message = "Invalid input")
    val firstName: String,
    @field:NotEmpty(message = "Invalid input")
    val lastName: String,
    @field:NotNull(message = "Invalid input")
    val income: BigDecimal,
    @field:NotEmpty(message = "Invalid input")
    val zipCode: String,
    @field:NotEmpty(message = "Invalid input")
    val street: String
) {

    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.zipCode = this.zipCode
        customer.address.street = this.street
        return customer
    }

}
