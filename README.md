# Mi Horario

Este proyecto es una aplicación de Android para gestionar horarios de clases. Permite añadir clases, ver el horario y consultar la clase actual.

## Clases

### `MainActivity`

La actividad principal que muestra el menú con opciones para añadir clases, ver el horario y consultar la clase actual.

#### Métodos importantes:
- `onCreate(Bundle?)`: Inicializa la actividad y configura los botones para navegar a otras actividades.

### `AddClassActivity`

Permite al usuario añadir una nueva clase al horario.

#### Métodos importantes:
- `onCreate(Bundle?)`: Inicializa la actividad, configura el `Spinner` con los días de la semana y maneja los eventos de los botones para añadir o cancelar la clase.

### `ViewScheduleActivity`

Permite al usuario ver el horario de clases para un día específico.

#### Métodos importantes:
- `onCreate(Bundle?)`: Inicializa la actividad, configura el `Spinner` con los días de la semana y maneja el evento del botón para consultar el horario.
- `getScheduleForDay(String)`: Recupera el horario de clases desde `SharedPreferences` para el día seleccionado.

### `CurrentClassActivity`

Permite al usuario consultar la clase actual basada en el día y la hora.

#### Métodos importantes:
- `onCreate(Bundle?)`: Inicializa la actividad, muestra la fecha y hora actual, y recupera la clase actual desde `SharedPreferences`.

URL: 
