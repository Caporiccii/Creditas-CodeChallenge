package com.creditas.api.emprestimo.service

import com.creditas.api.emprestimo.dto.Loan
import com.creditas.api.emprestimo.factory.Simulate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LoanService {
    @Autowired
    lateinit var simulate: Simulate
    val loan = Loan()

    fun setTaxValue(age: Int): Double {
        return when {
            age <= 25 -> 0.05
            age in 25..40 -> 0.03
            age in 41..60 -> 0.02
            else -> 0.04
        }
    }

    fun returnSimulate(
        value: Double,
        age: Int,
        prazoMonthly: Int,
    ): Loan {
        val tax: Double = setTaxValue(age)

        val monthlyPayment = simulate.calculate(value, tax, prazoMonthly)

        loan.totalLoan = value.toString()
        loan.monthlyPayment = simulate.round2Decimal(monthlyPayment).toString()
        loan.totalTaxes = tax * prazoMonthly

        return loan
    }
}
