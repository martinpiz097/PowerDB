- 1.1
    - Se añadió uso de cursores y el motor de almacenamiento ha sido rediseñado.
- 1.1.1 
    -Se agrego opción de cambiar nombre a base de datos.

- 1.2 
    - Se agregaron funciones select sum, max, min y avg y opcion de escoger la carpeta en donde
    se alojará la base de datos.
    - Se añadieron clases para insert multihilo, por ahora hay problemas con que no todos los elementos se insertan 	asi que no serán ocupadas.

- 1.3
    - Se añadieron funciones:
    - getFirstObject que permite rescatar el primer objeto que cumpla con un valor especifico en su campo.
    - getStorePath que permite obtener la ruta en donde está almacenada la base de datos.
    - insertTable que permite insertar un objeto Table en la base de datos y comprobando que no exista otra con el mismo nombre.
    - Se añadió un constructor nuevo para escoger en qué carpeta se guardará la base de datos.
    - Se modificaron clases multihilo para posteriores pruebas.

- 1.3.1 
    - Se corrigio problema de rutas de guardado
    - Se corrigio problemas con foreach en electrolist
    - Falta correccion de problema en droptable
    
- 2.0
    - Se migra proyecto a maven

- 2.1
    - Se aplica estandar tiger-bridge para asociar proyecto con 
    gestor de almacenamiento
    
- 2.1.1
    - Correcciones menores
    
- 2.2
    - Se externaliza la configuracion del gestor de almacenamiento a utilizar,
    ahora se modifica un archivo externo indicando el nombre completo
    de la clase que extiende de StoreManager
    
- 2.2.1
    - Correcciones en redundancia de codigo
    