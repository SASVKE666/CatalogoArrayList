package main.Metodos.MenuMethodF.PantalonMethodF;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import main.Clases.Products.PantalonF.Jeans;
import main.Metodos.MenuMethodF.PantalonMethod;

public class JeansMethod {

    static int selectPantalon = 0;

    static ArrayList<Jeans> jeansArray = new ArrayList<>();

    static int almacen = 0;

    public static void pantalonJeans() {
        do {
            // Try catch para evitar que el programa termine si hay un error
            try {
                Object[] options = { "Insertar", "Borrar", "Buscar", "Imprimir", "Editar", "Regresar" };

                selectPantalon = JOptionPane.showOptionDialog(null,
                        "Seleccione una opción:",
                        "Zapato Tenis Menu",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        options,
                        options[0]);

                switch (selectPantalon) {
                    case 0:
                        inputPantalonJeans();
                        break;

                    case 1:
                        erasePantalonJeans();
                        break;

                    case 2:
                        findPantalonJeans();
                        break;

                    case 3:
                        printPantalonJeans();
                        break;

                    case 4:
                        editPantalonJeans();
                        break;

                    case 5:
                        PantalonMethod.pantalon();
                        return;

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Ups! Error!",
                        "Pantalon Jeans Menu",
                        JOptionPane.WARNING_MESSAGE);
            }
        } while (selectPantalon != 5);
    }

