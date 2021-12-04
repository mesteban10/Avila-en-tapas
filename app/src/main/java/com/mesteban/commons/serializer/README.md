# JsonSerializer

JsonSerializer es una abstracción (interfaz) que se usa para poder serializar modelos de datos a
cadenas json y viceversa, transformar cadenas json a modelos de datos.

La clase tiene los siguientes métodos:

- toJson(modelo: T, typeClass: Class<T>) se le pasa el modelo que se desea serializar y su clase.
- fromJson(json: String, typeClass<T>): T se le pasa la cadena en formato json, el modelo deseado y
  devuelve el objeto obtenido.

## Concreciones

- GsonSerializer. Es una concreción que usa la librería de Google llamada Gson para serializar
  modelos. Para poder usarla, necesitamos añadir al build.gralde:
  ```
    implementation 'com.google.code.gson:gson:X.X.X'
  ```
  Donde X.X.X es la versión más reciente.

## Referencias Bibliográficas

- [Manual Básico](../../../../../../../../assets/commons/gson_basic.pdf)
- [Repositorio de la librería](https://github.com/google/gson)
