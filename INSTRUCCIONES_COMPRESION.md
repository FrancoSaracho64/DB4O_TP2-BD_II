# Instrucciones de Compresión y Entrega

## 📦 Comprimir la Distribución

### Opción 1: ZIP (Recomendado)
```bash
# Desde el directorio padre de 'distribucion'
zip -r DB4O_TP2_Distribucion.zip distribucion/
```

### Opción 2: TAR.GZ
```bash
# Desde el directorio padre de 'distribucion'
tar -czf DB4O_TP2_Distribucion.tar.gz distribucion/
```

### Opción 3: 7Z (Si está disponible)
```bash
# Desde el directorio padre de 'distribucion'
7z a DB4O_TP2_Distribucion.7z distribucion/
```

## 📋 Checklist Pre-Entrega

### ✅ Verificación de Archivos
- [ ] Todos los JARs ejecutables presentes
- [ ] Librerías de DB4O incluidas
- [ ] Scripts de ejecución para Linux/macOS (.sh)
- [ ] Scripts de ejecución para Windows (.bat)
- [ ] Documentación completa (README.md)
- [ ] Información técnica (INFORMACION_TECNICA.md)

### ✅ Verificación de Funcionamiento
- [ ] Script principal ejecuta correctamente
- [ ] Scripts individuales funcionan
- [ ] Permisos de ejecución configurados
- [ ] Estructura de carpetas correcta

### ✅ Verificación de Tamaño
- [ ] Distribución completa: ~21 MB
- [ ] Archivo comprimido: ~8-12 MB (estimado)

## 🎯 Instrucciones para el Usuario Final

### Descomprimir
1. Extraer el archivo comprimido en cualquier ubicación
2. Navegar a la carpeta `distribucion/`
3. Ejecutar el script principal:
   - **Linux/macOS**: `./ejecutar.sh`
   - **Windows**: `ejecutar.bat`

### Requisitos Mínimos
- Java 8 o superior instalado
- Sistema operativo compatible (Windows, Linux, macOS)

### Estructura Final Esperada
```
distribucion/
├── README.md
├── INFORMACION_TECNICA.md
├── INSTRUCCIONES_COMPRESION.md
├── ejecutar.sh (Linux/macOS)
├── ejecutar.bat (Windows)
├── ejerciciouno/
│   ├── run.sh / run.bat
│   ├── libs/db4o-8.0.249.16098-all-java5.jar
│   └── target/ejerciciouno-executable.jar
├── ejerciciodos/
│   ├── run.sh / run.bat
│   ├── libs/db4o-8.0.249.16098-all-java5.jar
│   └── target/ejerciciodos-executable.jar
└── ejerciciotres/
    ├── run.sh / run.bat
    └── target/ejerciciotres-executable.jar
```

## 📧 Información de Entrega

### Nombre del Archivo Sugerido
- `DB4O_TP2_Distribucion_[TuNombre]_[Fecha].zip`

### Ejemplo
- `DB4O_TP2_Distribucion_Gustavo_2025-09-21.zip`

### Contenido del Email/Mensaje
```
Asunto: TP2 Bases de Datos II - Distribución Final

Estimado/a [Profesor/Evaluador],

Adjunto encontrará la distribución final del TP2 de Bases de Datos II.

Contenido:
- 3 ejercicios completamente funcionales
- JARs ejecutables independientes
- Scripts de ejecución para múltiples plataformas
- Documentación completa
- Librerías incluidas

Instrucciones de uso:
1. Descomprimir el archivo
2. Ejecutar ./ejecutar.sh (Linux/macOS) o ejecutar.bat (Windows)
3. Seleccionar el ejercicio a ejecutar

Requisitos: Java 8+

Saludos cordiales,
[Tu nombre]
```

## 🔍 Verificación Final

### Comando de Verificación Rápida
```bash
# Verificar estructura
find distribucion -name "*.jar" | wc -l  # Debe ser 3
find distribucion -name "*.sh" | wc -l   # Debe ser 4
find distribucion -name "*.bat" | wc -l  # Debe ser 4

# Verificar tamaños
du -sh distribucion/  # Debe ser ~21M
```

### Test de Funcionamiento
```bash
# Probar script principal
cd distribucion
echo "4" | ./ejecutar.sh  # Debe mostrar menú y salir
```

---

**¡Listo para entregar!** 🚀
