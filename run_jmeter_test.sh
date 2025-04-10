#!/bin/bash

# Gera timestamp para nomes únicos
TIMESTAMP=$(date +"%Y%m%d-%H%M%S")

# Caminhos com timestamp
JMX_FILE="Creditas.jmx"
RESULTS_FILE="results-$TIMESTAMP.jtl"
REPORT_DIR="reports-$TIMESTAMP"

# Detecta o sistema operacional
OS_TYPE="$(uname -s)"

# Função para instalar o JMeter
instalar_jmeter() {
    case "$OS_TYPE" in
        Linux)
            if command -v apt-get &> /dev/null; then
                echo "Instalando JMeter via apt-get..."
                sudo apt-get update
                sudo apt-get install -y jmeter
            else
                echo "Gerenciador de pacotes não suportado no Linux. Instale o JMeter manualmente."
                exit 1
            fi
            ;;
        Darwin)
            if command -v brew &> /dev/null; then
                echo "Instalando JMeter via Homebrew..."
                brew install jmeter
            else
                echo "Homebrew não encontrado. Instale com: /bin/bash -c \"\$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)\""
                exit 1
            fi
            ;;
        MINGW*|MSYS*|CYGWIN*)
            echo "Sistema Windows detectado."
            echo "Instalação automática não suportada. Baixe manualmente em:"
            echo "https://jmeter.apache.org/download_jmeter.cgi"
            exit 1
            ;;
        *)
            echo "Sistema operacional não suportado: $OS_TYPE"
            exit 1
            ;;
    esac
}

# Verifica se o JMeter está instalado
if ! command -v jmeter &> /dev/null
then
    echo "Apache JMeter não está instalado."
    instalar_jmeter

    # Verifica novamente se a instalação deu certo
    if ! command -v jmeter &> /dev/null; then
        echo "Erro: Falha na instalação do JMeter."
        exit 1
    fi
fi

# Executa o teste
echo "Executando teste de carga com JMeter..."
jmeter -n -t "$JMX_FILE" -l "$RESULTS_FILE"
jmeter -g "$RESULTS_FILE" -o "$REPORT_DIR"

echo "✅ Teste concluído. Relatório gerado em: $REPORT_DIR"
