package ec.edu.monster.con_uni_restful_java_mov.view;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.HashMap;
import androidx.appcompat.app.AppCompatActivity;

import ec.edu.monster.con_uni_restful_java_mov.R;
import ec.edu.monster.con_uni_restful_java_mov.controller.ConversionController;
import ec.edu.monster.con_uni_restful_java_mov.models.ConversionModel;

public class ConversionActivity extends AppCompatActivity {

    private EditText etValue;
    private Spinner spnFromUnit, spnToUnit;
    private TextView tvResult;
    private Button btnConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        // Vincular elementos de la vista
        etValue = findViewById(R.id.etValue);
        spnFromUnit = findViewById(R.id.spnFromUnit);
        spnToUnit = findViewById(R.id.spnToUnit);
        tvResult = findViewById(R.id.tvResult);
        btnConvert = findViewById(R.id.btnConvert);

        // Opciones para las unidades de conversión
        String[] units = {"Pa", "Bar", "Psi", "Atm", "mmHg"};

        // Configurar los spinners con las unidades
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, units);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnFromUnit.setAdapter(adapter);
        spnToUnit.setAdapter(adapter);

        // Acción al presionar el botón de conversión
        btnConvert.setOnClickListener(v -> {
            try {
                // Obtener valores de entrada
                String fromUnit = spnFromUnit.getSelectedItem().toString();
                String toUnit = spnToUnit.getSelectedItem().toString();
                double value = Double.parseDouble(etValue.getText().toString());

                // Llamar al servicio de conversión
                performConversion(value, fromUnit, toUnit);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Ingrese un valor válido", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void performConversion(double value, String fromUnit, String toUnit) {
        // Llama al servicio usando ConversionController
        ConversionController conversionController = new ConversionController();
        conversionController.convertPressure(value, fromUnit, toUnit, new ConversionController.ConversionCallback() {
            @Override
            public void onSuccess(double result, String toUnit) {
                runOnUiThread(() -> {
                    tvResult.setText(String.format("Resultado: %.4f %s", result, toUnit));
                });
            }

            @Override
            public void onFailure(String errorMessage) {
                runOnUiThread(() -> {
                    Toast.makeText(ConversionActivity.this, "Error: " + errorMessage, Toast.LENGTH_SHORT).show();
                });
            }
        });
    }

}