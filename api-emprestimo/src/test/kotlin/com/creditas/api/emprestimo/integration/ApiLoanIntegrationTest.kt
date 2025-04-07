package com.creditas.api.emprestimo.integration

import com.creditas.api.emprestimo.service.LoanService
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@SpringBootTest
@AutoConfigureMockMvc
class ApiLoanIntegrationTest {
    
    @Autowired
    private lateinit var mockMvc: MockMvc
    
    @Test
    fun `should return credit simulation successfully`() {
        
        val totalLoan = 10000.0
        val monthlyPayment = 12
        val age = LocalDate.of(1990, 1, 1)
        val ageFormatted = age.format(DateTimeFormatter.ISO_DATE)
        
        mockMvc.get("/simulate/$totalLoan/$monthlyPayment/$ageFormatted") {
            contentType = MediaType.APPLICATION_JSON
        }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$.totalLoan") { value(totalLoan.toString()) }
                jsonPath("$.monthlyPayment") { value(1004.62) }
                jsonPath("$.totalTaxes") { value(0.36)}
            }
    }
}
