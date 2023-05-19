# MediTec

MediTec es una API REST que proporciona acceso a los datos de una clínica médica. La API sigue el principio StateLess, lo que significa que cada solicitud es independiente de las anteriores. Esto hace que la API sea más escalable y fácil de mantener.

La API se implementa utilizando el framework Spring Boot. Spring Boot es un marco de trabajo que facilita la creación de aplicaciones Java de producción.

## Tecnologías usadas
<div align="left">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" height="40" width="52" alt="java logo"  />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" height="40" width="52" alt="spring logo"  />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" height="40" width="52" alt="mysql logo"  />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" height="40" width="52" alt="intellij logo"  />
</div>

* Java JDK 17
* Spring Boot 3.0.6
* MySql 8.0.33
* IntelliJ Community Edition 2023

## Endpoints
La API proporciona los siguientes endpoints:

1. Guardar Pacientes y Medicos en la Base de Datos (**Create**)
    * /pacientes - (POST)
        <details open>
        <summary>Ejemplo del cuerpo de la solicitud (Payload)</summary>

        ```JSON
        {
          "nombre": "James Foster",
          "email": "foster.jamess@gmail.com",
          "documento": "71157474",
          "telefono": "927872143",
          "direccion": {
              "calle": "Calle 15",
              "distrito": "Surco",
              "ciudad": "Lima",
              "numero": "157",
              "complemento": "n"
          }
        }
        ```
        </details>
    * /medicos - (POST)

         <details>
          <summary>Ejemplo del cuerpo de la solicitud (Payload)</summary>

        ```JSON
          {
            "nombre": "Jorge Chavez",
            "email": "chavez.jorge@gmail.com",
            "documento": "87657874",
            "telefono": "927452543",
            "especialidad": "PEDIATRIA",
            "direccion": {
                "calle": "Calle 15",
                "distrito": "Miraflores",
                "ciudad": "Lima",
                "numero": "452",
                "complemento": "b"
            }
          }
        ```
        </details>

2. Leer (**Read**)
    * /pacientes - (GET)
    * /medicos - (GET)
    * /pacientes/{id} - (GET) Ver un paciente en específico.
    * /medicos/{id} - (GET) Ver un médico en específico.

    Tambien es posible usar query params para filtrar o paginar:

    **_/medicos?size=5&page=1&sort=nombre_**

3. Actualizar datos de Pacientes y Medicos (**Update**)
    * /pacientes - (PUT)
    * /medicos - (PUT)
      <details>
      <summary>Ejemplo del cuerpo de la solicitud (Payload)</summary>

      ```JSON
      {
        "id":8,
        "nombre": "Jorge Chavez"
      }
      ```
    </details>
4. Borrar Logicamente (No se borra registros de la  base de datos) (**Delete**)
    * /pacientes/{id}
    * /medicos/{id}

Todas estas peticiones estarán bloqueadas. Para poder acceder a ellas, se deberá usar el token de autenticación que retorna el login:

### **Endpoint:** /login

Cuerpo de la solicitud:
```json
  {
    "nombre": "username",
    "clave": "password"
  }
```

