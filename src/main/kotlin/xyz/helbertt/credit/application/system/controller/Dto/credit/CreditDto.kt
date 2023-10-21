package xyz.helbertt.credit.application.system.controller.Dto.credit

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import xyz.helbertt.credit.application.system.entity.Credit
import xyz.helbertt.credit.application.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "Invalid input")
    val creditValue: BigDecimal,
    @field:Future(message = "Invalid Date")
    val dayFirstOfInstallment: LocalDate,
    @field:NotNull(message = "Invalid input")
    val numberOfInstallments: Int,
    @field:NotNull(message = "Invalid input")
    val customerId: Long
) {

    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )

}
