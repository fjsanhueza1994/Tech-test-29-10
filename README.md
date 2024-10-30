## Descripción

Este proyecto tiene como objetivo desarrollar una API que consulte información sobre canciones de un artista específico utilizando la API de iTunes. La API permite buscar canciones de un artista, devolviendo detalles como el nombre de la canción, el nombre del álbum, la URL de vista previa, el precio y la fecha de lanzamiento. 

Además, se desarrolló un frontend en Angular que permite al usuario interactuar con esta API de manera amigable, facilitando las búsquedas de canciones de manera sencilla.

## Estructura del Proyecto

El proyecto se divide en dos contenedores:

1. **Backend**: Implementado en Java con Spring Boot, este contenedor expone la API que consulta la información de iTunes y gestiona las respuestas para el frontend.
2. **Frontend**: Construido en Angular, este contenedor proporciona una interfaz web para que los usuarios busquen canciones de un artista específico e interactúen con el backend.

## Requisitos Previos

Antes de comenzar, asegúrate de tener Docker instalado en tu sistema. [Instrucciones para instalar Docker](https://docs.docker.com/get-docker/).

## Instrucciones de Despliegue

1. **Clonar el Repositorio**:
   ```bash
   git clone <URL_del_repositorio>
   cd Tech-test-29-10
2. **Construir y Ejecutar los Contenedores Docker**: Asegúrate de que el archivo docker-compose.yml esté configurado correctamente en el directorio raíz del proyecto. Luego, ejecuta el siguiente comando para construir y levantar los contenedores de backend y frontend:
   ```bash
   docker-compose up --build
3. **Acceder a la aplicación**:
   - El backend estará disponible en http://localhost:8081.
   - El frontend estará disponible en http://localhost:4200.
4. **Uso de la aplicación**: En la interfaz web del frontend, ingresa el nombre de un artista en el campo de búsqueda y presiona "Buscar". La aplicación consultará la API de iTunes a través del backend y mostrará los resultados en pantalla, incluyendo el nombre de las canciones, álbumes, precios y enlaces de vista previa.

## Notas Técnicas

- Cacheo de Solicitudes: La API del backend implementa un sistema de cacheo para almacenar las respuestas de iTunes por un tiempo determinado, reduciendo así las llamadas directas a la API externa y mejorando la eficiencia.
- Estructura de la Respuesta: La API devuelve un objeto que incluye:
   - Total de álbumes declarados en las canciones
   - Total de canciones obtenidas
   - Listado de detalles de cada canción obtenida de la búsqueda, con información como el nombre del álbum, nombre de la canción, URL de vista previa, precio y fecha de lanzamiento.

## Licencia

Este proyecto es solo con fines de evaluación técnica y aprendizaje.
