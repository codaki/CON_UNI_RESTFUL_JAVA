package ec.edu.monster.con_uni_restful_java_mov.controller;

import android.util.Log;

import ec.edu.monster.con_uni_restful_java_mov.models.ConversionModel;
import ec.edu.monster.con_uni_restful_java_mov.service.ApiService;
import ec.edu.monster.con_uni_restful_java_mov.service.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConversionController {
    public void convertPressure(double value, String fromUnit, String toUnit) {
        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);
        ConversionModel.ConversionRequest conversionRequest = new ConversionModel.ConversionRequest(value, fromUnit, toUnit);

        Call<ConversionModel.ConversionResponse> call = apiService.convertPressure(conversionRequest);
        call.enqueue(new Callback<ConversionModel.ConversionResponse>() {
            @Override
            public void onResponse(Call<ConversionModel.ConversionResponse> call, Response<ConversionModel.ConversionResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ConversionModel.ConversionResponse conversionResponse = response.body();
                    Log.d("Conversion", "Result: " + conversionResponse.getResultado());
                }
            }

            @Override
            public void onFailure(Call<ConversionModel.ConversionResponse> call, Throwable t) {
                Log.e("Conversion", "Error: " + t.getMessage());
            }
        });
    }

}
