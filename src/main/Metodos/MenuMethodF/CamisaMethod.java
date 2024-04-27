package main.Metodos.MenuMethodF;

import javax.swing.JOptionPane;

import main.Metodos.MenuMethod;
import main.Metodos.MenuMethodF.CamisaMethodF.ElMethod;
import main.Metodos.MenuMethodF.CamisaMethodF.EllaMethod;

public class CamisaMethod {

    public static int selectCamisa = 0;

    public static void camisa(){
        
        do{
            //Try catch para evitar que el programa termine si hay un error
            try{
                Object[] options = {"El", "Ella", "Regresar"};

                selectCamisa = JOptionPane.showOptionDialog(null,
                "Seleccione una opción:",
                "Menú",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);   

                switch(selectCamisa){
                    case 0:
                    ElMethod.camisaEl();
                    break;

                    case 1:
                    EllaMethod.camisaElla();
                    break;

                    case 2:
                    MenuMethod.menu();
                    return;
                        
                }

            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Ups! Error!");
            }
        }while(selectCamisa != 2);
    }

}