    public static void inputPantalonJeans() {

        try {
            int count = Integer.valueOf(JOptionPane.showInputDialog(
                    "Cuantos pantalones jeans desea ingresar?",
                    "01"));

            for (int i = 0; i < count; i++) {

                String nombre = JOptionPane.showInputDialog(null,
                        "Ingrese el nombre del Pantalon Jean " + (almacen + 1) + ":",
                        "NOMBRE");

                double precio = Double.valueOf(JOptionPane.showInputDialog(null,
                        "Ingrese el precio del Pantalon Jean " + (almacen + 1) + ":",
                        "00"));

                String color = JOptionPane.showInputDialog(null,
                        "Ingrese el color del Pantalon Jean " + (almacen + 1) + ":",
                        "COLOR");

                String marca = JOptionPane.showInputDialog(null,
                        "Ingrese la marca del Pantalon Jean " + (almacen + 1) + ":",
                        "MARCA");

                int talla = Integer.valueOf(JOptionPane.showInputDialog(null,
                        "Ingrese la talla del Pantalon Jean " + (almacen + 1) + ":",
                        "00"));

                String tela = JOptionPane.showInputDialog(null,
                        "Ingrese el material del Pantalon Jean " + (almacen + 1) + ":",
                        "MATERIAL");

                String corte = JOptionPane.showInputDialog(null,
                        "Ingrese la categoria del Pantalon Jean " + (almacen + 1) + ":",
                        "CORTE");

                Jeans nuevoJeans = new Jeans(nombre,
                        precio, color, marca, talla, tela, corte);

                jeansArray.add(nuevoJeans);

                JOptionPane.showMessageDialog(null,
                        "Pantalon Jeans " + (almacen + 1) + " :\n" +
                                nuevoJeans.toString(),
                        "Confirmacion de datos", JOptionPane.INFORMATION_MESSAGE);

                almacen++;

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingreso Cancelado",
                    "Ingresar Pantalon Jeans", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void erasePantalonJeans() {

        try {
            int codeToErase = Integer.valueOf(
                    JOptionPane.showInputDialog(
                            "Ingrese el codigo del Pantalon Jeans a eliminar"));

            Jeans jeansErase = new Jeans(codeToErase);

            for (int i = 0; i < jeansArray.size(); i++) {

                Jeans currentProduct = jeansArray.get(i);

                if (currentProduct != null && currentProduct.equals(jeansErase)) {

                    int confirmacion = JOptionPane.showConfirmDialog(
                            null,
                            "¿Estás seguro de que deseas eliminar el siguiente Pantalón Otros?\n" +
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
                            "Pantalon Jeans eliminado: \n " +
                                    currentProduct.toString(),
                            "Eliminacion Existosa",
                            JOptionPane.INFORMATION_MESSAGE);

                    jeansArray.remove(i);

                    almacen--;

                    return;
                }
            }

            JOptionPane.showMessageDialog(
                    null,
                    "Pantalón Jeans " + codeToErase + " no ha sido encontrado.",
                    "Búsqueda Fallida",
                    JOptionPane.WARNING_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eliminar Cancelado",
                    "Eliminar Pantalon Jeans ", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void findPantalonJeans() {

        try {
            int codigoFind = Integer.valueOf(JOptionPane.showInputDialog(
                    "Ingrese el código del Producto",
                    "000"));
            Jeans jeansFind = new Jeans(codigoFind);

            for (Jeans jeans : jeansArray) {
                if (jeans != null && jeans.equals(jeansFind)) {
                    JOptionPane.showMessageDialog(null,
                            "Pantalon encontrado: \n" + jeans.toString(),
                            "Búsqueda Exitosa", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }

            JOptionPane.showMessageDialog(null,
                    "El pantalon Jeans con código " + codigoFind + " no ha sido encontrado.",
                    "Búsqueda Fallida", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Busqueda Cancelada",
                    "Buscar Pantalon Jeans", JOptionPane.WARNING_MESSAGE);
        }

    }

    public static void printPantalonJeans() {

        try {
            StringBuilder sb = new StringBuilder();

            sb.append("Lista de Pantalones Jeans:\n");

            for (Jeans jeans : jeansArray) {
                if (jeans != null) {
                    sb.append(jeans.toString()).append("\n");
                }
            }

            JOptionPane.showMessageDialog(null, sb.toString(),
                    "Pantalones Jeans", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lista Cancelada",
                    "Lista Pantalon Jeans", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void editPantalonJeans() {

        try {
            Integer codeToEdit = Integer.valueOf(
                    JOptionPane.showInputDialog(
                            "Ingrese el codigo del Pantalon Jeans que va a cambiar"));

            Jeans jeansFind = new Jeans(codeToEdit);

            for (int i = 0; i < jeansArray.size(); i++) {

                Jeans currentProduct = jeansArray.get(i);

                if (currentProduct != null && currentProduct.equals(jeansFind)) {

                    int confirmacion = JOptionPane.showConfirmDialog(
                            null,
                            "¿Estás seguro de que deseas editar el siguiente Pantalón Jeans?\n" +
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
                                "Ingrese el nombre del Pantalon Jeans " + (i + 1) + ":",
                                "NOMBRE");

                        double precio = Double.valueOf(JOptionPane.showInputDialog(null,
                                "Ingrese el precio del Pantalon Jeans " + (i + 1) + ":",
                                "00"));

                        String color = JOptionPane.showInputDialog(null,
                                "Ingrese el color del Pantalon Jeans " + (i + 1) + ":",
                                "COLOR");

                        String marca = JOptionPane.showInputDialog(null,
                                "Ingrese la marca del Pantalon Jeans " + (i + 1) + ":",
                                "MARCA");

                        int talla = Integer.valueOf(JOptionPane.showInputDialog(null,
                                "Ingrese la talla del Pantalon Jeans " + (i + 1) + ":",
                                "00"));

                        String tela = JOptionPane.showInputDialog(null,
                                "Ingrese el material del Pantalon Jeans " + (i + 1) + ":",
                                "MATERIAL");

                        String corte = JOptionPane.showInputDialog(null,
                                "Ingrese la categoria del Pantalon Jeans " + (i + 1) + ":",
                                "CORTE");

                        currentProduct.setNombre(nombre);
                        currentProduct.setPrecio(precio);
                        currentProduct.setColor(color);
                        currentProduct.setMarca(marca);
                        currentProduct.setTalla(talla);
                        currentProduct.setTela(tela);
                        ;
                        currentProduct.setCorte(corte);

                        JOptionPane.showMessageDialog(
                                null,
                                "Pantalon Jeans actualizado: \n" +
                                        currentProduct.toString(),
                                "Actualizacion exitosa",
                                JOptionPane.INFORMATION_MESSAGE);

                        printPantalonJeans();
                        return;
                    }

                }
            }

            JOptionPane.showMessageDialog(
                    null,
                    "Pantalon Jeans " +
                            codeToEdit + " no ha sido encontrado.",
                    "Busqueda Fallida",
                    JOptionPane.WARNING_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Edicion Cancelada",
                    "Editar Pantalon Jeans", JOptionPane.WARNING_MESSAGE);
        }
    }

}
