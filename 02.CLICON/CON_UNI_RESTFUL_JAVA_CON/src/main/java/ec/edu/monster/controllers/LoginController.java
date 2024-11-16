/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controllers;

import ec.edu.monster.models.LoginModel.ConversionRequestL;
import ec.edu.monster.models.LoginModel.ConversionResponseL;
import ec.edu.monster.service.WSClientLogin;
import javax.ws.rs.ClientErrorException;


/**
 *
 * @author danie
 */
public class LoginController {
    
    /**
     * Intenta autenticar un usuario con las credenciales proporcionadas
     * @param username nombre de usuario
     * @param password contraseña del usuario
     * @return true si la autenticación es exitosa, false en caso contrario
     * @throws Exception si ocurre un error durante la autenticación
     */
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

    /**
     * Método simplificado para verificar credenciales con manejo de errores incluido
     * @param username nombre de usuario
     * @param password contraseña
     * @return mensaje de estado de la autenticación
     */
    public String verificarCredenciales(String username, String password) {
        try {
            boolean autenticado = autenticar(username, password);
            if (autenticado) {
                return "Autenticación exitosa";
            } else {
                return "Credenciales inválidas";
            }
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
    
    /**
     * Verifica si un nombre de usuario tiene un formato válido
     * @param username nombre de usuario a validar
     * @return true si el formato es válido, false en caso contrario
     */
    public boolean validarFormatoUsuario(String username) {
        if (username == null || username.trim().isEmpty()) {
            return false;
        }
        // Puedes agregar más reglas de validación según tus necesidades
        return username.matches("^[a-zA-Z0-9_]{3,20}$");
    }
}