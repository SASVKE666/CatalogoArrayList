package main.Metodos.MenuMethodF.CamisaMethodF;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import main.Clases.Products.CamisaF.Ella;
import main.Metodos.MenuMethodF.CamisaMethod;

public class EllaMethod {

        static ArrayList<Ella> ellaArray = new ArrayList<>();

        static int selectCamisa = 0;

        static int almacen = 0;

        static File infoCamisaElla;
        static FileWriter escribir;
        static PrintWriter imprimir;

        public static void camisaElla() {
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
                                                inputCamisaElla();
                                                break;

                                        case 1:
                                                eraseCamisaElla();
                                                break;

                                        case 2:
                                                findCamisaElla();
                                                break;

                                        case 3:
                                                printCamisaElla();
                                                break;

                                        case 4:
                                                editCamisaElla();
                                                break;

                                        case 5:
                                                CamisaMethod.camisa();
                                                return;

                                }

                        } catch (Exception e) {
                                JOptionPane.showMessageDialog(null,
                                                "Ups! Error!",
                                                "Camisa Ella Menu", JOptionPane.WARNING_MESSAGE);
                        }
                } while (selectCamisa != 5);
        }

        public static void inputCamisaElla() {

                try {
                        int count;

                        while (true) {
                                try {

                                        String input = JOptionPane.showInputDialog(
                                                        "Cuantas camisas para ella desea ingresar?",
                                                        "01");

                                        if (input == null) {
                                                JOptionPane.showMessageDialog(null, "Ingreso Cancelado",
                                                                "Ingresar Camisa Ella",
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
                                                "Ingrese el nombre de la Camisa para Ella " + (almacen + 1) + ":",
                                                "NOMBRE");
                                if (nombre == null) {
                                        throw new NullPointerException();
                                }
                                double precio;
                                while (true) {
                                        try {
                                                precio = Double.valueOf(JOptionPane.showInputDialog(null,
                                                                "Ingrese el precio de la Camisa para Ella "
                                                                                + (almacen + 1) + ":",
                                                                "00"));
                                                break;
                                        } catch (NumberFormatException e) {
                                                JOptionPane.showMessageDialog(null, "Ingrese un número", "Error",
                                                                JOptionPane.ERROR_MESSAGE);
                                        }
                                }

                                String color = JOptionPane.showInputDialog(null,
                                                "Ingrese el color de la Camisa para Ella " + (almacen + 1) + ":",
                                                "COLOR");
                                if (color == null) {
                                        throw new NullPointerException();
                                }
                                String marca = JOptionPane.showInputDialog(null,
                                                "Ingrese la marca de la Camisa para Ella " + (almacen + 1) + ":",
                                                "MARCA");
                                if (marca == null) {
                                        throw new NullPointerException();
                                }
                                String talla = JOptionPane.showInputDialog(null,
                                                "Ingrese la talla de la Camisa para Ella " + (almacen + 1) + ":",
                                                "TALLA");
                                if (talla == null) {
                                        throw new NullPointerException();
                                }
                                String tela = JOptionPane.showInputDialog(null,
                                                "Ingrese el material de la Camisa para Ella " + (almacen + 1) + ":",
                                                "MATERIAL");
                                if (tela == null) {
                                        throw new NullPointerException();
                                }
                                String estilo = JOptionPane.showInputDialog(null,
                                                "Ingrese la categoria de la Camisa para Ella " + (almacen + 1) + ":",
                                                "ESTILO");
                                if (estilo == null) {
                                        throw new NullPointerException();
                                }
                                Ella nuevoElla = new Ella(nombre,
                                                precio, color, marca, talla, tela, estilo);

                                ellaArray.add(nuevoElla);

                                JOptionPane.showMessageDialog(null,
                                                "Camisa Ella " + (almacen + 1) + " :\n" +
                                                                nuevoElla.toString(),
                                                "Confirmacion de datos", JOptionPane.INFORMATION_MESSAGE);

                                almacen++;

                        }

                        infoCamisaElla = new File("src\\InfoProductos\\infoCamisaElla.txt");

                        if(infoCamisaElla.exists()) {
                                infoCamisaElla.delete(); 
                        }

                        if (!infoCamisaElla.exists()) {
                                infoCamisaElla.createNewFile();
                        }

                        escribir = new FileWriter(infoCamisaElla, true);

                        imprimir = new PrintWriter(escribir);

                        for (Ella ella : ellaArray) {
                                imprimir.println(ella.getNombre());
                                imprimir.println(ella.getPrecio());
                                imprimir.println(ella.getColor());
                                imprimir.println(ella.getMarca());
                                imprimir.println(ella.getTalla());
                                imprimir.println(ella.getTela());
                                imprimir.println(ella.getEstilo());
                        }

                        imprimir.close();
                        escribir.close();
                        
                        
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Ingreso Cancelado",
                                        "Ingresar Camisa Ella", JOptionPane.WARNING_MESSAGE);
                }
        }

        public static void eraseCamisaElla() {

                try {
                        int codeToErase;
                        while (true) {
                                try {
                                        String input = JOptionPane.showInputDialog(null,
                                                        "Ingrese el codigo de la Camisa Ella a eliminar",
                                                        "000");

                                        if (input == null) {
                                                JOptionPane.showMessageDialog(null, "Eliminacion Cancelada",
                                                                "Eliminar Camisa Ella",
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
                        Ella ellaErase = new Ella(codeToErase);

                        for (int i = 0; i < ellaArray.size(); i++) {

                                Ella currentProduct = ellaArray.get(i);

                                if (currentProduct != null && currentProduct.equals(ellaErase)) {

                                        int confirmacion = JOptionPane.showConfirmDialog(
                                                        null,
                                                        "¿Estás seguro de que deseas eliminar la siguiente Camisa Ella?\n"
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
                                                        "Camisa Ella eliminado: \n " +
                                                                        currentProduct.toString(),
                                                        "Eliminacion Existosa",
                                                        JOptionPane.INFORMATION_MESSAGE);

                                        ellaArray.remove(i);

                                        almacen--;

                                        printCamisaElla();

                                        return;
                                }
                        }

                        JOptionPane.showMessageDialog(
                                        null,
                                        "Camisa Ella " + codeToErase + " no ha sido encontrado.",
                                        "Búsqueda Fallida",
                                        JOptionPane.WARNING_MESSAGE);

                } catch (Exception e) {

                        JOptionPane.showMessageDialog(null, "Eliminacion Cancelado",
                                        "Eliminar Camisa Ella", JOptionPane.WARNING_MESSAGE);
                }
        }

        public static void findCamisaElla() {

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
                        Ella ellaFind = new Ella(codigoFind);

                        for (Ella ella : ellaArray) {
                                if (ella != null && ella.equals(ellaFind)) {
                                        JOptionPane.showMessageDialog(null,
                                                        "Camisa encontrada: \n" + ella.toString(),
                                                        "Búsqueda Exitosa", JOptionPane.INFORMATION_MESSAGE);
                                        return;
                                }
                        }

                        JOptionPane.showMessageDialog(null,
                                        "La camisa para Ella con código " + codigoFind + " no ha sido encontrado.",
                                        "Búsqueda Fallida", JOptionPane.WARNING_MESSAGE);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Busqueda Cancelada",
                                        "Buscar Camisa Ella", JOptionPane.WARNING_MESSAGE);
                }

        }

        public static void printCamisaElla() {

                try {
                        StringBuilder sb = new StringBuilder();

                        sb.append("Lista de Camisas para Ella:\n");

                        for (Ella ella : ellaArray) {
                                if (ella != null) {
                                        sb.append(ella.toString()).append("\n");
                                }
                        }

                        JOptionPane.showMessageDialog(null,
                                        sb.toString(), "Camisas Ella", 1);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Lista Cancelada",
                                        "Lista Camisa Ella", JOptionPane.WARNING_MESSAGE);
                }

        }

        public static void editCamisaElla() {

                try {
                        Integer codeToEdit;
                        while (true) {
                                try {
                                        String input = JOptionPane.showInputDialog(
                                                        "Ingrese el codigo de la Camisa Ella que va a cambiar",
                                                        "000");

                                        if (input == null) {
                                                JOptionPane.showMessageDialog(null, "Edicion Cancelada",
                                                                "Editar Camisa Ella",
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
                        Ella ellaFind = new Ella(codeToEdit);

                        for (int i = 0; i < ellaArray.size(); i++) {

                                Ella currentProduct = ellaArray.get(i);

                                if (currentProduct != null && currentProduct.equals(ellaFind)) {

                                        int confirmacion = JOptionPane.showConfirmDialog(
                                                        null,
                                                        "¿Estás seguro de que deseas editar la siguiente Camisa Ella?\n"
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
                                                                "Ingrese el nombre de la Camisa para Ella "
                                                                                + (almacen + 1) + ":",
                                                                "NOMBRE");
                                                if (nombre == null) {
                                                        throw new NullPointerException();
                                                }
                                                double precio;
                                                while (true) {
                                                        try {
                                                                precio = Double.valueOf(JOptionPane.showInputDialog(
                                                                                null,
                                                                                "Ingrese el precio de la Camisa para Ella "
                                                                                                + (almacen + 1) + ":",
                                                                                "00"));
                                                                break;
                                                        } catch (NumberFormatException e) {
                                                                JOptionPane.showMessageDialog(null, "Ingrese un número",
                                                                                "Error",
                                                                                JOptionPane.ERROR_MESSAGE);
                                                        }
                                                }

                                                String color = JOptionPane.showInputDialog(null,
                                                                "Ingrese el color de la Camisa para Ella "
                                                                                + (almacen + 1) + ":",
                                                                "COLOR");
                                                if (color == null) {
                                                        throw new NullPointerException();
                                                }
                                                String marca = JOptionPane.showInputDialog(null,
                                                                "Ingrese la marca de la Camisa para Ella "
                                                                                + (almacen + 1) + ":",
                                                                "MARCA");
                                                if (marca == null) {
                                                        throw new NullPointerException();
                                                }
                                                String talla = JOptionPane.showInputDialog(null,
                                                                "Ingrese la talla de la Camisa para Ella "
                                                                                + (almacen + 1) + ":",
                                                                "TALLA");
                                                if (talla == null) {
                                                        throw new NullPointerException();
                                                }
                                                String tela = JOptionPane.showInputDialog(null,
                                                                "Ingrese el material de la Camisa para Ella "
                                                                                + (almacen + 1) + ":",
                                                                "MATERIAL");
                                                if (tela == null) {
                                                        throw new NullPointerException();
                                                }
                                                String estilo = JOptionPane.showInputDialog(null,
                                                                "Ingrese la categoria de la Camisa para Ella "
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
                                                ;
                                                currentProduct.setEstilo(estilo);
                                                ;

                                                JOptionPane.showMessageDialog(
                                                                null,
                                                                "Camisa Ella actualizada: \n" +
                                                                                currentProduct.toString(),
                                                                "Actualizacion exitosa",
                                                                JOptionPane.INFORMATION_MESSAGE);

                                                printCamisaElla();

                                                return;
                                        }

                                }
                        }

                        JOptionPane.showMessageDialog(
                                        null,
                                        "Camisa Ella " +
                                                        codeToEdit + " no ha sido encontrado.",
                                        "Busqueda Fallida",
                                        JOptionPane.WARNING_MESSAGE);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Edicion Cancelada",
                                        "Editar Camisa Ella", JOptionPane.WARNING_MESSAGE);
                }

        }

}
