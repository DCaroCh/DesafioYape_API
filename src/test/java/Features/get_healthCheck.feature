# language: es

Característica: Comprobar el estado de la api

  Esquema del escenario: Comprobar que la api esta funcionando correctamente

    Dado se seteo el "<endpoint>" correcto
    Cuando se envia la peticion get
    Entonces se validara que el status es 201

    Ejemplos:
      | endpoint |
      | ping     |

  Esquema del escenario: Comprobar que al escribir incorrectamente el endpoint no responda 201

    Dado se seteo el "<endpoint>" correcto
    Cuando se envia la peticion get
    Entonces se comprobara que el status es 404

    Ejemplos:
      | endpoint |
      | pings    |