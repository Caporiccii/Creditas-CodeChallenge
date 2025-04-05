package com.creditas.api_emprestimo.controller

import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/simulate")
class SimulatorController {

    @Operation(method = "GET",
               summary = "Simulates Credit",
               description = "This endpoint return the value of a credit simulation")
    @GetMapping()
    fun simulate() : ResponseEntity<String> {


        return ResponseEntity.ok().body("Ola")
    }

}