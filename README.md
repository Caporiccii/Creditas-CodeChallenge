# Creditas-CodeChallenge

Esse repositório se trata do desafio de código para Creditas:

Feito em Kotlin e Spring Boot.

# Setup do Projeto

Dê permissão para rodar o script:

chmod +x setup_projeto.sh

em seguida rode:

./setup_projeto.sh

# Exemplos de requisiçôes 

Podemos executar essas requisições no endereço:

http://localhost:8080/swagger-ui/index.html#/ <-- ao rodar o processo de setup

via curl: curl -X 'GET' \
          'http://localhost:8080/simulate/20000/12/1990-01-01' \
          -H 'accept: */*'

Response esperado:

{
  "totalLoan": "20000.0",
  "monthlyPayment": "2009.24",
  "totalTaxes": 0.36
}

