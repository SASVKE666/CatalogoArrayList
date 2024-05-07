package main.Metodos.MenuMethodF.ZapatoMethodF;

//  importar libreria java.util.ArrayList para arreglos
//  importar libreria javax.swing.JOptionPane para uso de cajas de texto, ingreso de datos y cajas de opciones
import java.util.ArrayList;

import javax.swing.JOptionPane;

//  importar clase Casual para su uso en los arreglos
//  importar clase ZapatoMethod para uso del metodo zapato()
import main.Clases.Products.ZapatoF.Casual;
import main.Metodos.MenuMethodF.ZapatoMethod;

public class CasualMethod {

    static ArrayList<Casual> casualArray = new ArrayList<>();

    static int almacen = 0;

    public static void zapatoCasual() {

        // variable Integer para usar en el arreglo de Object[] y en el Do While
        Integer selectZapato = 0;

        // Do while para que se mantenga en selectZapato
        do {
            // Try catch para evitar que el programa termine si hay un error
            try {
                // Se crea un array de tipo Object que contiene las opciones que se mostrarán al
                // usuario en el cuadro de diálogo.
                Object[] options = { "Insertar", "Borrar", "Buscar", "Imprimir", "Editar", "Regresar" };
                /*
                 * "Seleccione una opción:": Es el mensaje que se muestra en el cuadro de
                 * diálogo.
                 * "Zapato Tenis Menu": Es el título del cuadro de diálogo.
                 * JOptionPane.DEFAULT_OPTION: Es el tipo de opciones por defecto que se
                 * mostrarán.
                 * JOptionPane.INFORMATION_MESSAGE: Es el ícono que se muestra en el cuadro de
                 * diálogo.
                 * null: Es el ícono personalizado que se puede mostrar en el cuadro de diálogo
                 * (en este caso no se utiliza).
                 * options: Es el array de opciones que se mostrarán al usuario.
                 * options[0]: Es la opción por defecto seleccionada al abrir el cuadro de
                 * diálogo.
                 * El resultado de la selección se guarda en la variable selectZapato.
                 */
                selectZapato = JOptionPane.showOptionDialog(null,
                        "Seleccione una opción:",
                        "Zapato Tenis Menu",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        options,
                        options[0]);

                // Se inicia una estructura switch que evalúa la variable selectZapato.
                switch (selectZapato) {
                    /*
                     * En caso de que selectZapato sea igual a 0, se ejecuta el bloque de código a
                     * continuación.
                     */
                    case 0:
                        /*
                         * Llama al método inputZapatoCasual() que se encarga de manejar la opción de
                         * "Insertar" un zapato casual.
                         */
                        inputZapatoCasual();
                        /* Rompe la ejecución del switch y continúa con el código después del switch. */
                        break;

                    case 1:
                        /*
                         * Llama al método eraseZapatoCasual() que se encarga de manejar la opción de
                         * "Borrar" un zapato casual.
                         */
                        eraseZapatoCasual();
                        break;

                    case 2:
                        findZapatoCasual();
                        break;

                    case 3:
                        printZapatoCasual();
                        break;

                    case 4:
                        editZapatoCasual();
                        break;

                    case 5:
                        /* Llama al método zapato() de la clase ZapatoMethod. */
                        ZapatoMethod.zapato();
                        /* Sale del método actual y no ejecuta más código. */
                        return;

                }

                /*
                 * Se inicia un bloque catch para capturar cualquier excepción que pueda ocurrir
                 * dentro del switch.
                 */
            } catch (Exception e) {
                /*
                 * Muestra un mensaje de error en un cuadro de diálogo en caso de que se
                 * produzca una excepción.
                 */
                JOptionPane.showMessageDialog(null,
                        "Ups! Error!",
                        "Zapato Casual Menu",
                        JOptionPane.ERROR_MESSAGE);
            }

            /*
             * Se realiza un bucle do-while que continuará ejecutando el código dentro del
             * bucle mientras selectZapato sea diferente de 5.
             * 
             * En el caso 5 que es igual a "Regresar" el do-while termina y abre al metodo
             * zapato() de la clase ZapatoMethod
             */
        } while (selectZapato != 5);
    }

