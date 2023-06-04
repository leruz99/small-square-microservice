# small-square-microservice
<br />
<div align="center">
<h3>small-square-microservice</h3>
 <p align="center">En este microservicio se encuantra la quinta historia de usuario que tiene los siguientes criterios de aceptacion</p>
</div>

  <ol start="numero"> ... </ol>
  <ol start="1">
  <li> El inicio de sesión es a través de correo y clave.</li>
  <li> Se debe validar usuario y contraseña correcta.</li>
  <li> El número de intentos puede ser ilimitado.</li>
  <li> Una vez iniciada la sesión, se debe garantizar que con esa sesión iniciada, cada usuario tiene los permisos para realizar las acciones que le correspondan a su rol.</li>
  <li> Agregar validacion de autenticacion a los siguientes endpoint:
    -si creo un usuario propietario, validar que la persona que llamo el servicio sera usuario administrador.
   
    -si creo un usuario empleado, validar que la persona que llamo el servicio sea usuario propietario.
   
    -si creo un restaurante, validar que la persona que llamo el servicio sea un usuario administrador.
   
    -si creo/modifico un plato, validar que la persona que llamo el servicio sea un usuario propietario y sea el propietario del restaurante al cual se le va a asignar ese plato.</li>
</ol>

### Nota: En esta versión de la aplicación, no está contemplada la recuperación de contraseña.


### Built With

* ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
* ![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
* ![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
* ![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)


<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these steps.

### Prerequisites

* JDK 17 [https://jdk.java.net/java-se-ri/17](https://jdk.java.net/java-se-ri/17)
* Gradle [https://gradle.org/install/](https://gradle.org/install/)
* MySQL [https://dev.mysql.com/downloads/installer/](https://dev.mysql.com/downloads/installer/)

### Recommended Tools
* IntelliJ Community [https://www.jetbrains.com/idea/download/](https://www.jetbrains.com/idea/download/)
* Postman [https://www.postman.com/downloads/](https://www.postman.com/downloads/)

### Installation

1. Clone the repository
2. Change directory
   ```sh
   cd user-microservice
   git clone + url del repositorio 
   ```
3. Create a new database in MySQL called powerup
4. Update the database connection settings
   ```yml
   # src/main/resources/application-dev.yml
   spring:
      datasource:
          url: jdbc:mysql://localhost/powerup
          username: root
          password: <your-password>
   ```
5. After the tables are created execute src/main/resources/data.sql content to populate the database
6. Open Swagger UI and search the /auth/login endpoint and login with userDni: 123, password: 1234

<!-- USAGE -->
## Usage

1. Right-click the class PowerUpApplication and choose Run
2. Open [http://localhost:8001/swagger-ui/index.html](http://localhost:8001/swagger-ui/index.html) in your web browser

<!-- ROADMAP -->
## Tests

- Right-click the test folder and choose Run tests with coverage
