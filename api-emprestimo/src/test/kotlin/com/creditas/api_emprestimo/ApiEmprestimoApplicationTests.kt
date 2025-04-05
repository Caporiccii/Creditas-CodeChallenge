package com.creditas.api_emprestimo

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals

@SpringBootTest
class ApiEmprestimoApplicationTests {

	@Test
	fun contextLoads() {

	}

	@Test
	fun test(){
		val a = 1+1

		assertEquals(a, 2)
	}
}
