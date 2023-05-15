# small-square-microservice
# user-microservice-pragma

<br />
<div align="center">
<h3>USER-MICROSERVICE</h3>
  <p align="center">En este microservicio se encuantra la segunda historia de usuario que tiene los siguientes criterios de aceptacion</p>
</div>
  <ol start="numero"> ... </ol>
  <ol start="1">
  <li>La creación de un restaurante requiere los siguientes campos obligatorios:Nombre, NIT, Direccion, Telefono, UrlLogo y el id del usuario propitario.</li>
  <li>Al momento de la creación del restaurante, se debe validar que el el id del usuario corresponda a un usuario con ese rol</li>
  <li>Los campos NIT y TelefonoRestaurante deben ser únicamente numéricos. El campo TelefonoRestaurante debe contener un máximo de 13 caracteres y puede contener el símbolo +. Ejemplo: +573005698325.</li>
  <li>El nombre del restaurante puede contener números, pero no se permiten nombres con sólo números.</li>
</ol>


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
