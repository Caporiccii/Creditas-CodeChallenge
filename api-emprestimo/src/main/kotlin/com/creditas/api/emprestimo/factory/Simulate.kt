package com.creditas.api.emprestimo.factory

import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.pow

@Component
class Simulate {
    val one = 1.0

    fun calculate(
        pv: Double,
        r: Double,
        n: Int,
    ): Double {
        var numerador = pv * r
        var denominador = one - (one + r).pow(-n)

        return numerador / denominador
    }

    fun round2Decimal(number: Double): BigDecimal {
        var value = BigDecimal(number)

        return value.setScale(2, RoundingMode.HALF_UP)
    }
}
