package xyz.helbertt.credit.application.system.controller

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import xyz.helbertt.credit.application.system.controller.Dto.customer.CustomerDto
import xyz.helbertt.credit.application.system.controller.Dto.customer.CustomerUpdateDto
import xyz.helbertt.credit.application.system.controller.Dto.customer.CustomerView
import xyz.helbertt.credit.application.system.entity.Customer
import xyz.helbertt.credit.application.system.service.impl.CustomerService

@RestController
@RequestMapping("/api-customers")
class CustomerResource(
    private val customerService: CustomerService
) {

    @PostMapping
    fun saveCustomer(@RequestBody @Valid customerDto: CustomerDto): ResponseEntity<String> {
        val savedCustomer = this.customerService.save(customerDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer ${savedCustomer.email} saved!")
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustomerView> {
        val customer : Customer = this.customerService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customer))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustumer(@PathVariable id : Long) = this.customerService.delete(id)

    @PatchMapping
    fun updateCustomer(@RequestParam(value = "customerId") id: Long, @RequestBody @Valid customerUpdateDto: CustomerUpdateDto): ResponseEntity<CustomerView> {
        val customer: Customer = this.customerService.findById(id)
        val customerToUpdate: Customer =  customerUpdateDto.toEntity(customer)
        val customerUpdated: Customer =  this.customerService.save(customerToUpdate)
        return return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customerUpdated))
    }

}