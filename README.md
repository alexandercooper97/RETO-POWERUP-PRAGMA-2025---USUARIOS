# Plazoleta de Comidas - Microservicio Usuarios

<div align="center">
<h3 align="center" style="color: #9900ff">PRAGMA POWER UP 2025</h3>
  <p align="center">
    Backend para gestión de usuarios (Administradores, Propietarios, Empleados y Clientes)  
    con autenticación basada en roles para la plataforma de restaurantes.
  </p>
</div>

---

## <span style="color: #9900ff">Historias de Usuario (HU)</span>

| ID  | Rol              | Nombre                          | Descripción                                                                 | Criterios de Aceptación |
|-----|------------------|---------------------------------|-----------------------------------------------------------------------------|-------------------------|
| 1   | Administrador    | Crear Propietario               | Registrar cuentas para propietarios de restaurantes                         | [Ver detalles](#hu1)    |
| 5   | Todos los roles  | Autenticación en el sistema     | Control de acceso basado en roles con JWT                                   | [Ver detalles](#hu5)    |
| 6   | Propietario      | Crear cuenta Empleado           | Registrar empleados para gestionar pedidos en su restaurante                | [Ver detalles](#hu6)    |
| 8   | Cliente          | Crear cuenta Cliente            | Autoregistro para realizar pedidos en la plazoleta                         | [Ver detalles](#hu8)    |

---

### <span style="color: #9900ff">Detalles de Historias de Usuario</span>

#### <a id="hu1">HU1 - Crear Propietario</a>
**Campos obligatorios:**  
✔ Nombre, Apellido, DocumentoDeIdentidad (numérico único)  
✔ Celular (máx. 13 chars, ej: +573006698325)  
✔ Correo (validar formato), Clave (encriptada con BCrypt)  
✔ Usuario asigna rol **Propietario** automáticamente  
✔ Validar mayoría de edad  

#### <a id="hu5">HU5 - Autenticación</a>
**Flujo:**  
1. Login con correo/clave  
2. Validación de credenciales + límite de intentos  
3. Generación de JWT con claims de rol  
4. Autorización por rol en endpoints:  
   - `/propietarios`: Solo Admin  
   - `/empleados`: Solo Propietario  
   - `/platos`: Solo Propietario del restaurante  

#### <a id="hu6">HU6 - Crear Empleado</a>
**Restricciones:**  
⚠ Solo el Propietario puede crear empleados para SU restaurante  
**Campos:** Nombre, Apellido, Documento, Celular, Correo, Clave (BCrypt)  
**Rol asignado:** Empleado  

#### <a id="hu8">HU8 - Crear Cliente</a>
**Autoregistro:**  
✔ Campos: Nombre, Apellido, Documento, Celular, Correo, Clave  
✔ Rol automático: Cliente  

---

## <span style="color: #9900ff">Tecnologías Usadas</span>

<div align="center">

| Capa           | Tecnologías                                                                                   |
|----------------|----------------------------------------------------------------------------------------------|
| Backend        | ![Java](https://img.shields.io/badge/Java-ED8B00?logo=java&logoColor=white) ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?logo=spring&logoColor=white) |
| Seguridad      | ![JWT](https://img.shields.io/badge/JWT-000000?logo=JSON%20web%20tokens&logoColor=white) ![BCrypt](https://img.shields.io/badge/BCrypt-02569B?logo=bcrypt&logoColor=white) |
| Base de Datos  | ![MySQL](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=white) ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?logo=hibernate&logoColor=white) |
| Herramientas   | ![Gradle](https://img.shields.io/badge/Gradle-02303A?logo=gradle&logoColor=white) ![Swagger](https://img.shields.io/badge/Swagger-85EA2D?logo=swagger&logoColor=black) |

</div>

---

## <span style="color: #9900ff">Configuración Inicial</span>

```bash
# 1. Clonar repositorio
git clone [repo-url] && cd power-up-usuarios

# 2. Crear BD MySQL
CREATE DATABASE powerup;

# 3. Configurar application.yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/powerup
    username: [user]
    password: [password]
  jpa:
    hibernate.ddl-auto: update

# 4. Ejecutar (puerto 8081)
./gradlew bootRun
