# Home Manager 🏠

Aplicación para gestionar tareas domésticas: Planificación diaria de comidas, listas de compras, pagos recurrentes y presupuestos (en desarrollo).

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0-blue.svg)](https://kotlinlang.org/)
[![Estado](https://img.shields.io/badge/Estado-En%20Desarrollo%20Activo-yellowgreen)](https://github.com/acano99/my_home)

<p align="center">
  <img src="assets/meal_plan_placeholder.png" alt="Prototipo UI Comidas" width="250"> <!-- Añade tu propia imagen luego -->
</p>

## 📌 Estado Actual (v0.1.0-alpha)
**¡El proyecto está en fase temprana de desarrollo!**  
Trabajando actualmente en:
- 🛠️ **Integración de SQLite** para almacenamiento local de comidas.
- 📅 **Lógica básica de planificación diaria** (desayuno, almuerzo, comida, merienda).
- ✏️ **UI preliminar** para añadir/editar comidas (Jetpack Compose).

## 🍽️ Funcionalidades Implementadas (Próximamente)
### Planificación de Comidas
- ✅ Añadir comidas por día y tipo (desayuno, almuerzo, etc.).
- � Editar o eliminar comidas programadas (en desarrollo).
- 📆 Vista semanal simplificada (tabla o lista).

## 🛒 Futuras Funcionalidades
| Módulo         | Descripción                                                                 |
|----------------|-----------------------------------------------------------------------------|
| **Listas de Compras** | Crear listas, marcar productos comprados, organización por categorías.     |
| **Gestión de Pagos**  | Recordatorios de pagos recurrentes (luz, alquiler), historial de pagos.    |
| **Presupuestos**      | Seguimiento de gastos vs ingresos (en fase de diseño).                     |

## 🛠️ Tecnologías Usadas
- **Kotlin Multiplatform (KMP)**: Lógica compartida entre plataformas.
- **SQLite**: Base de datos local para almacenamiento persistente.
- **Jetpack Compose**: UI en Android (actualmente en rediseño).
- **AndroidX Room**: Librería para gestión de la base de datos (en integración).

## 🔧 Instalación (Para Desarrolladores)
1. Clona el repositorio:
   ```bash
   git clone https://github.com/acano99/my_home.git