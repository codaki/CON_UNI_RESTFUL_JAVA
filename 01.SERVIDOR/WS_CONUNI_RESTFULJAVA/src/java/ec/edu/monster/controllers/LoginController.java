/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controllers;

import ec.edu.monster.modelos.Login.ConversionRequestL;
import ec.edu.monster.modelos.Login.ConversionResponseL;

/**
 *
 * @author danie
 */
public class LoginController {
    
   
    public ConversionResponseL login(ConversionRequestL conversionRequest) {
        String username = conversionRequest.getUsername();
        String password = conversionRequest.getPassword();
        if(username.equals("monster") && password.equals( "monster")){
            ConversionResponseL resultado = new ConversionResponseL(username,password);
            return resultado;
        }else{
            ConversionResponseL resultado = new ConversionResponseL("null","null");
            return resultado;
        }
    }
    
}
