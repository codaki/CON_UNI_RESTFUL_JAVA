/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.pruebas;

import ec.edu.monster.controllers.ConversionController;
import ec.edu.monster.modelos.Conversion.ConversionRequest;
import ec.edu.monster.modelos.Conversion.ConversionResponse;
/**
 *
 * @author danie
 */
public class PruebaConexion {
    public static void main(String[] args) {
         ConversionController controlador = new ConversionController();
         ConversionRequest conversionRequest = new ConversionRequest();
         
         conversionRequest.setFromUnit("psi");
         conversionRequest.setToUnit("atm");
         conversionRequest.setValor(123);
         
         ConversionResponse conversionResponse = controlador.convertPressure(conversionRequest);
         System.out.println("el resultado es :"+conversionResponse.getResultado());
         
    }
}
