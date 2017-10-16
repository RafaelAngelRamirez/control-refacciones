/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.UtilidadesIntefaz;

import javax.swing.JOptionPane;

/**
 *
 * @author Particular
 */
public class ConfirmacionExahustiva {
   
    /**
     * En caso de que la respuesta sea eliminar. 
     */
    public static final int SI_ELIMINAR =0;

    /**
     * Cuando el usuario no esta segúro. Solo utilizar en casos especiales. 
     */
    public static final int NO_ESTOY_SEGURO =1;

    /**
     * Cuando el usario le gusta la payasada. XP Solo utilizar en casos especiales. 
     */
    public static final int DEFINITIVAMENTE_NO_ELIMINAR =2;
    
    /**
     * Multiple confirmación para la elminación de datos sensibles que no tienen
     * retorno. 
     * @param msj1
     * @param msj2
     * @return
     */
    public static int confirmarEliminacionPeligrosa(String msj1, String msj2){
        String preMsj2 = "Te lo preguntare de nuevo.\n"
                            + "\n----------------------------------\n ";
        msj2 = preMsj2 + msj2;
        
        int r = JOptionPane.showConfirmDialog(
                    null,
                    msj1,
                    "¿Estas segúro que quieres hacer esto?",
                    JOptionPane.YES_NO_OPTION);
        if (r==JOptionPane.YES_OPTION) {
            String[] opciones = new String[3];
            opciones[0]= "¡ Si ! , conozco los riesgos";
            opciones[1]= "No estoy segúro";
            opciones[2]= "¡ Claro que no, Dios mio!  ¿Que clase de persona soy?";

            String mensaje = msj2;
            r = JOptionPane.showOptionDialog(
                        null, 
                        mensaje, 
                        "ESTO ES MUY PELIGROSO",
                        JOptionPane.YES_NO_CANCEL_OPTION , 
                        JOptionPane.QUESTION_MESSAGE,
                        null, opciones, opciones[2]);
        }else{
            return JOptionPane.NO_OPTION;
        }
        switch(r){
                case 1:
                    JOptionPane.showMessageDialog(null, "Entonces no lo hagas. "
                            + "\nSi en realidad no la ocupas más adelante podras eliminarla.");
                    JOptionPane.showMessageDialog(null, "No se eliminó.");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "<html><p ALIGN=center><font size=+2>¡ Aleluya ! ¡ Una oveja que vuelve al camino ! </font></p>"
                            + "<br> <p ALIGN=center> Pero no olvides que... te estamos observando</p> "
                            + "<br><p ALIGN=center><font size=+4> (͡๏̯͡๏)    ◉╭╮◉    【•】_【•】    &lt;('o'&lt;) </font> </p></html>");
                    JOptionPane.showMessageDialog(null, "No se eliminó.");
                    break;

            }
        return r;
    }
    
}
