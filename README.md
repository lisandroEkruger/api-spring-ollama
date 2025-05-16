# Proyecto: API con Spring AI y Ollama

## Descripción
Este proyecto demuestra cómo crear una API sencilla en Java que utiliza **Spring Boot** junto con **Spring AI** para interactuar con modelos de inteligencia artificial, específicamente el modelo **LLaMA 2** de **Ollama**. La API permite realizar consultas y obtener respuestas generadas por el modelo de lenguaje.

## Características
- Utiliza **Docker** para ejecutar el servicio de Ollama en un contenedor.
- Implementa un controlador y un servicio en **Spring Boot**.
- Permite realizar solicitudes HTTP a través de herramientas como **Postman**.
- Respuestas personalizadas generadas por el modelo **LLaMA 2**.

## Tecnologías Utilizadas
- **Java** y **Spring Boot**: Desarrollo de la API.
- **Docker**: Gestión del contenedor que ejecuta Ollama.
- **Postman**: Herramienta para probar la API.
- **Ollama**: Modelo de inteligencia artificial (LLaMA 2).

## Requisitos
- **JDK 21** o superior.
- **Maven** para la gestión del proyecto.
- **Docker** instalado y configurado.
- **Postman** para pruebas.

## Instalación y Ejecución

### 1. Clonar el repositorio
```bash
git clone https://github.com/turepositorio/api-spring-ollama.git
cd api-spring-ollama
```

### 2. Crear el contenedor Docker
Configura un archivo `docker-compose.yml` para levantar el servicio de Ollama:
```yaml
version: '3.8'
services:
  ollama:
    image: ollama/ollama
    container_name: ollama-container
    ports:
      - "11434:11434"
```
Ejecuta el contenedor con el siguiente comando:
```bash
docker-compose up -d
```

### 3. Configurar el modelo LLaMA 2
Ejecuta el modelo dentro del contenedor:
```bash
docker exec ollama-container ollama run llama2
```

### 4. Construir y ejecutar la API
1. Importa el proyecto en tu IDE favorito.
2. Ejecuta el proyecto con Maven:
```bash
mvn spring-boot:run
```

### 5. Probar la API
Usa **Postman** para probar la API haciendo una solicitud GET a:
```
http://localhost:8080/api/v1/generate?promptMessage=TuMensaje
```

Por ejemplo:
```plaintext
http://localhost:8080/api/v1/generate?promptMessage=¿Qué es inteligencia artificial?
```

## Créditos
Este proyecto está basado en el tutorial de [La Tecnología Avanza](https://www.youtube.com/channel/@latecnologiaavanza) que explica el proceso paso a paso.
