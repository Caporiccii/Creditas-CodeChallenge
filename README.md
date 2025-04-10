# Creditas-CodeChallenge

Esse repositório se trata do desafio de código para Creditas:

Feito em Kotlin e Spring Boot.

# Setup do Projeto

Na raiz do projeto, dê permissão para rodar o script:

chmod +x setup_projeto.sh

em seguida rode:

./setup_projeto.sh

Para rodar via docker, na raiz do projeto, execute:

docker compose up --build

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

# Arquitetura e Estrutura

O projeto foi desenvolido dessa forma, devido a simplicidade da regra de negocio, usamos o padrao singleton para garantir que somente uma instancia do
servico sera disponibilizado para garantir consistencia e integridade dos dados.

Ja a organizacao de diretorios, visa deixar pouco acoplado a regra de negocio da parte rest e estruturas como mensageria.

# Teste de carga
Execute o run_jmeter_test_sh.
