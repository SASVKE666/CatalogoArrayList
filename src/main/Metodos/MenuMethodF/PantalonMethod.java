package main.Metodos.MenuMethodF;

import javax.swing.JOptionPane;

import main.Metodos.MenuMethod;
import main.Metodos.MenuMethodF.PantalonMethodF.JeansMethod;
import main.Metodos.MenuMethodF.PantalonMethodF.OtrosMethod;

public class PantalonMethod {

    public static int selectPantalon = 0;

    public static void pantalon(){
        do{
            //Try catch para evitar que el programa termine si hay un error
            try{
                Object[] options = {"Jeans", "Otros", "Regresar"};

                selectPantalon = JOptionPane.showOptionDialog(null,
                "Seleccione una opción:",
                "Pantalon Menú",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

                switch(selectPantalon){
                    case 0:
                    JeansMethod.pantalonJeans();
                    break;
    
                    case 1:
                    OtrosMethod.pantalonOtros();
                    break;
    
                    case 2:
                    MenuMethod.menu();
                    return;

                }

            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Ups! Error!");
            }
        
        }while(selectPantalon != 2);
    }

}
