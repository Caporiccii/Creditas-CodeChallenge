package com.creditas.api_emprestimo.controller

import com.creditas.api_emprestimo.dto.Loan
import com.creditas.api_emprestimo.service.LoanService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/simulate")
class SimulatorController {

    @Autowired
    private lateinit var loanService: LoanService;

    @Operation(method = "GET",
               summary = "Simulates Credit",
               description = "This endpoint return the value of a credit simulation")
    @ResponseBody
    @GetMapping("/{totalLoan}/{totalTaxes}/{montlhyPayment}")
    fun simulate(@PathVariable totalLoan:Double,  @PathVariable totalTaxes:Int, @PathVariable montlhyPayment:Int) : ResponseEntity<Loan> {
        return ResponseEntity.ok().body(loanService.returnSimulate(totalLoan, totalTaxes, montlhyPayment))
    }

}