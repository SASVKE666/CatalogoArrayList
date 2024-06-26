package main.Metodos.MenuMethodF.PantalonMethodF;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import main.Clases.Products.PantalonF.Otros;
import main.Metodos.MenuMethodF.PantalonMethod;

public class OtrosMethod {

        static int selectPantalon = 0;

        static ArrayList<Otros> otrosArray = new ArrayList<>();

        static int almacen = 0;

        static File infoPantalonOtros = new File("src\\InfoProductos\\infoPantalonOtros.txt");
        static FileWriter escribir;
        static PrintWriter imprimir;

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

        public static void writeToFileOtros() {

                try (FileOutputStream fileOut = new FileOutputStream(infoPantalonOtros);
                                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

                        // Serializar objetos Gorra en el archivo
                        for (Otros otros : otrosArray) {
                                if (otros != null) {
                                        objectOut.writeObject(otros);
                                }
                        }

                } catch (IOException e) {
                        System.out.println(e);
                }

        }

        public static void readerFileOtros() {

                int contadorArray = 0;
                try (FileInputStream fileIn = new FileInputStream(infoPantalonOtros);
                                ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

                        try {

                                while (true) {
                                        Otros otros = (Otros) objectIn.readObject();
                                        @SuppressWarnings("unused")
                                        Otros contador = new Otros();
                                        otrosArray.add(otros);

                                        contadorArray++;
                                }
                        } catch (EOFException e) {
                                // Fin del archivo, salir del bucle
                        } catch (ClassNotFoundException | IOException e) {
                                System.out.println("Error al leer los objetos: " + e.getMessage());
                        }

                } catch (IOException e) {
                        System.out.println("Error al abrir el archivo: " + e.getMessage());
                }
                almacen = contadorArray++;
        }

