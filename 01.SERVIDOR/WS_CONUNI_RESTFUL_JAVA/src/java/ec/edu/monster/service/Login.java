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
@Path("generic")
public class Login {

    @Context
    private UriInfo context;
   // Variable para almacenar el número
    private static String storedValue = "Servidor Levantado";  // Valor por defecto inicial

    /**
     * Creates a new instance of Login
     */
    public Login() {
    }
    /**
     * Method to authenticate.
     * @param conversionRequest - object that contains username,password.
     * @return object with username and password;
     */
 @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("login")
    public ConversionResponse login(ConversionRequest conversionRequest) {
        String username = conversionRequest.getUsername();
        String password = conversionRequest.getPassword();
        if(username.equals("monster") && password.equals( "$2a$12$PDSnjQhKx7Rr0Q0MC25gLe913dhPHFXXi7tDO5V50foKd1qckQhn2")){
            ConversionResponse resultado = new ConversionResponse(username,password);
            return resultado;
        }else{
            ConversionResponse resultado = new ConversionResponse("null","null");
            return resultado;
        }
    }
     public static class ConversionRequest {
       
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
        
     }
     
     public static class ConversionResponse{
         private String username;
        private String password;
        public ConversionResponse(String username, String password){
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
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
