@echo off
REM Script principal para ejecutar los ejercicios del TP2 en Windows
REM Permite seleccionar qué ejercicio ejecutar

echo ==============================================
echo     DB4O TP2 - Bases de Datos II
echo ==============================================
echo.
echo Seleccione el ejercicio que desea ejecutar:
echo 1 - Ejercicio 1: Sistema de Clientes y Facturas (DB4O)
echo 2 - Ejercicio 2: Sistema de Carreras de Formula 1 (DB4O)
echo 3 - Ejercicio 3: Sistema de Ventas (Hibernate + Firebird)
echo 4 - Salir
echo.
set /p opcion="Ingrese su opcion (1-4): "

if "%opcion%"=="1" (
    echo.
    echo Ejecutando Ejercicio 1...
    cd ejerciciouno
    call run.bat
) else if "%opcion%"=="2" (
    echo.
    echo Ejecutando Ejercicio 2...
    cd ejerciciodos
    call run.bat
) else if "%opcion%"=="3" (
    echo.
    echo Ejecutando Ejercicio 3...
    cd ejerciciotres
    call run.bat
) else if "%opcion%"=="4" (
    echo.
    echo Saliendo...
    exit /b 0
) else (
    echo.
    echo Opcion invalida. Por favor, seleccione una opcion del 1 al 4.
    pause
    exit /b 1
)

pause
