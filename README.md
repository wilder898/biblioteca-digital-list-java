## Sistema de Biblioteca Digital

## Descripción del Proyecto

Este proyecto es una **aplicación de consola en Java** que permite gestionar una biblioteca digital. Los usuarios pueden crear, leer, actualizar, eliminar y buscar libros, así como visualizar estadísticas generales de lectura.

Entre las funcionalidades principales se incluyen:

- Agregar libros con múltiples autores.
- Marcar libros como leídos y registrar el tiempo de lectura.
- Visualizar libros en formato de tabla.
- Buscar libros por título, autor o ISBN.
- Estadísticas de libros leídos y promedio de horas de lectura.

## Estructura de Clases
```
com.sena.app
└── models
    └── Book.java    # Clase modelo con atributos como título, editorial, ISBN, autores, etc.

LibraryApp.java       # Clase principal con el menú de interacción y lógica CRUD
```

### Clase `Book`

Ubicación: `com.sena.app.models.Book`

Atributos:
- `int id`
- `String title`
- `String editionDate`
- `String editorial`
- `String isbn`
- `List<String> authors`
- `boolean readed`
- `int timeReaded`

Métodos principales:
- Getters y setters para todos los atributos.
- `toString()` para visualizar los detalles del libro.

### Clase `LibraryApp`

Ubicación: `LibraryApp.java`

Responsable de:
- Ejecutar el menú de la aplicación.
- Implementar las operaciones CRUD sobre libros.
- Generar estadísticas y búsquedas.
- Mostrar los datos en tabla.

## Comandos de Compilación y Ejecución

### Requisitos previos

- Java JDK 8 o superior
- Estructura de carpetas correctamente configurada:
```
/src
 └── com
     └── sena
         └── app
             └── models
                 └── Book.java
LibraryApp.java
```

### Compilación


### Ejecución


# biblioteca-digital-list-java
