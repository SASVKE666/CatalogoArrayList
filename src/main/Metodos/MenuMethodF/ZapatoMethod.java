package main.Metodos.MenuMethodF;

import javax.swing.JOptionPane;

import main.Metodos.MenuMethod;
import main.Metodos.MenuMethodF.ZapatoMethodF.CasualMethod;
import main.Metodos.MenuMethodF.ZapatoMethodF.TenisMethod;

public class ZapatoMethod{
    
    public static int selectZapato = 0;

    public static void zapato(){

        do{
            //Try catch para evitar que el programa termine si hay un error
            try{

                Object[] options = {"Casual", "Tenis", "Regresar"};

                selectZapato = JOptionPane.showOptionDialog(null,
                "Seleccione una opción:",
                "Zapato Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);   

                switch(selectZapato){
                    case 0:
                    CasualMethod.zapatoCasual();
                    break;
                        
                    case 1:
                    TenisMethod.zapatoTenis();
                    break;

                    case 2:
                    MenuMethod.menu();
                    return;
                }

            }catch(Exception e){
                JOptionPane.showMessageDialog(null,
                "Ups! Error!", 
                "ZAPATO", JOptionPane.WARNING_MESSAGE);
            }
        }while(selectZapato != 2);
    }

}
