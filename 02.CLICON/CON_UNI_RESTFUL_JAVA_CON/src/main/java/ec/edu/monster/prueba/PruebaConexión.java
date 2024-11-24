package ec.edu.monster.prueba;

import ec.edu.monster.controllers.LoginController;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danie
 */
public class PruebaConexión {
    public static void main(String[] args) {
        LoginController controller = new LoginController();
        try {
            controller.autenticar("monster", "monster");
            System.out.println("Conexión Exitosa");
        } catch (Exception ex) {
            Logger.getLogger(PruebaConexión.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
