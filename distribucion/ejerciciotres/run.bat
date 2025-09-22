@echo off
REM Script para ejecutar el ejercicio 3 en Windows
REM Este ejercicio ya incluye todas las dependencias en el JAR ejecutable

set SCRIPT_DIR=%~dp0
set JAR_FILE=%SCRIPT_DIR%target\ejerciciotres-executable.jar

if not exist "%JAR_FILE%" (
    echo Error: No se encontro el JAR ejecutable en %JAR_FILE%
    echo Ejecute 'mvn clean package' primero
    pause
    exit /b 1
)

echo Ejecutando Ejercicio 3...
java -cp "%JAR_FILE%" ar.edu.unlu.bdd.MainEjercicioTres %*
pause
