#!/bin/bash

# Script para ejecutar el ejercicio 3
# Este ejercicio ya incluye todas las dependencias en el JAR ejecutable

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
JAR_FILE="$SCRIPT_DIR/target/ejerciciotres-executable.jar"

if [ ! -f "$JAR_FILE" ]; then
    echo "Error: No se encontró el JAR ejecutable en $JAR_FILE"
    echo "Ejecute 'mvn clean package' primero"
    exit 1
fi

echo "Ejecutando Ejercicio 3..."
java -cp "$JAR_FILE" ar.edu.unlu.bdd.MainEjercicioTres "$@"
