# DB4O TP2 - Bases de Datos II

Este proyecto contiene tres ejercicios independientes que se pueden ejecutar como JARs ejecutables.

## Estructura del Proyecto

- **ejerciciouno/**: Ejercicio 1 - Sistema de gestión de Clientes y Facturas con DB4O
- **ejerciciodos/**: Ejercicio 2 - Sistema de gestión de Carreras de Fórmula 1 con DB4O  
- **ejerciciotres/**: Ejercicio 3 - Sistema de gestión de Ventas con Hibernate y Firebird

## Compilación

Para compilar todos los ejercicios y generar los JARs ejecutables:

```bash
mvn clean install
```

Esto generará los siguientes JARs ejecutables:
- `ejerciciouno/target/ejerciciouno-executable.jar`
- `ejerciciodos/target/ejerciciodos-executable.jar`
- `ejerciciotres/target/ejerciciotres-executable.jar`

## Ejecución

### Ejercicio 1 (DB4O)
```bash
cd ejerciciouno
./run.sh
```

### Ejercicio 2 (DB4O)
```bash
cd ejerciciodos
./run.sh
```

### Ejercicio 3 (Hibernate + Firebird)
```bash
cd ejerciciotres
./run.sh
```

## Notas Importantes

- **Ejercicios 1 y 2**: Utilizan DB4O como base de datos orientada a objetos. Los scripts `run.sh` incluyen automáticamente las dependencias de DB4O en el classpath.

- **Ejercicio 3**: Utiliza Hibernate con Firebird. El JAR ejecutable incluye todas las dependencias necesarias.

- Los scripts de ejecución verifican que los JARs existan antes de ejecutarse.

- Para el Ejercicio 3, asegúrese de que la base de datos Firebird esté disponible y configurada correctamente en `src/main/resources/META-INF/persistence.xml`.

## Dependencias

- **Java 8+**
- **Maven 3.6+**
- **DB4O 8.0.249.16098** (incluido en libs/)
- **Hibernate 5.6.15.Final**
- **Firebird JDBC Driver 5.0.5.java8**

## Configuración de Base de Datos

### Ejercicios 1 y 2 (DB4O)
Los archivos de base de datos se crean automáticamente en el directorio del proyecto:
- `bd_ej1.db` (Ejercicio 1)
- `bd_ej2.db` (Ejercicio 2)

### Ejercicio 3 (Firebird)
Configurar la conexión en `ejerciciotres/src/main/resources/META-INF/persistence.xml`:
```xml
<property name="javax.persistence.jdbc.url" value="jdbc:firebirdsql://host:port/path/to/database.fdb"/>
<property name="javax.persistence.jdbc.user" value="username"/>
<property name="javax.persistence.jdbc.password" value="password"/>
```
