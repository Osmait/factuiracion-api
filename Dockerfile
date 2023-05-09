# Utiliza la imagen base de OpenJDK 17 para construir la aplicación
FROM openjdk:17-jdk-alpine3.14

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia los archivos de la aplicación al directorio de trabajo
COPY build/libs/*.jar ./

# Expone el puerto 8080 para la aplicación
EXPOSE 8080

# Define el comando de inicio para la aplicación
CMD ["java", "-jar", "facturationProject-0.0.1-SNAPSHOT.jar"]