#!/bin/bash

set -e

# ========== CONFIG ==========
JDK_VERSION="21"
JDK_URL="https://github.com/adoptium/temurin21-binaries/releases/download/jdk-21.0.2%2B13/OpenJDK21U-jdk_x64_linux_hotspot_21.0.2_13.tar.gz"
ARCHIVE_NAME="openjdk-${JDK_VERSION}.tar.gz"
INSTALL_DIR="/opt/jdk-${JDK_VERSION}"
KTLINT_VERSION="1.1.1"
PROJECT_PATH="$(pwd)"
API_PATH="$(pwd)/api-emprestimo"
# ============================

echo "☕ Instalando Java $JDK_VERSION..."
wget -O "$ARCHIVE_NAME" "$JDK_URL"
tar -xzf "$ARCHIVE_NAME"
EXTRACTED_DIR=$(tar -tf "$ARCHIVE_NAME" | head -1 | cut -d/ -f1)
sudo mv "$EXTRACTED_DIR" "$INSTALL_DIR"
rm "$ARCHIVE_NAME"
sudo update-alternatives --install /usr/bin/java java "$INSTALL_DIR/bin/java" 1
sudo update-alternatives --install /usr/bin/javac javac "$INSTALL_DIR/bin/javac" 1
sudo update-alternatives --set java "$INSTALL_DIR/bin/java"
sudo update-alternatives --set javac "$INSTALL_DIR/bin/javac"
java -version

cd "$API_PATH"
echo "📦 Instalando Maven..."
sudo apt update
sudo apt install -y maven
mvn -v

echo "🧹 Instalando Ktlint CLI..."
curl -sSLo ktlint https://github.com/pinterest/ktlint/releases/download/${KTLINT_VERSION}/ktlint
chmod +x ktlint
ktlint --version

echo "📂 Entrando no diretório do projeto..."
cd "$API_PATH"

echo "🎯 Rodando Ktlint nos arquivos .kt..."
ktlint "**/*.kt" || true

echo "🛠️ Rodando Maven build em $(pwd)/api-emprestimo..."
cd "$API_PATH"
mvn clean install

echo "🔍 Procurando JAR em target/..."
JAR_PATH=$(find target -type f -name "*.jar" | head -1)

if [[ -z "$JAR_PATH" ]]; then
  echo "❌ Nenhum JAR encontrado em target/"
  exit 1
fi

echo "🚀 Executando JAR: $JAR_PATH"
java -jar "$JAR_PATH"
