package main.Metodos;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import main.Clases.Producto;

public class ProductoMethod {

    protected ArrayList<? extends Producto> productoArray = new ArrayList<>();

    public void eraseProducto(int codeToErase, int almacen, String producto, Object obj) {
        
        try {
            for (int i = 0; i < productoArray.size(); i++) {
                Producto currentProduct = productoArray.get(i);

                if (currentProduct != null && currentProduct.getCodigo() == codeToErase) {
                    int confirmacion = JOptionPane.showConfirmDialog(
                            null,
                            "¿Estás seguro de que deseas eliminar el siguiente Producto?\n" +
                                    currentProduct.toString(),
                            producto + ".   Confirmar Eliminación. ",
                            JOptionPane.YES_NO_OPTION);

                    if (confirmacion == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(
                                null, "Eliminacion cancelada",
                                producto + ".   Eliminacion Cancelada. ",
                                JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    JOptionPane.showMessageDialog(
                            null,
                            "Producto eliminado: \n " +
                                    currentProduct.toString(),
                            producto + ".    Eliminacion Existosa." ,
                            JOptionPane.INFORMATION_MESSAGE);

                    productoArray.remove(i);

                    almacen--;

                    printProducto();

                    return;
                }
            }

            JOptionPane.showMessageDialog(
                    null,
                    "Producto con código " + codeToErase + " no ha sido encontrado.",
                    producto + ".   Búsqueda Fallida",
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eliminar Cancelado",
                    producto + ".   Eliminar Producto", JOptionPane.WARNING_MESSAGE);
        }
    }

    protected void printProducto() {

    }
}
