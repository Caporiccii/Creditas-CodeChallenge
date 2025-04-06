package com.creditas.api_emprestimo.factory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import kotlin.math.pow

@Component
class Simulate {

    val one = 1.0

    fun calculate (pv:Double, r:Double, n: Int ) : Double{

        var numerador = pv * r
        var denominador = one - (one + r).pow(-n)

        return numerador / denominador;
    }


}