Notes and categories es una aplicación nativa de Android desarrollada en **Java** que permite la gestión de notas organizadas por categorías.

El proyecto está diseñado con fines educativos para demostrar la implementación de:
Base de Datos Local (SQLite): Utilizando la librería Room
  Relaciones 1:N: Una categoría puede tener múltiples notas, configurado mediante *Foreign Keys* y borrado en cascada
Consultas Avanzadas: Búsqueda de texto mediante cláusulas LIKe y agrupación/filtrado por categorías
Arquitectura MVC  Separación estricta entre la lógica de datos, la interfaz de usuario y el controlador que las une

1.  Gestión de Categorías: Crear nuevas categorías para agrupar notas
  ![crear categoria](https://github.com/user-attachments/assets/16541e68-45cc-4c9d-9a6b-3c5d09ffba22)
  categoria agregada
  ![categoria agregada](https://github.com/user-attachments/assets/8405d633-ae9c-4ec1-9e66-4941c7c7f4e7)

2.  Gestión de Notas: Crear notas con título, contenido y fecha automática, vinculadas a una categoría existente
   ![crear nota](https://github.com/user-attachments/assets/0fa016dc-accc-4b90-a1a8-b077256f58bb)

3.  Búsqueda Dinámica: Filtrado de notas por título o contenido en tiempo real
   ![filtro de busqueda](https://github.com/user-attachments/assets/5732408c-3b20-4500-9f11-fc4bc07a78f4)

4.  Filtrado por Categoría: Visualización exclusiva de notas pertenecientes a una categoría específica
    
