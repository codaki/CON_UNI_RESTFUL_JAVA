package ec.edu.monster.con_uni_restful_java_mov.controller;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import ec.edu.monster.con_uni_restful_java_mov.models.LoginModel;
import ec.edu.monster.con_uni_restful_java_mov.service.ApiService;
import ec.edu.monster.con_uni_restful_java_mov.view.ConversionActivity;
import ec.edu.monster.con_uni_restful_java_mov.service.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginController {

    public void autenticar(String username, String password, Context context) {
        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);
        LoginModel.ConversionRequestL loginRequest = new LoginModel.ConversionRequestL(username, password);

        Call<LoginModel.ConversionResponseL> call = apiService.login(loginRequest);
        call.enqueue(new Callback<LoginModel.ConversionResponseL>() {
            @Override
            public void onResponse(Call<LoginModel.ConversionResponseL> call, Response<LoginModel.ConversionResponseL> response) {
                if (response.isSuccessful() && response.body() != null) {
                    LoginModel.ConversionResponseL loginResponse = response.body();
                    if (!"null".equals(loginResponse.getUsername())) {
                        // Inicio de sesión exitoso
                        Log.d("Login", "Bienvenido, " + loginResponse.getUsername());
                        Toast.makeText(context, "Bienvenido, " + loginResponse.getUsername(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context, ConversionActivity.class);
                        context.startActivity(intent);
                    } else {
                        // Credenciales incorrectas
                        Log.d("Login", "Credenciales incorrectas");
                        Toast.makeText(context, "Credenciales incorrectas. Inténtelo de nuevo.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Respuesta vacía o no exitosa
                    Log.d("Login", "Respuesta no exitosa o vacía");
                    Toast.makeText(context, "Error al iniciar sesión. Inténtelo más tarde.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginModel.ConversionResponseL> call, Throwable t) {
                Log.e("Login", "Error: " + t.getMessage());
                Toast.makeText(context, "Error de conexión. Verifique su red.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
