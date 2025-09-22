#!/bin/bash

# Script principal para ejecutar los ejercicios del TP2
# Permite seleccionar qué ejercicio ejecutar

echo "=============================================="
echo "    DB4O TP2 - Bases de Datos II"
echo "=============================================="
echo ""
echo "Seleccione el ejercicio que desea ejecutar:"
echo "1 - Ejercicio 1: Sistema de Clientes y Facturas (DB4O)"
echo "2 - Ejercicio 2: Sistema de Carreras de Fórmula 1 (DB4O)"
echo "3 - Ejercicio 3: Sistema de Ventas (Hibernate + Firebird)"
echo "4 - Salir"
echo ""
read -p "Ingrese su opción (1-4): " opcion

case $opcion in
    1)
        echo ""
        echo "Ejecutando Ejercicio 1..."
        cd ejerciciouno
        ./run.sh
        ;;
    2)
        echo ""
        echo "Ejecutando Ejercicio 2..."
        cd ejerciciodos
        ./run.sh
        ;;
    3)
        echo ""
        echo "Ejecutando Ejercicio 3..."
        cd ejerciciotres
        ./run.sh
        ;;
    4)
        echo ""
        echo "Saliendo..."
        exit 0
        ;;
    *)
        echo ""
        echo "Opción inválida. Por favor, seleccione una opción del 1 al 4."
        exit 1
        ;;
esac
