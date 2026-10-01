# Editor de Colores RGB con JavaFX

Aplicación de escritorio desarrollada en Java con JavaFX para la manipulación y visualización dinámica de colores utilizando el modelo RGB y formato Hexadecimal. 

Este proyecto fue desarrollado como práctica de Programación Orientada a Objetos y diseño de interfaces (UI), demostrando la implementación de propiedades y listeners en tiempo real.

## Características Técnicas
* **Tecnologías:** Java, JavaFX, FXML, y Scene Builder.
* **Arquitectura:** Diseño de interfaz modular dividido en 9 secciones independientes.
* **Manejo de Eventos:** Uso exclusivo de `textProperty()`, `valueProperty()`, `selectedProperty()` y `selectedToggleProperty()` mediante Listeners, omitiendo el uso del controlador clásico `OnAction`.
* **Componentes Utilizados:** TextField, Spinner, Slider, CheckBox, RadioButton (ToggleGroup), ToggleButton, ColorPicker y TextArea.
* **Validación:** Implementación de expresiones regulares (Regex) para la interpretación de códigos de color Hexadecimales (`#RRGGBB`).
