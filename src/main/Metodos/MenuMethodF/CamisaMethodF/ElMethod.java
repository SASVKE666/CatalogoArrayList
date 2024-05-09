package main.Metodos.MenuMethodF.CamisaMethodF;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import main.Clases.Products.CamisaF.El;
import main.Metodos.MenuMethodF.CamisaMethod;

public class ElMethod {

    static ArrayList<El> elArray = new ArrayList<>();

    static int selectCamisa = 0;

    static int almacen = 0;

    public static void camisaEl() {
        do {
            // Try catch para evitar que el programa termine si hay un error
            try {
                Object[] options = { "Insertar", "Borrar", "Buscar", "Imprimir", "Editar", "Regresar" };

                selectCamisa = JOptionPane.showOptionDialog(null,
                        "Seleccione una opción:",
                        "Zapato Tenis Menu",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        options,
                        options[0]);

                switch (selectCamisa) {
                    case 0:
                        inputCamisaEl();
                        break;

                    case 1:
                        eraseCamisaEl();
                        break;

                    case 2:
                        findCamisaEl();
                        break;

                    case 3:
                        printCamisaEl();
                        break;

                    case 4:
                        editCamisaEl();
                        break;

                    case 5:
                        CamisaMethod.camisa();
                        return;

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Ups! Error!",
                        "Camisa El Menu", JOptionPane.WARNING_MESSAGE);
            }
        } while (selectCamisa != 5);
    }

