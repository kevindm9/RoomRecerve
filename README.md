# RoomReserve
# MVP.
El proyecto busca desarrollar una aplicación que permita a los  usuarios hacer una reservación en un hotel deseado a una de sus habitaciones disponibles . La aplicación permitirá llevar el control de los Diferentes hoteles, de las habitaciones, el pago y la gestión de estas mismas y así poder prestar un mejor servicio para el usuario final y el administrador llevar mejor un informe semanal y mensual de sus servicios. 
	El sistema inicialmente brindará apoyo en los siguientes procesos:
  ● Visualizar habitación: El usuario podrá consultar las características, disponibilidad y reservar la habitación
  ● Reservar habitación: Un usuario después de haber seleccionado la habitación acorde a sus necesidades, puede generar una reserva de la misma estableciendo el medio de pago siempre y cuando la habitación se encuentre disponible en las fechas seleccionadas.
  ● Adicionar habitación: Un administrador podrá realizar la inserción de una habitación a su Hotel y modificar los días de disponibilidad

# Components
Vista de componentes y conectores(uml)
![Diagrama Conectores](docs/Uml/Diagrama%20Conectores.jpg)

La arquitectura utilizada fue la de cliente-servidor por medio del estilo arquitectónico de capas.

# MODELO DE CONTEXTO(C4).
![C4 -Nivel 1](docs/C4/C4%20-Nivel%201.jpg)
# VISTA DE CONTENEDORES Y COMPONENTES(C4)
![C4 -Nivel 2](docs/C4/C4%20-Nivel%202.jpg)
![C4 -Nivel 3](docs/C4/C4%20-Nivel%203.jpg)
# VISTA DE MÓDULOS (UML).
VISTA DE SERVER.
![Diagrama modulos Server](docs/Uml/Diagrama%20modulos%20Server.png)
VISTA DE CLIENTE.
![Diagrama modulos cliente](docs/Uml/Diagrama%20modulos%20cliente.png)

# RESUMEN DE LAS DECISIONES DE ARQUITECTURA Y SU JUSTIFICACIÓN.
Para esta aplicación se ha optado por una aplicación de escritorio con posible migración (en un reléase superior) a aplicaciones móviles o web – Tomando como opción  idónea la solución "Cliente - Servidor" para la primera iteración, esto debido a que solución "Cliente - Servidor" posee grandes ventajas que ayudarán al desarrollo de esta aplicación, como lo es el facilitar la integración con otros sistemas (característica necesaria para los pagos en línea, el envío de mensajes vía email y la utilización del GPS), además de garantizar una modularidad y escalabilidad del sistema (buscando ampliar las funcionalidades y aportar valor al cliente en cada iteración).Por su parte, como decisión de lenguaje de programación para trabajar, el equipo se inclina hacia el uso de "Java" debido a que, además de ser uno de los lenguajes más populares hoy en día, de acuerdo con el TIOBE índex, el cual se puede encontrar en el siguiente enlace: https://www.tiobe.com/tiobe-index/, es un lenguaje de fácil comprensión, seguro y permite ser compilado en cualquier plataforma (gracias a la máquina virtual de Java "JVM"), otorgando al equipo y al producto final, el poder acoger una mayor cantidad de clientes (Clientes usuarios de Windows, clientes usuarios de Linux, clientes usuarios de MacOS, entre otros.

