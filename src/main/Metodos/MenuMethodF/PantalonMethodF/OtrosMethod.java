package main.Metodos.MenuMethodF.PantalonMethodF;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import main.Clases.Products.PantalonF.Otros;
import main.Metodos.MenuMethodF.PantalonMethod;

public class OtrosMethod {

    static int selectPantalon = 0;

    static ArrayList<Otros> otrosArray = new ArrayList<>();

    static int almacen = 0;

    public static void pantalonOtros() {
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
                        inputPantalonOtros();
                        break;

                    case 1:
                        erasePantalonOtros();
                        break;

                    case 2:
                        findPantalonOtros();
                        break;

                    case 3:
                        printPantalonOtros();
                        break;

                    case 4:
                        editPantalonOtros();
                        break;

                    case 5:
                        PantalonMethod.pantalon();
                        return;

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Ups! Error!",
                        "Pantalon Otros Menu",
                        JOptionPane.WARNING_MESSAGE);
            }
        } while (selectPantalon != 5);
    }

    public static void inputPantalonOtros() {

        try {
            int count = Integer.valueOf(JOptionPane.showInputDialog(
                    "Cuantos pantalones otros desea ingresar?",
                    "01"));

            for (int i = 0; i < count; i++) {

                String nombre = JOptionPane.showInputDialog(null,
                        "Ingrese el nombre del Pantalon Otros " + (almacen + 1) + ":",
                        "NOMBRE");

                double precio = Double.valueOf(JOptionPane.showInputDialog(null,
                        "Ingrese el precio del Pantalon Otros " + (almacen + 1) + ":",
                        "00"));

                String color = JOptionPane.showInputDialog(null,
                        "Ingrese el color del Pantalon Otros " + (almacen + 1) + ":",
                        "COLOR");

                String marca = JOptionPane.showInputDialog(null,
                        "Ingrese la marca del Pantalon Otros " + (almacen + 1) + ":",
                        "MARCA");

                int talla = Integer.valueOf(JOptionPane.showInputDialog(null,
                        "Ingrese la talla del Pantalon Otros " + (almacen + 1) + ":",
                        "00"));

                String tela = JOptionPane.showInputDialog(null,
                        "Ingrese el material del Pantalon Otros " + (almacen + 1) + ":",
                        "MATERIAL");

                String estilo = JOptionPane.showInputDialog(null,
                        "Ingrese la categoria del Pantalon Otros " + (almacen + 1) + ":",
                        "ESTILO");

                Otros nuevoOtros = new Otros(nombre,
                        precio, color, marca, talla, tela, estilo);

                otrosArray.add(nuevoOtros);

                JOptionPane.showMessageDialog(null,
                        "Pantalon Otros " + (almacen + 1) + " : \n" +
                                nuevoOtros.toString(),
                        "Confirmacion de datos", JOptionPane.INFORMATION_MESSAGE);

                almacen++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingreso Cancelado",
                    "Ingresar Pantalon Otros", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void erasePantalonOtros() {

        try {
            int codeToErase = Integer.valueOf(
                    JOptionPane.showInputDialog(
                            "Ingrese el codigo del Pantalon Otros a eliminar"));

            Otros otrosErase = new Otros(codeToErase);

            for (int i = 0; i < otrosArray.size(); i++) {

                Otros currentProduct = otrosArray.get(i);

                if (currentProduct != null && currentProduct.equals(otrosErase)) {

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
                            "Pantalon Otros eliminado: \n " +
                                    currentProduct.toString(),
                            "Eliminacion Existosa",
                            JOptionPane.INFORMATION_MESSAGE);

                    otrosArray.remove(i);

                    almacen--;

                    printPantalonOtros();

                    return;
                }

            }

            JOptionPane.showMessageDialog(
                    null,
                    "Pantalón Otros " + codeToErase + " no ha sido encontrado.",
                    "Búsqueda Fallida",
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eliminar Cancelado",
                    "Eliminar Pantalon Otros", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void findPantalonOtros() {

        try {
            int codigoFind = Integer.valueOf(JOptionPane.showInputDialog(
                    "Ingrese el código del Producto",
                    "000"));
            Otros otrosFind = new Otros(codigoFind);

            for (Otros otros : otrosArray) {
                if (otros != null && otros.equals(otrosFind)) {
                    JOptionPane.showMessageDialog(null,
                            "Pantalon encontrado: \n" + otros.toString(),
                            "Búsqueda Exitosa", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }

            JOptionPane.showMessageDialog(null,
                    "El pantalon Otros con código " + codigoFind + " no ha sido encontrado.",
                    "Búsqueda Fallida", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Busqueda Cancelada",
                    "Buscar Pantalon Otros", JOptionPane.WARNING_MESSAGE);
        }

    }

    public static void printPantalonOtros() {

        try {
            StringBuilder sb = new StringBuilder();

            sb.append("Lista de Pantalos Otros:\n");

            for (Otros otros : otrosArray) {
                if (otros != null) {
                    sb.append(otros.toString()).append("\n");
                }
            }

            JOptionPane.showMessageDialog(null, sb.toString(),
                    "Pantalos Otros", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lista Cancelada",
                    "Lista Pantalon Otros", JOptionPane.WARNING_MESSAGE);
        }

    }

    public static void editPantalonOtros() {

        try {
            Integer codeToEdit = Integer.valueOf(
                    JOptionPane.showInputDialog(
                            "Ingrese el codigo del Pantalon Otros que va a cambiar"));

            Otros otrosFind = new Otros(codeToEdit);

            for (int i = 0; i < otrosArray.size(); i++) {

                Otros currentProduct = otrosArray.get(i);

                if (currentProduct != null && currentProduct.equals(otrosFind)) {

                    int confirmacion = JOptionPane.showConfirmDialog(
                            null,
                            "¿Estás seguro de que deseas editar el siguiente Pantalón Otros?\n" +
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
                                "Ingrese el nombre del Pantalón Otros " + (i + 1) + ":",
                                "NOMBRE");

                        double precio = Double.valueOf(JOptionPane.showInputDialog(null,
                                "Ingrese el precio del Pantalón Otros " + (i + 1) + ":",
                                "PRECIO"));

                        String color = JOptionPane.showInputDialog(null,
                                "Ingrese el color del Pantalón Otros " + (i + 1) + ":",
                                "COLOR");

                        String marca = JOptionPane.showInputDialog(null,
                                "Ingrese la marca del Pantalón Otros " + (i + 1) + ":",
                                "MARCA");

                        int talla = Integer.valueOf(JOptionPane.showInputDialog(null,
                                "Ingrese la talla del Pantalón Otros " + (i + 1) + ":",
                                "TALLA"));

                        String tela = JOptionPane.showInputDialog(null,
                                "Ingrese el material del Pantalón Otros " + (i + 1) + ":",
                                "TELA");

                        String estilo = JOptionPane.showInputDialog(null,
                                "Ingrese la categoría del Pantalón Otros " + (i + 1) + ":",
                                "ESTILO");

                        Otros newProduct = new Otros(nombre,
                                precio, color, marca, talla, tela, estilo);

                        currentProduct.setNombre(nombre);
                        currentProduct.setPrecio(precio);
                        currentProduct.setColor(color);
                        currentProduct.setMarca(marca);
                        currentProduct.setTalla(talla);
                        currentProduct.setTela(tela);
                        currentProduct.setEstilo(estilo);

                        JOptionPane.showMessageDialog(
                                null,
                                "Pantalón Otros actualizado: \n" + newProduct.toString(),
                                "Actualización exitosa",
                                JOptionPane.INFORMATION_MESSAGE);

                        printPantalonOtros();

                        return;
                    }
                }
            }

            JOptionPane.showMessageDialog(
                    null,
                    "Pantalon Otros " +
                            codeToEdit + " no ha sido encontrado.",
                    "Busqueda Fallida",
                    JOptionPane.WARNING_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Edicion Cancelada",
                    "Editar Pantalon Otros", JOptionPane.WARNING_MESSAGE);
        }
    }

}
