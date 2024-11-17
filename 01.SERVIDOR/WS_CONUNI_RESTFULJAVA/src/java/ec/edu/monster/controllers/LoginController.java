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
        if(username.equals("monster") &&( password.equals( "774e993500f4027acfd72b7a7ee564b76ae43cf7c4c943ed0e0f364cca16b6ec")||password.equals("e56d08319e1dad67ecb90863584746c702aa1a8908608e5c9cec961fc352db51"))){
            ConversionResponseL resultado = new ConversionResponseL(username,password);
            return resultado;
        }else{
            ConversionResponseL resultado = new ConversionResponseL("null","null");
            return resultado;
        }
    }
    
}
