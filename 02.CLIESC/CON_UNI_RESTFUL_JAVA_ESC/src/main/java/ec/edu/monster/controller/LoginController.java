/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controller;

import ec.edu.monster.model.LoginModel;
import ec.edu.monster.model.LoginModel.ConversionRequestL;
import ec.edu.monster.model.LoginModel.ConversionResponseL;
import ec.edu.monster.service.WSClientLogin;
import ec.edu.monster.view.LoginView;
import ec.edu.monster.view.ConversionView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.ws.rs.ClientErrorException;
/**
 *
 * @author JOSE
 */
public class LoginController {
    
    private LoginView loginView;
    private LoginModel loginModel;

    public LoginController(LoginView loginView, LoginModel loginModel) {
        this.loginView = loginView;
        this.loginModel = loginModel;

        this.loginView.getBtnLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    verificarCredenciales();
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public LoginController() {
    }
    
    
    public boolean autenticar(String username, String password) throws Exception {
        WSClientLogin client = new WSClientLogin();
        try {
            // Validar entrada
            if (username == null || username.trim().isEmpty()) {
                throw new Exception("El nombre de usuario no puede estar vacío");
            }
            if (password == null || password.trim().isEmpty()) {
                throw new Exception("La contraseña no puede estar vacía");
            }

            // Crear solicitud
            ConversionRequestL request = new ConversionRequestL();
            request.setUsername(username.trim());
            request.setPassword(password);

            // Realizar petición al servicio
            ConversionResponseL response = client.login(request, ConversionResponseL.class);

            // Validar respuesta
            if (response == null) {
                throw new Exception("No se recibió respuesta del servidor");
            }
                System.out.println(response.getUsername());
                System.out.println(response.getPassword());
            // Verificar autenticación exitosa
            return response.getUsername() != null && !response.getUsername().equals("null");

        } catch (ClientErrorException e) {
            System.err.println("Error durante la autenticación: " + e.getMessage());
            throw new Exception("Error de conexión con el servidor: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            throw e;
        } finally {
            client.close();
        }
    }
    
    public void verificarCredenciales() throws NoSuchAlgorithmException {
        String username = loginView.getTxtUsername().getText();
        String hashedpassword = loginView.hashPassword();

        try {
            boolean autenticado = autenticar(username, hashedpassword);
            if (autenticado) {
                loginView.dispose();
            ConversionView conv = new ConversionView();
            conv.setVisible(true);
            } else {
                loginView.getMessageLabel().setText("Usuario o contraseña inválidos.");
            }
        } catch (Exception e) {
            loginView.getMessageLabel().setText("Error: " + e.getMessage());
        }
        
    }
    
}
