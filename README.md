<br />
<div align="center">
<h3 align="center">PRAGMA POWER UP 2025</h3>
  <p align="center">
    El reto cosiste en diseñar el backend de un sistema llamado Plazoleta de Comidas  que tiene diferentes restaurantes,
    cada uno con un menú particular
    La plataforma busca que cualquier persona identificada como cliente en el sistema pueda hacer un pedido en cualquier 
    restaurante de la plazoleta, buscando en los menús de cada uno. En el portal web el Cliente podrá ver la variedad de platos que ofrece cada uno de los diferentes establecimientos.
</p>
</div>

### Elaborado con

* ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
* ![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
* ![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
* ![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)


<!-- GETTING STARTED -->
## Iniciamos la Diversion del Reto PowerUp

Para obtener una copia local en funcionamiento, siga estos pasos.

### Prerrequisitos

* JDK 21 [https://jdk.java.net/java-se-ri/11](https://jdk.java.net/java-se-ri/11)
* Gradle [https://gradle.org/install/](https://gradle.org/install/)
* MySQL [https://dev.mysql.com/downloads/installer/](https://dev.mysql.com/downloads/installer/)

### Herramientas
* IntelliJ Community [https://www.jetbrains.com/idea/download/](https://www.jetbrains.com/idea/download/)
* Postman [https://www.postman.com/downloads/](https://www.postman.com/downloads/)

### Instalacion

1. Clonar el repositorio
2. Cambiar los directorios de archivos
   ```sh
   cd power-up-arquetipo
   ```
3. Crear una nueva BD en MySQL llamada powerup
4. Actualizar la configuración de conexión de la base de datos
   ```yml
   # src/main/resources/application.yml   
   spring:
      datasource:
          url: jdbc:mysql://localhost/powerup
          username: root
          password: 12345
   ```

<!-- Modo de Uso -->
## Modo de Uso

1. Haga clic derecho en la clase PowerUpApplication y seleccione  Run
2. Abrir [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html) en su navegador web

<!-- ROADMAP -->
## Tests

- Haga clic derecho en la carpeta de pruebas y seleccione Ejecutar test con cobertura


