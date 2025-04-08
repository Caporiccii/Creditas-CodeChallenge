#!/bin/bash

# Caminhos
JMX_FILE="Creditas.jmx"
RESULTS_FILE="results.jtl"
REPORT_DIR="reports"

# Verifica se o JMeter está disponível
if ! command -v jmeter &> /dev/null
then
    echo "Erro: Apache JMeter não está instalado ou não está no PATH."
    exit 1
fi

# Executa o teste
echo "Executando teste de carga com JMeter..."
jmeter -n -t "$JMX_FILE" -l "$RESULTS_FILE"
jmeter -g "$RESULTS_FILE" -o "$REPORT_DIR"

echo "Teste concluído. Relatório gerado em: $REPORT_DIR"
