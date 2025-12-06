Notes and categories es una aplicación nativa de Android desarrollada en **Java** que permite la gestión de notas organizadas por categorías.

El proyecto está diseñado con fines educativos para demostrar la implementación de:
Base de Datos Local (SQLite): Utilizando la librería Room
  Relaciones 1:N: Una categoría puede tener múltiples notas, configurado mediante *Foreign Keys* y borrado en cascada
Consultas Avanzadas: Búsqueda de texto mediante cláusulas LIKe y agrupación/filtrado por categorías
Arquitectura MVC  Separación estricta entre la lógica de datos, la interfaz de usuario y el controlador que las une

1.  Gestión de Categorías: Crear nuevas categorías para agrupar notas
  ![crear categoria](https://github.com/user-attachments/assets/16541e68-45cc-4c9d-9a6b-3c5d09ffba22)

2.  
3.  Gestión de Notas: Crear notas con título, contenido y fecha automática, vinculadas a una categoría existente
4.  Búsqueda Dinámica: Filtrado de notas por título o contenido en tiempo real
5.  Filtrado por Categoría: Visualización exclusiva de notas pertenecientes a una categoría específica

