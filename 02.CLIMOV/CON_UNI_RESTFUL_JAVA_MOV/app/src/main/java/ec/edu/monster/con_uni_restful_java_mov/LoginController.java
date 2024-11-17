package ec.edu.monster.con_uni_restful_java_mov;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

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
                        // Login successful
                        Log.d("Login", "Welcome, " + loginResponse.getUsername());

                        // Navigate to ConversionActivity
                        Intent intent = new Intent(context, ConversionActivity.class);
                        context.startActivity(intent);
                    } else {
                        // Invalid credentials
                        Log.d("Login", "Invalid credentials");
                    }
                } else {
                    Log.d("Login", "Response unsuccessful or empty");
                }
            }

            @Override
            public void onFailure(Call<LoginModel.ConversionResponseL> call, Throwable t) {
                Log.e("Login", "Error: " + t.getMessage());
            }
        });
    }


}
