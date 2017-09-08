# Taller: tecnologías y protocolos
#### Computación en la nube
#### Juliana Zúñiga

***

##### DESARROLLO DEL API


Este API desarrollado usando Spark Java

A continuación se describen cada uno de los servicios implementados en el API.

| Servicio | Método HTTP | URL | Body | Resultado |
| ------ | ------ | ------ | ------ | ------ |
| Obtener lista de equipos | GET | /api/v1/teams | - | Lista de equipos (Json)
| Obtener información de un equipo | GET | /api/v1/teams/{nombreEquipo} | - | Equipo (Json)
| Editar equipo | PUT | /api/v1/teams | Equipo (Json) | HTTP OK: 200
| Borrar equipo | DELETE | /api/v1/teams/{nombreEquipo} | - | HTTP OK: 200
| Agregar equipo | POST | /api/v1/teams | Equipo (Json) | HTTP OK: 200



El formato Json de un equipo es el siguiente:

```json
{
  "name":"nombreEquipo",
  "year":"añoFundacion",
  "titles":"cantidadTitulos"
}
```
##### Información adicional

Se retorna NOT FOUND (404) cuando se intenta acceder a la información de un equipo que no existe. En los casos en que la información enviada al API sea inválida, por ejemplo, cuando se trata de actualizar un  equipo con año de fundación igual a cero, se retorna BAD REQUEST (400).

***

### Para ejecutar  el proyecto:

Clonar el repositorio y, dentro de la carpeta del mismo, ejecutar:

```
$ mvn compile
```
```
$ mvn exec:java
```

Con lo anterior, se iniciará el servidor web local.

Para acceder a los clientes web de AngularJS y AJAX, ingresar a las siguientes URL:

> http://localhost:4567/angular

> http://localhost:4567/ajax
