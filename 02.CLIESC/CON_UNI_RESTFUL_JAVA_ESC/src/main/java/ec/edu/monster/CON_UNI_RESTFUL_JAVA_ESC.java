/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.monster;

import ec.edu.monster.controller.LoginController;
import ec.edu.monster.model.LoginModel;
import ec.edu.monster.view.LoginView;

/**
 *
 * @author JOSE
 */
public class CON_UNI_RESTFUL_JAVA_ESC {

    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        LoginModel loginModel = new LoginModel();
        
        // Crear el controlador de Login y vincularlo a la vista y el modelo
        LoginController loginController = new LoginController(loginView, loginModel);
        
        // Hacer visible la ventana de Login
        loginView.setVisible(true);

    }
      
}
