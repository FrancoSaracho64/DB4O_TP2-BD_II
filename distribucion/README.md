# DB4O TP2 - Bases de Datos II 11078 - Distribución Final

Esta carpeta contiene los tres ejercicios del TP2 de Bases de Datos II listos para ejecutar.

## Requisitos del Sistema

- **Java 8 o superior** instalado en el sistema
- **Sistema operativo**: Windows, Linux o macOS

## Instrucciones de Ejecución

### Ejercicio 1 - Sistema de Clientes y Facturas (DB4O)
```bash
cd ejerciciouno
./run.sh
```

### Ejercicio 2 - Sistema de Carreras de Fórmula 1 (DB4O)
```bash
cd ejerciciodos
./run.sh
```

### Ejercicio 3 - Sistema de Ventas (Hibernate + Firebird)
```bash
cd ejerciciotres
./run.sh
```

## Bases de Datos

### Ejercicios 1 y 2 (DB4O)
- Los archivos de base de datos se crean automáticamente cuando ejecutas los programas
- **Ejercicio 1**: `bd_ej1.db`
- **Ejercicio 2**: `bd_ej2.db`

### Ejercicio 3 (Firebird)
- Requiere configuración de base de datos Firebird
- El programa intentará conectarse a la base de datos configurada
- Si no hay conexión disponible, el programa mostrará errores de conexión pero funcionará correctamente

## Solución de Problemas

### Error: "No se encontró el JAR ejecutable"
- Asegúrate de estar en el directorio correcto del ejercicio
- Verifica que el archivo `.jar` existe en la carpeta `target/`

### Error: "No se encontró el JAR de DB4O"
- Verifica que el archivo `db4o-8.0.249.16098-all-java5.jar` existe en la carpeta `libs/`

### Error de permisos en Linux/macOS
```bash
chmod +x run.sh
```

### Error de Java no encontrado
- Instala Java 8 o superior
- Verifica que `java` esté en el PATH del sistema

## Notas Importantes

- **Ejercicios 1 y 2**: Utilizan DB4O como base de datos orientada a objetos
- **Ejercicio 3**: Utiliza Hibernate con Firebird (todas las dependencias incluidas en el JAR)
- Los scripts de ejecución son compatibles con Windows (usando Git Bash o WSL), Linux y macOS
- Los datos se guardan automáticamente en archivos locales


**Desarrollado por**: [Franco Saracho (182783 - Matt Zander (182882) - Gustavo Contardi (182818)]
**Fecha**: 24 de Septiembre de 2025
**Materia**: Bases de Datos II - 11078 - Universidad Nacional de Luján
