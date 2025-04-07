package com.creditas.api.emprestimo

import com.creditas.api.emprestimo.factory.Simulate
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals

@SpringBootTest
class ApiLoanApplicationTests {
    @Test
    fun shouldReturnCorrectCalculation() {
        val calculator = Simulate()

        val result2 = calculator.calculate(10000.0, 0.02, 12)
        val result3 = calculator.calculate(10000.0, 0.03, 12)
        val result4 = calculator.calculate(10000.0, 0.04, 12)
        val result5 = calculator.calculate(10000.0, 0.05, 12)

        assertEquals(945.5959662295141, result2)
        assertEquals(1004.6208547296294, result3)
        assertEquals(1065.5217268605652, result4)
        assertEquals(1128.2541002081534, result5)
    }
}