    // Se define un método público y estático llamado inputZapatoCasual que no
    // devuelve ningún valor (void).
    public static void inputZapatoCasual() {

        // Se inicia un bloque try para manejar excepciones dentro del método
        // inputZapatoCasual.
        try {

            // Se declara la variable count de tipo entero para almacenar la cantidad de
            // zapatos casuales que el usuario desea ingresar.
            int count;

            // Se inicia un bucle while que se ejecutará indefinidamente hasta que se rompa
            // explícitamente con break.
            while (true) {

                try {

                    // Muestra un cuadro de diálogo de entrada para que el usuario ingrese la
                    // cantidad de zapatos casuales que desea ingresar.
                    String input = JOptionPane.showInputDialog(null,
                            "¿Cuántos zapatos casuales desea ingresar? ",
                            "01");

                    // Verifica si el usuario ha presionado "Cancelar" en el cuadro de diálogo de
                    // entrada.
                    if (input == null) {
                        // Muestra un mensaje de advertencia si el usuario ha cancelado la operación.
                        JOptionPane.showMessageDialog(null, "Ingreso Cancelado", "Ingresar Zapato Casual",
                                JOptionPane.WARNING_MESSAGE);
                        // Sale del método inputZapatoCasual si el usuario ha cancelado la operación.
                        return;
                    }

                    // Convierte la entrada del usuario a un entero y lo asigna a la variable count.
                    count = Integer.valueOf(input);
                    // Rompe el bucle while una vez que se ha obtenido un valor válido para count.
                    break;

                    /*
                     * Se inicia un bloque catch que captura la excepción NumberFormatException, la
                     * cual se produce cuando se intenta convertir una cadena a un número, pero la
                     * cadena no tiene el formato numérico correcto.
                     */
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            /*
             * Se inicia un bucle for que se ejecutará count veces. Este bucle se encarga de
             * solicitar información sobre cada zapato casual que el usuario desea ingresar.
             */
            for (int i = 0; i < count; i++) {

                // (almacen + 1): Incrementa el valor de almacen en 1 para mostrar el número del
                // zapato casual actual.
                String nombre = JOptionPane.showInputDialog(null,
                        "Ingrese el nombre del Zapato Casual " + (almacen + 1) + ":",
                        "NOMBRE");
                // Verifica si el usuario ha presionado "Cancelar" en el cuadro de diálogo de
                // entrada y lanza una excepción NullPointerException si es así.
                if (nombre == null) {
                    throw new NullPointerException();
                }

                double precio;
                while (true) {
                    try {
                        precio = Double.valueOf(JOptionPane.showInputDialog(null,
                                "Ingrese el precio del Zapato Casual " + (almacen + 1) + ":",
                                "00"));
                        break;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Ingrese un número", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                String color = JOptionPane.showInputDialog(null,
                        "Ingrese el color del Zapato Casual " + (almacen + 1) + ":",
                        "COLOR");
                if (color == null) {
                    throw new NullPointerException();
                }

                String marca = JOptionPane.showInputDialog(null,
                        "Ingrese la marca del Zapato Casual " + (almacen + 1) + ":",
                        "MARCA");
                if (marca == null) {
                    throw new NullPointerException();
                }

                double talla;
                while (true) {
                    try {
                        talla = Double.valueOf(JOptionPane.showInputDialog(null,
                                "Ingrese la talla del Zapato Casual " + (almacen + 1) + ":",
                                "00"));
                        break;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Ingrese un número", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                String material = JOptionPane.showInputDialog(null,
                        "Ingrese el material del Zapato Casual " + (almacen + 1) + ":",
                        "MATERIAL");
                if (material == null) {
                    throw new NullPointerException();
                }

                String categoria = JOptionPane.showInputDialog(null,
                        "Ingrese la categoría del Zapato Casual " + (almacen + 1) + ":",
                        "CATEGORÍA");
                if (categoria == null) {
                    throw new NullPointerException();
                }

                Casual nuevoCasual = new Casual(nombre,
                        precio, color, marca, talla, material, categoria);

                casualArray.add(nuevoCasual);

                JOptionPane.showMessageDialog(null,
                        "Zapato Casual " + (almacen + 1) + " :\n" +
                                nuevoCasual.toString(),
                        "Confirmación de datos", JOptionPane.INFORMATION_MESSAGE);

                almacen++;
            }
            // catch of the first try, if a general error is found in the method it will
            // release the warning
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingreso Cancelado",
                    "Ingresar Zapato Casual", JOptionPane.WARNING_MESSAGE);
        }

    }

    public static void eraseZapatoCasual() {

        try {

            int codeToErase;

            while (true) {
                try {
                    String input = JOptionPane.showInputDialog(null,
                            "Ingrese el codigo del Zapato Casual a eliminar",
                            "000");

                    if (input == null) {
                        JOptionPane.showMessageDialog(null, "Eliminacion Cancelada", "Eliminar Zapato Casual",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    codeToErase = Integer.valueOf(input);
                    break;

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            Casual zapatoErase = new Casual(codeToErase);

            for (int i = 0; i < casualArray.size(); i++) {

                Casual currentProduct = casualArray.get(i);

                if (currentProduct != null && currentProduct.equals(zapatoErase)) {

                    int confirmacion = JOptionPane.showConfirmDialog(
                            null,
                            "¿Estás seguro de que deseas eliminar el siguiente Zapato Casual?\n" +
                                    currentProduct.toString(),
                            "Confirmar Eliminación",
                            JOptionPane.YES_NO_OPTION);

                    if (confirmacion == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(
                                null, "Eliminacion cancelada",
                                "Eliminacion Cancelada",
                                JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    JOptionPane.showMessageDialog(
                            null,
                            "Zapato Casual eliminado: \n " +
                                    currentProduct.toString(),
                            "Eliminacion Existosa",
                            JOptionPane.INFORMATION_MESSAGE);

                    casualArray.remove(i);

                    almacen--;

                    printZapatoCasual();

                    return;

                }
            }

            JOptionPane.showMessageDialog(
                    null,
                    "Zapato Casual " + codeToErase + " no ha sido encontrado.",
                    "Búsqueda Fallida",
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eliminar Cancelado",
                    "Eliminar Zapato Casual", JOptionPane.WARNING_MESSAGE);
        }

    }

    public static void findZapatoCasual() {

        try {
            int codigoFind;
            while(true){
                try{
                    String input = JOptionPane.showInputDialog(
                        "Ingrese el código del Producto",
                        "000");

                    if(input == null){
                        JOptionPane.showMessageDialog(null, "Busqueda Cancelada", "Buscar Zapato Casual",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    codigoFind = Integer.valueOf(input);
                    break;
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Ingrese un número",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            Casual zapatoFind = new Casual(codigoFind);

            for (Casual casual : casualArray) {
                if (casual != null && casual.equals(zapatoFind)) {
                    JOptionPane.showMessageDialog(null,
                            "Zapato encontrado: \n" + casual.toString(),
                            "Búsqueda Exitosa", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }

            JOptionPane.showMessageDialog(null,
                    "El zapato Casual con código " + codigoFind + " no ha sido encontrado.",
                    "Búsqueda Fallida", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Busqueda Cancelada",
                    "Buscar Zapato Casual", JOptionPane.WARNING_MESSAGE);
        }

    }

    public static void printZapatoCasual() {

        try {
            StringBuilder sb = new StringBuilder();

            sb.append("Lista de Zapatos Casuales:\n");

            for (Casual casual : casualArray) {
                if (casual != null) {
                    sb.append(casual.toString()).append("\n");
                }
            }

            JOptionPane.showMessageDialog(null,
                    sb.toString(),
                    "Zapatos Casuales", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lista Cancelada",
                    "Lista Zapato Casual", JOptionPane.WARNING_MESSAGE);
        }

    }

    public static void editZapatoCasual() {

        try {

            Integer codeToEdit;
            while(true){
                try{
                    String input = JOptionPane.showInputDialog(
                        "Ingrese el codigo del Zapato Casual que va a cambiar",
                        "000");

                    if(input == null){
                        JOptionPane.showMessageDialog(null, "Edicion Cancelada", "Editar Zapato Casual",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    codeToEdit = Integer.valueOf(input);
                    break;
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Ingrese un número",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            Casual zapatoFind = new Casual(codeToEdit);

            for (int i = 0; i < casualArray.size(); i++ /* Casual zapato : casualArray */) {

                Casual currentProduct = casualArray.get(i);

                if (currentProduct != null && currentProduct.equals(zapatoFind)) {

                    int confirmacion = JOptionPane.showConfirmDialog(
                            null,
                            "¿Estás seguro de que deseas editar el siguiente Zapato Casual?\n" +
                                    currentProduct.toString(),
                            "Confirmar Edición",
                            JOptionPane.YES_NO_OPTION);

                    if (confirmacion == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(
                                null, "Edicion cancelada",
                                "Editar Cancelada",
                                JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    if (confirmacion == JOptionPane.YES_OPTION) {

                        String nombre = JOptionPane.showInputDialog(null,
                                "Ingrese el nombre del Zapato Casual " + (i + 1) + ":",
                                "NOMBRE");

                        double precio = Double.valueOf(JOptionPane.showInputDialog(null,
                                "Ingrese el precio del Zapato Casual " + (i + 1) + ":",
                                "00"));

                        String color = JOptionPane.showInputDialog(null,
                                "Ingrese el color del Zapato Casual " + (i + 1) + ":",
                                "COLOR");

                        String marca = JOptionPane.showInputDialog(null,
                                "Ingrese la marca del Zapato Casual " + (i + 1) + ":",
                                "MARCA");

                        double talla = Double.valueOf(JOptionPane.showInputDialog(null,
                                "Ingrese la talla del Zapato Casual " + (i + 1) + ":",
                                "00"));

                        String material = JOptionPane.showInputDialog(null,
                                "Ingrese el material del Zapato Casual " + (i + 1) + ":",
                                "MATERIAL");

                        String categoria = JOptionPane.showInputDialog(null,
                                "Ingrese la categoría del Zapato Casual " + (i + 1) + ":",
                                "CATEGORÍA");

                        currentProduct.setNombre(nombre);
                        currentProduct.setPrecio(precio);
                        currentProduct.setColor(color);
                        currentProduct.setMarca(marca);
                        currentProduct.setTalla(talla);
                        currentProduct.setMaterial(material);
                        currentProduct.setCategoria(categoria);

                        JOptionPane.showMessageDialog(null,
                                "Zapato Casual actualizado: \n" +
                                        currentProduct.toString(),
                                "Actualizacion Exitosa",
                                JOptionPane.INFORMATION_MESSAGE);

                        printZapatoCasual();

                        return;
                    }

                }
            }

            JOptionPane.showMessageDialog(null,
                    "El Zapato Casual " +
                            codeToEdit + " no ha sido encontrada.",
                    "Búsqueda Fallida",
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Edicion Cancelada",
                    "Editar Zapato Casual", JOptionPane.WARNING_MESSAGE);
        }

    }

}
