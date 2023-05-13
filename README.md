# REST API Spring Boot

Esta es una REST API desarrollada con Spring Boot para gestionar información personal. Es parte del proyecto de #YoProgramo.

## Endpoints

A continuación se listan los endpoints disponibles en la API:

### GET /all/

Este endpoint devuelve todos los datos disponibles para la página principal.

### POST /login

Este endpoint se utiliza para enviar las credenciales de usuario.

### GET /authorization

Este endpoint se utiliza para verificar el token JWT.

### GET/PUT /aboutme

Este endpoint se utiliza para ver y modificar la sección "Acerca de mí".

### GET/PUT /contact

Este endpoint se utiliza para ver y modificar la información de contacto.

### GET/PUT /education

Este endpoint se utiliza para ver y modificar la información académica y de carreras.

### GET/PUT /experience

Este endpoint se utiliza para ver y modificar la información de proyectos y trabajos.

### GET /experience/{tipo}

Este endpoint se utiliza para ver la información de proyectos y trabajos de un tipo específico.

### GET/PUT /skill

Este endpoint se utiliza para ver y modificar las habilidades.

### GET /skill/{tipo}

Este endpoint se utiliza para ver las habilidades de un tipo específico.
