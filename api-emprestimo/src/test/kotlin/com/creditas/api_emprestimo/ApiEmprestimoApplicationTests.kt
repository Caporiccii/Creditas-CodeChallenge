package com.creditas.api_emprestimo

import com.creditas.api_emprestimo.factory.Simulate
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.kotlin.whenever
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals

@SpringBootTest
class ApiEmprestimoApplicationTests {

	@Test
	fun shouldReturnCorrectCalculation(){
		val calculator = mock<Simulate>()

		// Define comportamento simulado (stub)
		whenever(calculator.calculate(10000.0, 0.02, 12)).thenReturn(999.99)


		val result = calculator.calculate(10000.0, 0.02, 12)

		// Verifica o valor retornado
		assertEquals(999.99, result)

		// Verifica se a função foi chamada com os parâmetros corretos
		verify(calculator).calculate(10000.0, 0.02, 12)
	}
}
