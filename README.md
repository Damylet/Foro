# FORO   (EN DESARROLLO)

## Descripción
Esta API permite la gestión de tópicos en un foro, incluyendo la creación, consulta, actualización y eliminación de tópicos. 
Además, implementa autenticación y autorización utilizando JWT.

## Configuración del Proyecto
- **Java**: Versión 17 en adelante
- **Maven**: Initializr utiliza la versión 4
- **Spring Boot**
- **Formato del Proyecto**: JAR

## Dependencias
- **Lombok**
- **Spring Web**
- **Spring Boot DevTools**
- **Spring Data JPA**
- **Flyway Migration**
- **MySQL Driver**
- **Validation**
- **Spring Security**

## Tecnologías
- Java
- Spring Boot
- Spring Security
- JWT
- JPA
- MySQL Workbench
- Insomnia (para pruebas de API)

## Endpoints
- `POST /tópicos`: Crear un nuevo tópico.
- `GET /tópicos`: Listar todos los tópicos.
- `GET /tópicos/{id}`: Obtener un tópico específico.
- `PUT /tópicos/{id}`: Actualizar un tópico.
- `DELETE /tópicos/{id}`: Eliminar un tópico.

## Autenticación
La API utiliza JWT para la autenticación. Los usuarios deben autenticarse enviando una solicitud `POST` a `/login` con sus credenciales. 
El token JWT recibido debe ser incluido en el encabezado `Authorization` de las solicitudes subsecuentes.

## Ejemplo de solicitud de autenticación
```json
{
    "username": "usuario",
    "password": "contraseña"
}


CREADO POR DAMYLET MIRENA CORREO: mirenadamylet@gmail.com  Whatsapp: +56988621333
