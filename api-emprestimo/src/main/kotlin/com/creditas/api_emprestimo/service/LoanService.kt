package com.creditas.api_emprestimo.service

import com.creditas.api_emprestimo.dto.Loan
import com.creditas.api_emprestimo.factory.Simulate
import com.creditas.api_emprestimo.model.LoanModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LoanService {

    @Autowired
    lateinit var simulate: Simulate

    val loan = Loan()

    lateinit var loanModel:LoanModel

     fun returnSimulate(value: Double, date: Double, prazoMonthly: Int) : Loan {

        var tax: Double = 0.0
        if(date <= 25 )
        tax = 0.02

        loan.totalLoan = value.toString()
        loan.montlhyPayment = simulate.calculate(value,tax,prazoMonthly).toString()
        loan.totalTaxes = tax * prazoMonthly

        return loan
    }

}