package com.creditas.api.emprestimo.controller

import com.creditas.api.emprestimo.dto.Credit
import com.creditas.api.emprestimo.service.LoanService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/simulate")
class SimulatorController {
    @Autowired
    private lateinit var loanService: LoanService

    @Operation(
        method = "GET",
        summary = "Simulates Credit",
        description = "This endpoint return the value of a credit simulation",
    )
    @ResponseBody
    @GetMapping("/{totalLoan}/{montlhyPayment}/{age}")
    fun simulate(
        @PathVariable totalLoan: Double,
        @PathVariable montlhyPayment: Int,
        @PathVariable age: LocalDate,
    ): ResponseEntity<Credit> = ResponseEntity.ok().body(loanService.returnSimulate(totalLoan, montlhyPayment, age))
}
