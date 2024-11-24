package ec.edu.monster.con_uni_restful_java_mov.service;
import ec.edu.monster.con_uni_restful_java_mov.models.ConversionModel;
import ec.edu.monster.con_uni_restful_java_mov.models.LoginModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    // Login endpoint
    @POST("login")
    Call<LoginModel.ConversionResponseL> login(@Body LoginModel.ConversionRequestL loginRequest);

    // Conversion endpoint
    @POST("conversion")
    Call<ConversionModel.ConversionResponse> convertPressure(@Body ConversionModel.ConversionRequest conversionRequest);
}
