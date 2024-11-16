/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controllers;

import ec.edu.monster.modelos.Login.ConversionRequestL;
import ec.edu.monster.modelos.Login.ConversionResponseL;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 *
 * @author danie
 */
public class LoginController {
    
   
    public ConversionResponseL login(ConversionRequestL conversionRequest) {
        String username = conversionRequest.getUsername();
        String password = conversionRequest.getPassword();
        if(username.equals("monster") && password.equals( "$2a$12$PDSnjQhKx7Rr0Q0MC25gLe913dhPHFXXi7tDO5V50foKd1qckQhn2")){
            ConversionResponseL resultado = new ConversionResponseL(username,password);
            return resultado;
        }else{
            ConversionResponseL resultado = new ConversionResponseL("null","null");
            return resultado;
        }
    }
    
}
