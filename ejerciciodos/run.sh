#!/bin/bash

# Script para ejecutar el ejercicio 2
# Incluye DB4O en el classpath

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
JAR_FILE="$SCRIPT_DIR/target/ejerciciodos-executable.jar"
DB4O_JAR="$SCRIPT_DIR/libs/db4o-8.0.249.16098-all-java5.jar"

if [ ! -f "$JAR_FILE" ]; then
    echo "Error: No se encontró el JAR ejecutable en $JAR_FILE"
    echo "Ejecute 'mvn clean package' primero"
    exit 1
fi

if [ ! -f "$DB4O_JAR" ]; then
    echo "Error: No se encontró el JAR de DB4O en $DB4O_JAR"
    exit 1
fi

echo "Ejecutando Ejercicio 2..."
java -cp "$JAR_FILE:$DB4O_JAR" ar.edu.unlu.bdd.MainEjercicioDos "$@"
