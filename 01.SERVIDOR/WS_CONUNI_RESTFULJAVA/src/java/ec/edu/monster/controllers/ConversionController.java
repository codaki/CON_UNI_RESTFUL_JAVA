/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controllers;

import ec.edu.monster.modelos.Conversion.ConversionRequest;
import ec.edu.monster.modelos.Conversion.ConversionResponse;

/**
 *
 * @author danie
 */
public class ConversionController {
     public ConversionResponse convertPressure(ConversionRequest conversionRequest) {
        double valor = conversionRequest.getValor();
        String fromUnit = conversionRequest.getFromUnit();
        String toUnit = conversionRequest.getToUnit();
        
        double valorEnPascal = 0;
        double valorConvertido = 0;

        // Convert from the original unit to Pascal (Pa)
        switch (fromUnit.toLowerCase()) {
            case "pa":
                valorEnPascal = valor;
                break;
            case "bar":
                valorEnPascal = valor * 100000;
                break;
            case "atm":
                valorEnPascal = valor * 101325;
                break;
            case "psi":
                valorEnPascal = valor * 6894.76;
                break;
            case "mmhg":
                valorEnPascal = valor * 133.322;
                break;
            default:
                throw new IllegalArgumentException("Unidad no reconocida: " + fromUnit);
        }

        // Convert from Pascal (Pa) to the desired unit
        switch (toUnit.toLowerCase()) {
            case "pa":
                valorConvertido = valorEnPascal;
                break;
            case "bar":
                valorConvertido = valorEnPascal / 100000;
                break;
            case "atm":
                valorConvertido = valorEnPascal / 101325;
                break;
            case "psi":
                valorConvertido = valorEnPascal / 6894.76;
                break;
            case "mmhg":
                valorConvertido = valorEnPascal / 133.322;
                break;
            default:
                throw new IllegalArgumentException("Unidad no reconocida: " + toUnit);
        }

        return new ConversionResponse(valorConvertido, toUnit, fromUnit, valor);
    }
}
