/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package ec.edu.monster.servicios;

import ec.edu.monster.controllers.ConversionController;
import ec.edu.monster.modelos.Conversion.ConversionRequest;
import ec.edu.monster.modelos.Conversion.ConversionResponse;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author danie
 */
@Path("conversion")
public class ConversionResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ConversionResource
     */
    public ConversionResource() {
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
     public ConversionResponse convertPressure(ConversionRequest conversionRequest) {
     ConversionController controlador = new ConversionController();
     ConversionResponse resultado = controlador.convertPressure(conversionRequest);
     return resultado;
     }
}
