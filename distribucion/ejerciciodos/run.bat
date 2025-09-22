@echo off
REM Script para ejecutar el ejercicio 2 en Windows
REM Incluye DB4O en el classpath

set SCRIPT_DIR=%~dp0
set JAR_FILE=%SCRIPT_DIR%target\ejerciciodos-executable.jar
set DB4O_JAR=%SCRIPT_DIR%libs\db4o-8.0.249.16098-all-java5.jar

if not exist "%JAR_FILE%" (
    echo Error: No se encontro el JAR ejecutable en %JAR_FILE%
    echo Ejecute 'mvn clean package' primero
    pause
    exit /b 1
)

if not exist "%DB4O_JAR%" (
    echo Error: No se encontro el JAR de DB4O en %DB4O_JAR%
    pause
    exit /b 1
)

echo Ejecutando Ejercicio 2...
java -cp "%JAR_FILE%;%DB4O_JAR%" ar.edu.unlu.bdd.MainEjercicioDos %*
pause
