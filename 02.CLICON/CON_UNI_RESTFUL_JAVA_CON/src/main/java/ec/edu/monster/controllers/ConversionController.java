/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controllers;

import ec.edu.monster.models.ConversionModel.ConversionRequest;
import ec.edu.monster.models.ConversionModel.ConversionResponse;
import ec.edu.monster.service.WSClientConversion;

/**
 *
 * @author danie
 */
public class ConversionController {
    
    public ConversionResponse convertPressure(double value, String fromUnit, String toUnit) throws Exception {
        WSClientConversion client = new WSClientConversion();
        try {
            // Prepare the request
            ConversionRequest request = new ConversionRequest();
            request.setValor(value);
            request.setFromUnit(fromUnit);
            request.setToUnit(toUnit);
            System.out.println(value);
            System.out.println(toUnit);
            System.out.println(fromUnit);
            
            // Make the request to the web service
            ConversionResponse response = client.convertPressure(request, ConversionResponse.class);
            
            // Validate response
            if (response == null) {
                throw new Exception("No se recibió respuesta del servicio de conversión");
            }
            System.out.println(response.getResultado());
            return response;
            
        } catch (javax.ws.rs.ClientErrorException e) {
            System.err.println("Error en la conversión: " + e.getMessage());
            throw new Exception("Error al realizar la conversión: " + e.getMessage());
        } finally {
            client.close();
        }
    }
    
    // Método de utilidad para validar unidades de presión
    public boolean isValidPressureUnit(String unit) {
        String[] validUnits = {"pascal", "bar", "psi", "atm", "torr"};
        for (String validUnit : validUnits) {
            if (validUnit.equalsIgnoreCase(unit)) {
                return true;
            }
        }
        return false;
    }
    
    // Método para facilitar el uso con manejo de errores incluido
    public double convertPressureValue(double value, String fromUnit, String toUnit) throws Exception {
        // Validar unidades
        if (!isValidPressureUnit(fromUnit) || !isValidPressureUnit(toUnit)) {
            throw new Exception("Unidades de presión no válidas");
        }
        
        // Realizar conversión
        ConversionResponse response = convertPressure(value, fromUnit, toUnit);
        return response.getResultado();
    }
}