    public static void inputCamisaEl() {

        try {
            int count;

            while (true) {
                try {

                    String input = JOptionPane.showInputDialog(
                            "Cuantas camisas para El desea ingresar?",
                            "01");

                    if (input == null) {
                        JOptionPane.showMessageDialog(null, "Ingreso Cancelado",
                                "Ingresar Camisa El",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    count = Integer.valueOf(input);

                    if (count < 0) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Debe ingresar obligatoriamente un número entero.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);

                    } else {
                        // Rompe el bucle while una vez que se ha obtenido un valor válido para
                        // count.
                        break;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Debe ingresar obligatoriamente un número entero.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

            for (int i = 0; i < count; i++) {

                String nombre = JOptionPane.showInputDialog(null,
                        "Ingrese el nombre de la Camisa para El " + (almacen + 1) + ":",
                        "NOMBRE");
                if (nombre == null) {
                    throw new NullPointerException();
                }
                double precio;
                while (true) {
                    try {
                        precio = Double.valueOf(JOptionPane.showInputDialog(null,
                                "Ingrese el precio de la Camisa para El "
                                        + (almacen + 1) + ":",
                                "00"));
                        break;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Ingrese un número", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }

                String color = JOptionPane.showInputDialog(null,
                        "Ingrese el color de la Camisa para El " + (almacen + 1) + ":",
                        "COLOR");
                if (color == null) {
                    throw new NullPointerException();
                }
                String marca = JOptionPane.showInputDialog(null,
                        "Ingrese la marca de la Camisa para El " + (almacen + 1) + ":",
                        "MARCA");
                if (marca == null) {
                    throw new NullPointerException();
                }
                String talla = JOptionPane.showInputDialog(null,
                        "Ingrese la talla de la Camisa para El " + (almacen + 1) + ":",
                        "TALLA");
                if (talla == null) {
                    throw new NullPointerException();
                }
                String tela = JOptionPane.showInputDialog(null,
                        "Ingrese el material de la Camisa para El " + (almacen + 1) + ":",
                        "MATERIAL");
                if (tela == null) {
                    throw new NullPointerException();
                }
                String tipo = JOptionPane.showInputDialog(null,
                        "Ingrese la categoria de la Camisa para El " + (almacen + 1) + ":",
                        "TIPO");
                if (tipo == null) {
                    throw new NullPointerException();
                }

                El nuevoEl = new El(nombre,
                        precio, color, marca, talla, tela, tipo);

                elArray.add(nuevoEl);

                JOptionPane.showMessageDialog(null,
                        "Camisa El " + (almacen + 1) + " :\n" +
                                nuevoEl.toString(),
                        "Confirmacion de datos", JOptionPane.INFORMATION_MESSAGE);

                almacen++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingreso Cancelado",
                    "Ingresar Camisa El", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void eraseCamisaEl() {

        try {
            int codeToErase;
            while (true) {
                try {
                    String input = JOptionPane.showInputDialog(null,
                            "Ingrese el codigo de la Camisa El a eliminar",
                            "000");

                    if (input == null) {
                        JOptionPane.showMessageDialog(null, "Eliminacion Cancelada",
                                "Eliminar Camisa El",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    codeToErase = Integer.valueOf(input);
                    if (codeToErase < 0) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Debe ingresar obligatoriamente un número entero.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);

                    } else {
                        // Rompe el bucle while una vez que se ha obtenido un valor válido para
                        // count.
                        break;
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            El elErase = new El(codeToErase);

            for (int i = 0; i < elArray.size(); i++) {

                El currentProduct = elArray.get(i);

                if (currentProduct != null && currentProduct.equals(elErase)) {

                    int confirmacion = JOptionPane.showConfirmDialog(
                            null,
                            "¿Estás seguro de que deseas eliminar la siguiente Camisa El?\n" +
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
                            "Camisa El eliminado: \n " +
                                    currentProduct.toString(),
                            "Eliminacion Existosa",
                            JOptionPane.INFORMATION_MESSAGE);

                    elArray.remove(i);

                    almacen--;

                    printCamisaEl();

                    return;
                }
            }

            JOptionPane.showMessageDialog(
                    null,
                    "Camisa El " + codeToErase + " no ha sido encontrado.",
                    "Búsqueda Fallida",
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eliminar Cancelado",
                    "Eliminar Camisa El", JOptionPane.WARNING_MESSAGE);
        }

    }

    public static void findCamisaEl() {

        try {
            int codigoFind;

            while (true) {
                try {
                    String input = JOptionPane.showInputDialog(
                            "Ingrese el código del Producto",
                            "000");

                    if (input == null) {
                        JOptionPane.showMessageDialog(null, "Busqueda Cancelada",
                                "Buscar Producto",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    codigoFind = Integer.valueOf(input);
                    if (codigoFind < 0) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Debe ingresar obligatoriamente un número entero.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);

                    } else {
                        // Rompe el bucle while una vez que se ha obtenido un valor válido para
                        // count.
                        break;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            El elFind = new El(codigoFind);

            for (El tenis : elArray) {
                if (tenis != null && tenis.equals(elFind)) {
                    JOptionPane.showMessageDialog(null,
                            "Camisa encontrada: \n" + tenis.toString(),
                            "Búsqueda Exitosa", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }

            JOptionPane.showMessageDialog(null,
                    "La Camisa para El con código " + codigoFind + " no ha sido encontrado.",
                    "Búsqueda Fallida", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Busqueda Cancelada",
                    "Buscar Camisa El", JOptionPane.WARNING_MESSAGE);
        }

    }

    public static void printCamisaEl() {

        try {
            StringBuilder sb = new StringBuilder();

            sb.append("Lista de Cammisas para El:\n");

            for (El el : elArray) {
                if (el != null) {
                    sb.append(el.toString()).append("\n");
                }
            }

            JOptionPane.showMessageDialog(null, sb.toString(),
                    "Camisas El", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lista Cancelada",
                    "Lista Camisa El", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void editCamisaEl() {

        try {
            Integer codeToEdit;
            while (true) {
                try {
                    String input = JOptionPane.showInputDialog(
                            "Ingrese el codigo de la Camisa El que va a cambiar",
                            "000");

                    if (input == null) {
                        JOptionPane.showMessageDialog(null, "Edicion Cancelada",
                                "Editar Camisa El",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    codeToEdit = Integer.valueOf(input);

                    if (codeToEdit < 0) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Debe ingresar obligatoriamente un número entero.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);

                    } else {
                        // Rompe el bucle while una vez que se ha obtenido un valor válido para
                        // count.
                        break;
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            El ellaFind = new El(codeToEdit);

            for (int i = 0; i < elArray.size(); i++) {

                El currentProduct = elArray.get(i);

                if (currentProduct != null && currentProduct.equals(ellaFind)) {

                    int confirmacion = JOptionPane.showConfirmDialog(
                            null,
                            "¿Estás seguro de que deseas editar la siguiente Camisa El?\n" +
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
                                "Ingrese el nombre de la Camisa para El " + (almacen + 1) + ":",
                                "NOMBRE");
                        if (nombre == null) {
                            throw new NullPointerException();
                        }
                        double precio;
                        while (true) {
                            try {
                                precio = Double.valueOf(JOptionPane.showInputDialog(null,
                                        "Ingrese el precio de la Camisa para El "
                                                + (almacen + 1) + ":",
                                        "00"));
                                break;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Ingrese un número", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        }

                        String color = JOptionPane.showInputDialog(null,
                                "Ingrese el color de la Camisa para El " + (almacen + 1) + ":",
                                "COLOR");
                        if (color == null) {
                            throw new NullPointerException();
                        }
                        String marca = JOptionPane.showInputDialog(null,
                                "Ingrese la marca de la Camisa para El " + (almacen + 1) + ":",
                                "MARCA");
                        if (marca == null) {
                            throw new NullPointerException();
                        }
                        String talla = JOptionPane.showInputDialog(null,
                                "Ingrese la talla de la Camisa para El " + (almacen + 1) + ":",
                                "TALLA");
                        if (talla == null) {
                            throw new NullPointerException();
                        }
                        String tela = JOptionPane.showInputDialog(null,
                                "Ingrese el material de la Camisa para El " + (almacen + 1) + ":",
                                "MATERIAL");
                        if (tela == null) {
                            throw new NullPointerException();
                        }
                        String tipo = JOptionPane.showInputDialog(null,
                                "Ingrese la categoria de la Camisa para El " + (almacen + 1) + ":",
                                "TIPO");
                        if (tipo == null) {
                            throw new NullPointerException();
                        }

                        currentProduct.setNombre(nombre);
                        currentProduct.setPrecio(precio);
                        currentProduct.setColor(color);
                        currentProduct.setMarca(marca);
                        currentProduct.setTalla(talla);
                        currentProduct.setTela(tela);
                        currentProduct.setTipo(tipo);

                        JOptionPane.showMessageDialog(
                                null,
                                "Camisa El actualizada: \n" +
                                        currentProduct.toString(),
                                "Actualizacion exitosa",
                                JOptionPane.INFORMATION_MESSAGE);

                        printCamisaEl();

                        return;
                    }

                }
            }

            JOptionPane.showMessageDialog(
                    null,
                    "Camisa El " +
                            codeToEdit + " no ha sido encontrado.",
                    "Busqueda Fallida",
                    JOptionPane.WARNING_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Edicion Cancelada",
                    "Editar Camisa El", JOptionPane.WARNING_MESSAGE);
        }

    }
}
