package com.creditas.api.emprestimo.service

import com.creditas.api.emprestimo.dto.Credit
import com.creditas.api.emprestimo.factory.Simulator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class LoanService {
    @Autowired
    lateinit var simulator: Simulator
    val loan = Credit()

    fun returnSimulate(
        value: Double,
        montlhyPayment: Int,
        age: LocalDate,
    ): Credit {
        val tax: Double = setTaxValue(convertAge(age))

        val monthlyPayment = simulator.calculate(value, tax, montlhyPayment)

        loan.totalLoan = value.toString()
        loan.monthlyPayment = simulator.round2Decimal(monthlyPayment).toString()
        loan.totalTaxes = tax * montlhyPayment

        return loan
    }

    fun setTaxValue(age: Int): Double =
        when {
            age <= 25 -> 0.05
            age in 25..40 -> 0.03
            age in 41..60 -> 0.02
            else -> 0.04
        }

    fun convertAge(age: LocalDate): Int = LocalDate.now().year - age.year
}
