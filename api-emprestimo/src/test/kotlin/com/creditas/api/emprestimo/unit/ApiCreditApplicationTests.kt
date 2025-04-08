package com.creditas.api.emprestimo.unit

import com.creditas.api.emprestimo.factory.Simulator
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals

@SpringBootTest
class ApiCreditApplicationTests {
    val calculator = Simulator()

    // This file make an edge test to main function calculation.
    @Test
    fun calculationBy2() {
        val result = calculator.calculate(10000.0, 0.02, 11)
        val result2 = calculator.calculate(10000.0, 0.02, 12)
        val result3 = calculator.calculate(10000.0, 0.02, 13)

        assertEquals(1021.7794282364541, result)
        assertEquals(945.5959662295141, result2)
        assertEquals(881.1835267169588, result3)
    }

    @Test
    fun calculationBy3() {
        val result = calculator.calculate(10000.0, 0.03, 11)
        val result2 = calculator.calculate(10000.0, 0.03, 12)
        val result3 = calculator.calculate(10000.0, 0.03, 13)

        assertEquals(1080.7744784039237, result)
        assertEquals(1004.6208547296294, result2)
        assertEquals(940.2954395532795, result3)
    }

    @Test
    fun calculationBy4() {
        val result = calculator.calculate(10000.0, 0.04, 11)
        val result2 = calculator.calculate(10000.0, 0.04, 12)
        val result3 = calculator.calculate(10000.0, 0.04, 13)

        assertEquals(1141.4903925875246, result)
        assertEquals(1065.5217268605652, result2)
        assertEquals(1001.4372781403254, result3)
    }

    @Test
    fun calculationBy5() {
        val result = calculator.calculate(10000.0, 0.05, 11)
        val result2 = calculator.calculate(10000.0, 0.05, 12)
        val result3 = calculator.calculate(10000.0, 0.05, 13)

        assertEquals(1203.88891490668, result)
        assertEquals(1128.2541002081534, result2)
        assertEquals(1064.557651677276, result3)
    }
}
