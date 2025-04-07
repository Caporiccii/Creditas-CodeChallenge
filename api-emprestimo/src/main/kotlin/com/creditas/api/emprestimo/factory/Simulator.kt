package com.creditas.api.emprestimo.factory

import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.pow

@Component
class Simulator {
    val one = 1.0

    fun calculate(
        pv: Double,
        r: Double,
        n: Int,
    ): Double {
        val numerator = pv * r
        val denominator = one - (one + r).pow(-n)

        return numerator / denominator
    }

    fun round2Decimal(number: Double): BigDecimal {
        val value = BigDecimal(number)

        return value.setScale(2, RoundingMode.HALF_UP)
    }
}
