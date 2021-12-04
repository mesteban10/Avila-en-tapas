# UT03-EX06 Tapas

Se pide gestionar el acceso y gestión de los datos de una aplicación para una competeción de tapas.

Se pide implementar lo siguientes detalles:

- Una gestión local en Ficheros.
- Una gestión local en SharedPreferences.
- Una gestión local con Base de Datos (Room).

Todas estos detalles implementarán una interfaz LocalDataSource que permita cambiar de una fuente a
otra.

## Funcionamiento de TapaDataRepositorio

El funcionamiento de obtención de datos siempre seguirá la misma lógica (fetchTapas y fetchTapa):

- Verifico si existen los datos en local, si existen, los devuelvo.
- Si no existen datos locales, los obtengo de remoto, los persisto en local y los devuelvo.
- Hay que controlar los posibles errores que puedan suceder (con Result)