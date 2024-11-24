package ec.edu.monster.con_uni_restful_java_mov.controller;

import android.util.Log;

import ec.edu.monster.con_uni_restful_java_mov.models.ConversionModel;
import ec.edu.monster.con_uni_restful_java_mov.service.ApiService;
import ec.edu.monster.con_uni_restful_java_mov.service.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConversionController {

    public interface ConversionCallback {
        void onSuccess(double result, String toUnit);
        void onFailure(String errorMessage);
    }

    public void convertPressure(double value, String fromUnit, String toUnit, ConversionCallback callback) {
        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);
        ConversionModel.ConversionRequest conversionRequest = new ConversionModel.ConversionRequest(value, fromUnit, toUnit);

        Call<ConversionModel.ConversionResponse> call = apiService.convertPressure(conversionRequest);
        call.enqueue(new Callback<ConversionModel.ConversionResponse>() {
            @Override
            public void onResponse(Call<ConversionModel.ConversionResponse> call, Response<ConversionModel.ConversionResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ConversionModel.ConversionResponse conversionResponse = response.body();
                    callback.onSuccess(conversionResponse.getResultado(), conversionResponse.getToUnit());
                } else {
                    callback.onFailure("Error en la respuesta del servidor");
                }
            }

            @Override
            public void onFailure(Call<ConversionModel.ConversionResponse> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }
}

