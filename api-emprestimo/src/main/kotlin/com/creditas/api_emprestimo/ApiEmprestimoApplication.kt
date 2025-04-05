package com.creditas.api_emprestimo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApiEmprestimoApplication

fun main(args: Array<String>) {
	println("vai agora")
	runApplication<ApiEmprestimoApplication>(*args)
}
