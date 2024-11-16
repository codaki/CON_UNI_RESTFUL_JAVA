package ec.edu.monster.service;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;


/**
 * REST Web Service
 *
 * @author danie
 */
@Path("conversionUnidades")
public class ConversionUnidadesResource {

    @Context
    private UriInfo context;
    
    // Variable para almacenar el número
    private static String storedValue = "Servidor Levantado";  // Valor por defecto inicial

    /**
     * Creates a new instance of ConversionUnidadesResource
     */
    public ConversionUnidadesResource() {
    }
    
     /**
     * Method to convert pressure from one unit to another.
     * @param conversionRequest - object that contains value, fromUnit, and toUnit.
     * @return converted value.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("convertPressure")
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
     public static class ConversionRequest {
        private double valor;
        private String fromUnit;
        private String toUnit;

        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }

        public String getFromUnit() {
            return fromUnit;
        }

        public void setFromUnit(String fromUnit) {
            this.fromUnit = fromUnit;
        }

        public String getToUnit() {
            return toUnit;
        }

        public void setToUnit(String toUnit) {
            this.toUnit = toUnit;
        }
    }
     
     public static class ConversionResponse {
        private double resultado;
        private String toUnit;
        private String fromUnit;
        private double valor;

        public ConversionResponse(double valorConvertido, String unidadDestino, String unidadInicial, double valorOriginal) {
            this.resultado = valorConvertido;
            this.toUnit = unidadDestino;
            this.valor = valorOriginal;
            this.fromUnit = unidadInicial;
        }

        public double getResultado() {
            return resultado;
        }

        public void setResultado(double resultado) {
            this.resultado = resultado;
        }

        public String getToUnit() {
            return toUnit;
        }

        public void setToUnit(String toUnit) {
            this.toUnit = toUnit;
        }

        public String getFromUnit() {
            return fromUnit;
        }

        public void setFromUnit(String fromUnit) {
            this.fromUnit = fromUnit;
        }

        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }

      
    }

    /**
     * Retrieves the stored Double value.
     * @return the stored Double value.
     */
    @GET
     @Path("convertPressure")
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getJson() {
        // Retorna el valor actual almacenado
        return storedValue;
    }

   
}
