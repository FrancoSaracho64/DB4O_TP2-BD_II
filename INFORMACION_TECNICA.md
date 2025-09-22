# Información Técnica - DB4O TP2

## 📊 Detalles de los Archivos

### JARs Ejecutables
- **ejerciciouno-executable.jar**: 14 KB
- **ejerciciodos-executable.jar**: 31 KB  
- **ejerciciotres-executable.jar**: 16 MB (incluye todas las dependencias de Hibernate)

### Librerías
- **db4o-8.0.249.16098-all-java5.jar**: ~5 MB (para ejercicios 1 y 2)

### Tamaño Total de Distribución
- **Total**: ~21 MB

## 🔧 Tecnologías Utilizadas

### Ejercicios 1 y 2
- **Base de Datos**: DB4O (Object Database)
- **Versión**: 8.0.249.16098
- **Tipo**: Base de datos orientada a objetos
- **Archivos generados**: `.db` (archivos binarios de DB4O)

### Ejercicio 3
- **Base de Datos**: Firebird
- **ORM**: Hibernate 5.6.15.Final
- **JPA**: Jakarta Persistence API 3.1.0
- **Driver**: Jaybird 5.0.5.java8
- **Configuración**: persistence.xml

## 📁 Estructura de Base de Datos

### Ejercicio 1 - Clientes y Facturas
```
Cliente (1) -----> (N) Factura
- idCliente (PK)
- nombre
- apellido
- dni
- telefono
- email
```

### Ejercicio 2 - Carreras de Fórmula 1
```
Piloto (N) -----> (1) Equipo
Piloto (N) -----> (N) Carrera (a través de CompiteEn)
- Piloto: idPiloto, nombre, apellido, nacionalidad, fechaNacimiento
- Equipo: idEquipo, nombre, pais, añoFundacion
- Carrera: idCarrera, nombre, fecha, circuito, pais
- CompiteEn: idPiloto, idCarrera, posicion, puntos
```

### Ejercicio 3 - Sistema de Ventas
```
Empleado (N) -----> (1) Sucursal
Producto (N) -----> (N) Empleado (a través de Vende)
- Empleado: idEmpleado, nombre, apellido, sueldo
- Sucursal: idSucursal, nombre, direccion, telefono
- Producto: idProducto, nombre, precio, stock
- Vende: idEmpleado, idProducto, cantidad, fecha
```

## 🚀 Comandos de Ejecución

### Linux/macOS
```bash
# Ejecutar script principal
./ejecutar.sh

# Ejecutar ejercicio específico
cd ejerciciouno && ./run.sh
cd ejerciciodos && ./run.sh
cd ejerciciotres && ./run.sh
```

### Windows
```cmd
REM Ejecutar script principal
ejecutar.bat

REM Ejecutar ejercicio específico
cd ejerciciouno && run.bat
cd ejerciciodos && run.bat
cd ejerciciotres && run.bat
```

## 🔍 Verificación de Instalación

### Verificar Java
```bash
java -version
```

### Verificar JARs
```bash
# Verificar que los JARs existen
ls -la */target/*.jar
ls -la */libs/*.jar
```

### Verificar Scripts
```bash
# Verificar permisos de ejecución
ls -la *.sh
ls -la */run.sh
```

## 📝 Logs y Debugging

### Ejercicios 1 y 2 (DB4O)
- Los logs se muestran en consola
- Los archivos de base de datos se crean en el directorio del ejercicio

### Ejercicio 3 (Hibernate)
- Logs de Hibernate en consola
- Configuración de logging en persistence.xml
- Conexión a base de datos Firebird (requiere servidor activo)

## 🛠️ Desarrollo

### Compilación desde Código Fuente
```bash
# En el directorio raíz del proyecto
mvn clean install
```

### Estructura de Código Fuente
```
src/main/java/ar/edu/unlu/bdd/
├── entidad/          # Entidades JPA/DB4O
├── controlador/      # Lógica de negocio
├── vista/           # Interfaz de usuario
├── utils/           # Utilidades
└── menu/            # Menús de navegación
```

## 📋 Checklist de Entrega

- [x] JARs ejecutables generados
- [x] Scripts de ejecución para Linux/macOS
- [x] Scripts de ejecución para Windows
- [x] Librerías incluidas
- [x] Documentación completa
- [x] Script principal de selección
- [x] Verificación de funcionamiento
- [x] Estructura de carpetas organizada

## 🎯 Funcionalidades Implementadas

### CRUD Completo
- ✅ Create (Crear)
- ✅ Read (Leer/Listar)
- ✅ Update (Actualizar)
- ✅ Delete (Eliminar)

### Validaciones
- ✅ Validación de datos de entrada
- ✅ Validación de relaciones entre entidades
- ✅ Manejo de errores

### Interfaz de Usuario
- ✅ Menús interactivos
- ✅ Navegación intuitiva
- ✅ Mensajes informativos
