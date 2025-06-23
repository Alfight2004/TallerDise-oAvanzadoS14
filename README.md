# 🎮 Inventario de Cartas de Hearthstone
 
Este proyecto es una aplicación de consola en **Java** para gestionar un inventario de cartas del popular juego **Hearthstone**. Es una práctica básica de **POO (Programación Orientada a Objetos)** y manejo de estructuras de datos.
 
---
 
## 📌 Funcionalidades
 
El programa permite al usuario:
 
✅ **Agregar cartas** con nombre, clase, costo de maná, ataque y vida.  
✅ **Mostrar todo el inventario** de cartas guardadas.  
✅ **Buscar una carta** por su nombre.  
✅ **Eliminar una carta** del inventario.  
✅ **Salir del programa** de forma segura.
 
---
 
## ⚙️ Estructura del Proyecto
 
- **`Main.java`**  
  - Contiene el método `main` que inicializa la aplicación creando una instancia de `Inventario` y ejecuta el menú principal.
 
- **`Inventario.java`**  
  - Implementa la lógica principal:
    - Despliega el menú interactivo.
    - Permite agregar, mostrar, buscar y eliminar cartas.
    - Usa `HashMap` para almacenar las cartas usando el nombre como clave.
    - Utiliza `Scanner` para la entrada de datos por consola.
 
- **`Carta.java`**  
  - Clase que representa una carta de Hearthstone.
  - Atributos: nombre, clase, costo de maná, ataque y vida.
  - Método `toString` para mostrar la información de la carta de forma legible.
