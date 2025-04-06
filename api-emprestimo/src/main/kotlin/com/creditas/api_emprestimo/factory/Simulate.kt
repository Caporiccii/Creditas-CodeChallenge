package com.creditas.api_emprestimo.factory

import java.math.BigDecimal
import kotlin.math.pow

class Simulate {

    var PV = 10000.0
    var r   = 0.02
    var n   = 12

    fun calculate () : Double{

        var numerador = PV * r
        var denominador = 1 - (1 + r).pow(-n)

        return numerador / denominador;
    }


}