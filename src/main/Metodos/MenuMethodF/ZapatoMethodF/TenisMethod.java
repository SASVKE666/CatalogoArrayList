package main.Metodos.MenuMethodF.ZapatoMethodF;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import main.Clases.Products.ZapatoF.Tenis;
import main.Metodos.MenuMethodF.ZapatoMethod;

public class TenisMethod {

        static int selectZapato = 0;

        static int almacen = 0;

        static File infoZapatoTenis;
        static FileWriter escribir;
        static PrintWriter imprimir;

        static ArrayList<Tenis> tenisArray = new ArrayList<>();

        public static void zapatoTenis() {
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
                                                inputZapatoTenis();
                                                break;

                                        case 1:
                                                eraseZapatotenis();
                                                break;

                                        case 2:
                                                findZapatoTenis();
                                                break;

                                        case 3:
                                                printZapatoTenis();
                                                break;

                                        case 4:
                                                editZapatoTenis();
                                                break;

                                        case 5:
                                                ZapatoMethod.zapato();
                                                return;

                                }

                        } catch (Exception e) {
                                JOptionPane.showMessageDialog(null,
                                                "Ups! Error!",
                                                "Zapato Tenis Menu", JOptionPane.WARNING_MESSAGE);
                        }
                } while (selectZapato != 5);
        }

        public static void writeToFileTenis() {
                try {
                        infoZapatoTenis = new File("src\\InfoProductos\\infoZapatoTenis.txt");

                        if (infoZapatoTenis.exists()){
                                infoZapatoTenis.delete();
                        }
                        
                        if (!infoZapatoTenis.exists()) {
                                infoZapatoTenis.createNewFile();
                        }

                        escribir = new FileWriter(infoZapatoTenis, true);

                        imprimir = new PrintWriter(escribir);

                        for (Tenis tenis : tenisArray) {
                                imprimir.println(tenis.getNombre());
                                imprimir.println(tenis.getPrecio());
                                imprimir.println(tenis.getColor());
                                imprimir.println(tenis.getMarca());
                                imprimir.println(tenis.getTalla());
                                imprimir.println(tenis.getMaterial());
                                imprimir.println(tenis.getDeporte());
                        }

                        imprimir.close();
                        escribir.close();

                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al escribir en el archivo",
                                        "Error", JOptionPane.ERROR_MESSAGE);
                }
        }

        public static void inputZapatoTenis() {

                try {
                        int count;

                        while (true) {
                                try {
                                        String input = JOptionPane.showInputDialog(
                                                        "¿Cuántos zapatos Tenis desea ingresar?",
                                                        "01");

                                        if (input == null) {
                                                JOptionPane.showMessageDialog(
                                                                null,
                                                                "Ingreso Cancelado",
                                                                "Ingresar Zapato Tenis",
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
                                        JOptionPane.showMessageDialog(null, "Ingrese un número", "Error",
                                                        JOptionPane.ERROR_MESSAGE);

                                }
                        }

                        for (int i = 0; i < count; i++) {

                                String nombre = JOptionPane.showInputDialog(null,
                                                "Ingrese el nombre del Zapato Tenis " + (almacen + 1) + ":",
                                                "NOMBRE");

                                if (nombre == null) {
                                        throw new NullPointerException();
                                }

                                double precio;
                                while (true) {
                                        try {
                                                precio = Double.valueOf(JOptionPane.showInputDialog(null,
                                                                "Ingrese el precio del Zapato Tenis " + (almacen + 1)
                                                                                + ":",
                                                                "00"));
                                                break;
                                        } catch (NumberFormatException e) {
                                                JOptionPane.showMessageDialog(null, "Ingrese un número", "Error",
                                                                JOptionPane.ERROR_MESSAGE);
                                        }
                                }

                                String color = JOptionPane.showInputDialog(null,
                                                "Ingrese el color del Zapato Tenis " + (almacen + 1) + ":",
                                                "COLOR");
                                if (color == null) {
                                        throw new NullPointerException();
                                }

                                String marca = JOptionPane.showInputDialog(null,
                                                "Ingrese la marca del Zapato Tenis " + (almacen + 1) + ":",
                                                "MARCA");
                                if (marca == null) {
                                        throw new NullPointerException();
                                }

                                double talla;
                                while (true) {
                                        try {
                                                talla = Double.valueOf(JOptionPane.showInputDialog(null,
                                                                "Ingrese la talla del Zapato Tenis " + (almacen + 1)
                                                                                + ":",
                                                                "00"));
                                                break;
                                        } catch (NumberFormatException e) {
                                                JOptionPane.showMessageDialog(null, "Ingrese un número", "Error",
                                                                JOptionPane.ERROR_MESSAGE);
                                        }
                                }

                                String material = JOptionPane.showInputDialog(null,
                                                "Ingrese el material del Zapato Tenis " + (almacen + 1) + ":",
                                                "MATERIAL");
                                if (material == null) {
                                        throw new NullPointerException();
                                }

                                String deporte = JOptionPane.showInputDialog(null,
                                                "Ingrese el deporte del Zapato Tenis " + (almacen + 1) + ":",
                                                "DEPORTE");
                                if (deporte == null) {
                                        throw new NullPointerException();
                                }

                                Tenis nuevoTenis = new Tenis(nombre,
                                                precio, color, marca, talla, material, deporte);

                                tenisArray.add(nuevoTenis);

                                JOptionPane.showMessageDialog(null,
                                                "Zapato Tenis " + (almacen + 1) + " :\n" +
                                                                nuevoTenis.toString(),
                                                "Confirmación de datos", JOptionPane.INFORMATION_MESSAGE);

                                almacen++;
                        }

                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Ingreso Cancelado",
                                        "Ingresar Zapato Tenis", JOptionPane.WARNING_MESSAGE);
                }
        }

        public static void eraseZapatotenis() {

                try {
                        int codeToErase;

                        while (true) {
                                try {
                                        String input = JOptionPane.showInputDialog(null,
                                                        "Ingrese el codigo del Zapato Tenis a eliminar",
                                                        "000");

                                        if (input == null) {
                                                JOptionPane.showMessageDialog(null, "Eliminacion Cancelada",
                                                                "Eliminar Zapato Casual",
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
                        Tenis tenisErase = new Tenis(codeToErase);

                        for (int i = 0; i < tenisArray.size(); i++) {

                                Tenis currentProduct = tenisArray.get(i);

                                if (currentProduct != null && currentProduct.equals(tenisErase)) {

                                        int confirmacion = JOptionPane.showConfirmDialog(
                                                        null,
                                                        "¿Estás seguro de que deseas eliminar el siguiente Zapato?\n" +
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
                                                        "Zapato Tenis eliminado: \n " +
                                                                        currentProduct.toString(),
                                                        "Eliminacion Existosa",
                                                        JOptionPane.INFORMATION_MESSAGE);

                                        tenisArray.remove(i);

                                        almacen--;

                                        printZapatoTenis();

                                        return;
                                }
                        }

                        JOptionPane.showMessageDialog(
                                        null,
                                        "Zapato Tenis " + codeToErase + " no ha sido encontrado.",
                                        "Búsqueda Fallida",
                                        JOptionPane.WARNING_MESSAGE);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Eliminar Cancelado",
                                        "Eliminar Zapato Tenis", JOptionPane.WARNING_MESSAGE);
                }

        }

        public static void findZapatoTenis() {

                try {
                        int codigoFind;
                        while (true) {
                                try {
                                        String input = JOptionPane.showInputDialog(
                                                        "Ingrese el código del Producto",
                                                        "000");

                                        if (input == null) {
                                                JOptionPane.showMessageDialog(null, "Busqueda Cancelada",
                                                                "Buscar Zapato Casual",
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
                        Tenis tenisFind = new Tenis(codigoFind);

                        for (Tenis tenis : tenisArray) {
                                if (tenis != null && tenis.equals(tenisFind)) {
                                        JOptionPane.showMessageDialog(null,
                                                        "Zapato encontrado: \n" + tenis.toString(),
                                                        "Búsqueda Exitosa", JOptionPane.INFORMATION_MESSAGE);
                                        return;
                                }
                        }

                        JOptionPane.showMessageDialog(null,
                                        "El zapato Tenis con código " + codigoFind + " no ha sido encontrado.",
                                        "Búsqueda Fallida", JOptionPane.WARNING_MESSAGE);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Busqueda Cancelada",
                                        "Encontrar Zapato Tenis", JOptionPane.WARNING_MESSAGE);
                }

        }

        public static void printZapatoTenis() {

                try {
                        StringBuilder sb = new StringBuilder();

                        sb.append("Lista de Zapatos Tenis:\n");

                        for (Tenis tenis : tenisArray) {
                                if (tenis != null) {
                                        sb.append(tenis.toString()).append("\n");
                                }
                        }

                        JOptionPane.showMessageDialog(null,
                                        sb.toString(), "Zapatos Tenis", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Lista Cancelada",
                                        "Lista Zapato Tenis", JOptionPane.WARNING_MESSAGE);
                }
        }

        public static void editZapatoTenis() {

                try {
                        Integer codeToEdit;
                        while (true) {
                                try {
                                        String input = JOptionPane.showInputDialog(
                                                        "Ingrese el codigo del Zapato Teni que va a cambiar",
                                                        "000");

                                        if (input == null) {
                                                JOptionPane.showMessageDialog(null, "Edicion Cancelada",
                                                                "Editar Zapato Casual",
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

                        Tenis tenisFind = new Tenis(codeToEdit);

                        for (int i = 0; i < tenisArray.size(); i++) {

                                Tenis currentProduct = tenisArray.get(i);

                                if (currentProduct != null && currentProduct.equals(tenisFind)) {

                                        int confirmacion = JOptionPane.showConfirmDialog(
                                                        null,
                                                        "¿Estás seguro de que deseas editar el siguiente Zapato Tenis?\n"
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
                                                                "Ingrese el nombre del Zapato Tenis " + (almacen + 1)
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
                                                                                "Ingrese el precio del Zapato Tenis "
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
                                                                "Ingrese el color del Zapato Tenis " + (almacen + 1)
                                                                                + ":",
                                                                "COLOR");
                                                if (color == null) {
                                                        throw new NullPointerException();
                                                }

                                                String marca = JOptionPane.showInputDialog(null,
                                                                "Ingrese la marca del Zapato Tenis " + (almacen + 1)
                                                                                + ":",
                                                                "MARCA");
                                                if (marca == null) {
                                                        throw new NullPointerException();
                                                }

                                                double talla;
                                                while (true) {
                                                        try {
                                                                talla = Double.valueOf(JOptionPane.showInputDialog(null,
                                                                                "Ingrese la talla del Zapato Tenis "
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

                                                String material = JOptionPane.showInputDialog(null,
                                                                "Ingrese el material del Zapato Tenis " + (almacen + 1)
                                                                                + ":",
                                                                "MATERIAL");
                                                if (material == null) {
                                                        throw new NullPointerException();
                                                }

                                                String deporte = JOptionPane.showInputDialog(null,
                                                                "Ingrese el deporte del Zapato Tenis " + (almacen + 1)
                                                                                + ":",
                                                                "DEPORTE");
                                                if (deporte == null) {
                                                        throw new NullPointerException();
                                                }

                                                currentProduct.setNombre(nombre);
                                                currentProduct.setPrecio(precio);
                                                currentProduct.setColor(color);
                                                currentProduct.setMarca(marca);
                                                currentProduct.setTalla(talla);
                                                currentProduct.setMaterial(material);
                                                currentProduct.setDeporte(deporte);
                                                ;

                                                JOptionPane.showMessageDialog(
                                                                null,
                                                                "Zapato Tenis actualizado: \n" +
                                                                                currentProduct.toString(),
                                                                "Actualizacion Exitosa",
                                                                JOptionPane.INFORMATION_MESSAGE);

                                                printZapatoTenis();

                                                return;

                                        }
                                }
                        }

                        JOptionPane.showMessageDialog(
                                        null,
                                        "El Zapato Tenis " +
                                                        codeToEdit + " no ha sido encontrada.",
                                        "Búsqueda Fallida",
                                        JOptionPane.WARNING_MESSAGE);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Edicion Cancelada",
                                        "Editar Zapato Tenis", JOptionPane.WARNING_MESSAGE);

                }

        }

}