        public static void inputPantalonOtros() {

                try {
                        int count;

                        while (true) {

                                try {

                                        String input = JOptionPane.showInputDialog(null,
                                                        "¿Cuántos pantalones otros desea ingresar? ",
                                                        "01");

                                        if (input == null) {

                                                JOptionPane.showMessageDialog(null, "Ingreso Cancelado",
                                                                "Ingresar Zapato Casual",
                                                                JOptionPane.WARNING_MESSAGE);
                                                return;
                                        }

                                        count = Integer.valueOf(input);

                                        if (count <= 0) {
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
                                                "Ingrese el nombre del Pantalon Otros " + (almacen + 1) + ":",
                                                "NOMBRE");
                                if (nombre == null) {
                                        throw new NullPointerException();
                                }
                                double precio;
                                while (true) {
                                        try {
                                                precio = Double.valueOf(JOptionPane.showInputDialog(null,
                                                                "Ingrese el precio del Pantalon Otros " + (almacen + 1)
                                                                                + ":",
                                                                "00"));
                                                break;
                                        } catch (NumberFormatException e) {
                                                JOptionPane.showMessageDialog(null, "Ingrese un número", "Error",
                                                                JOptionPane.ERROR_MESSAGE);
                                        }
                                }

                                String color = JOptionPane.showInputDialog(null,
                                                "Ingrese el color del Pantalon Otros " + (almacen + 1) + ":",
                                                "COLOR");
                                if (color == null) {
                                        throw new NullPointerException();
                                }
                                String marca = JOptionPane.showInputDialog(null,
                                                "Ingrese la marca del Pantalon Otros " + (almacen + 1) + ":",
                                                "MARCA");
                                if (marca == null) {
                                        throw new NullPointerException();
                                }
                                int talla;
                                while (true) {
                                        try {
                                                talla = Integer.valueOf(JOptionPane.showInputDialog(null,
                                                                "Ingrese la talla del Pantalon Otros " + (almacen + 1)
                                                                                + ":",
                                                                "00"));
                                                break;
                                        } catch (NumberFormatException e) {
                                                JOptionPane.showMessageDialog(null, "Ingrese un número", "Error",
                                                                JOptionPane.ERROR_MESSAGE);
                                        }
                                }

                                String tela = JOptionPane.showInputDialog(null,
                                                "Ingrese la tela del Pantalon Otros " + (almacen + 1) + ":",
                                                "TELA");
                                if (tela == null) {
                                        throw new NullPointerException();
                                }
                                String estilo = JOptionPane.showInputDialog(null,
                                                "Ingrese el estilo del Pantalon Otros " + (almacen + 1) + ":",
                                                "ESTILO");
                                if (estilo == null) {
                                        throw new NullPointerException();
                                }
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
                        int codeToErase;
                        while (true) {
                                try {
                                        String input = JOptionPane.showInputDialog(null,
                                                        "Ingrese el codigo del Pantalon Otros a eliminar",
                                                        "000");

                                        if (input == null) {
                                                JOptionPane.showMessageDialog(null, "Eliminacion Cancelada",
                                                                "Eliminar Pantalon Otros",
                                                                JOptionPane.WARNING_MESSAGE);
                                                return;
                                        }

                                        codeToErase = Integer.valueOf(input);
                                        if (codeToErase <= 0) {
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
                        Otros otrosErase = new Otros(codeToErase);

                        for (int i = 0; i < otrosArray.size(); i++) {

                                Otros currentProduct = otrosArray.get(i);

                                if (currentProduct != null && currentProduct.equals(otrosErase)) {

                                        int confirmacion = JOptionPane.showConfirmDialog(
                                                        null,
                                                        "¿Estás seguro de que deseas eliminar el siguiente Pantalón Otros?\n"
                                                                        +
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
                                        if (codigoFind <= 0) {
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
                        Integer codeToEdit;
                        while (true) {
                                try {
                                        String input = JOptionPane.showInputDialog(
                                                        "Ingrese el codigo del Pantalon Otros que va a cambiar",
                                                        "000");

                                        if (input == null) {
                                                JOptionPane.showMessageDialog(null, "Edicion Cancelada",
                                                                "Editar Pantalon Otros",
                                                                JOptionPane.WARNING_MESSAGE);
                                                return;
                                        }
                                        codeToEdit = Integer.valueOf(input);

                                        if (codeToEdit <= 0) {
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
                        Otros otrosFind = new Otros(codeToEdit);

                        for (int i = 0; i < otrosArray.size(); i++) {

                                Otros currentProduct = otrosArray.get(i);

                                if (currentProduct != null && currentProduct.equals(otrosFind)) {

                                        int confirmacion = JOptionPane.showConfirmDialog(
                                                        null,
                                                        "¿Estás seguro de que deseas editar el siguiente Pantalón Otros?\n"
                                                                        +
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
                                                                "Ingrese el nombre del Pantalon Otros " + (almacen + 1)
                                                                                + ":",
                                                                "NOMBRE");
                                                if (nombre == null) {
                                                        throw new NullPointerException();
                                                }
                                                double precio;
                                                while (true) {
                                                        try {
                                                                precio = Double.valueOf(JOptionPane.showInputDialog(
                                                                                null,
                                                                                "Ingrese el precio del Pantalon Otros "
                                                                                                + (almacen + 1)
                                                                                                + ":",
                                                                                "00"));
                                                                break;
                                                        } catch (NumberFormatException e) {
                                                                JOptionPane.showMessageDialog(null, "Ingrese un número",
                                                                                "Error",
                                                                                JOptionPane.ERROR_MESSAGE);
                                                        }
                                                }

                                                String color = JOptionPane.showInputDialog(null,
                                                                "Ingrese el color del Pantalon Otros " + (almacen + 1)
                                                                                + ":",
                                                                "COLOR");
                                                if (color == null) {
                                                        throw new NullPointerException();
                                                }
                                                String marca = JOptionPane.showInputDialog(null,
                                                                "Ingrese la marca del Pantalon Otros " + (almacen + 1)
                                                                                + ":",
                                                                "MARCA");
                                                if (marca == null) {
                                                        throw new NullPointerException();
                                                }
                                                int talla;
                                                while (true) {
                                                        try {
                                                                talla = Integer.valueOf(JOptionPane.showInputDialog(
                                                                                null,
                                                                                "Ingrese la talla del Pantalon Otros "
                                                                                                + (almacen + 1)
                                                                                                + ":",
                                                                                "00"));
                                                                break;
                                                        } catch (NumberFormatException e) {
                                                                JOptionPane.showMessageDialog(null, "Ingrese un número",
                                                                                "Error",
                                                                                JOptionPane.ERROR_MESSAGE);
                                                        }
                                                }

                                                String tela = JOptionPane.showInputDialog(null,
                                                                "Ingrese la tela del Pantalon Otros "
                                                                                + (almacen + 1) + ":",
                                                                "TELA");
                                                if (tela == null) {
                                                        throw new NullPointerException();
                                                }
                                                String estilo = JOptionPane.showInputDialog(null,
                                                                "Ingrese el estilo del Pantalon Otros "
                                                                                + (almacen + 1) + ":",
                                                                "ESTILO");
                                                if (estilo == null) {
                                                        throw new NullPointerException();
                                                }

                                                currentProduct.setNombre(nombre);
                                                currentProduct.setPrecio(precio);
                                                currentProduct.setColor(color);
                                                currentProduct.setMarca(marca);
                                                currentProduct.setTalla(talla);
                                                currentProduct.setTela(tela);
                                                currentProduct.setEstilo(estilo);

                                                JOptionPane.showMessageDialog(
                                                                null,
                                                                "Pantalón Otros actualizado: \n"
                                                                                + currentProduct.toString(),
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
