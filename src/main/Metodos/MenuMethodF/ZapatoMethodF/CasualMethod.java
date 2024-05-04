package main.Metodos.MenuMethodF.ZapatoMethodF;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import main.Clases.Products.ZapatoF.Casual;
import main.Metodos.MenuMethodF.ZapatoMethod;

public class CasualMethod {

    static int selectZapato = 0;

    static ArrayList<Casual> casualArray = new ArrayList<>();

    static int almacen = 0;

    public static void zapatoCasual() {
        do {
            // Try catch para evitar que el programa termine si hay un error
            try {
                Object[] options = { "Insertar", "Borrar", "Buscar", "Imprimir", "Editar", "Regresar" };

                selectZapato = JOptionPane.showOptionDialog(null,
                        "Seleccione una opción:",
                        "Zapato Tenis Menu",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        options,
                        options[0]);

                switch (selectZapato) {
                    case 0:
                        inputZapatoCasual();
                        break;

                    case 1:
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
                        ZapatoMethod.zapato();
                        return;

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Ups! Error!",
                        "Zapato Casual Menu",
                        JOptionPane.WARNING_MESSAGE);
            }

        } while (selectZapato != 5);
    }

    public static void inputZapatoCasual() {

        try {
            int count = Integer.valueOf(JOptionPane.showInputDialog(
                    "¿Cuántos zapatos casuales desea ingresar?",
                    "01"));

            for (int i = 0; i < count; i++) {

                String nombre = JOptionPane.showInputDialog(null,
                        "Ingrese el nombre del Zapato Casual " + (almacen + 1) + ":",
                        "NOMBRE");
                if (nombre == null) {
                    throw new NullPointerException();
                }

                double precio = Double.valueOf(JOptionPane.showInputDialog(null,
                        "Ingrese el precio del Zapato Casual " + (almacen + 1) + ":",
                        "00"));

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

                double talla = Double.valueOf(JOptionPane.showInputDialog(null,
                        "Ingrese la talla del Zapato Casual " + (almacen + 1) + ":",
                        "00"));

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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingreso Cancelado",
                    "Ingresar Zapato Casual", JOptionPane.WARNING_MESSAGE);
        }

    }

    public static void eraseZapatoCasual() {

        try {
            int codeToErase = Integer.valueOf(
                    JOptionPane.showInputDialog(
                            "Ingrese el codigo del Zapato Casual a eliminar"));

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
            int codigoFind = Integer.valueOf(JOptionPane.showInputDialog(
                    "Ingrese el código del Producto",
                    "000"));
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
            Integer codeToEdit = Integer.valueOf(
                    JOptionPane.showInputDialog(
                            "Ingrese el codigo del Zapato Casual que va a cambiar"));

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
