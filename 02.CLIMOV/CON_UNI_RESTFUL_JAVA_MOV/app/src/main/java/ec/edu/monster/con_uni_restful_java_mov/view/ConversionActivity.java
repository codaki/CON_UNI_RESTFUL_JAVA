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
        // Construcción de la solicitud (debería usarse Retrofit en un caso real)
        ConversionModel.ConversionRequest conversionRequest = new ConversionModel.ConversionRequest(value, fromUnit, toUnit);

        // Simulación de un resultado local (puedes integrar Retrofit aquí)
        double convertedValue = simulateConversion(value, fromUnit, toUnit);

        // Mostrar el resultado
        tvResult.setText(String.format("Resultado: %.4f %s", convertedValue, toUnit));
    }

    private double simulateConversion(double value, String fromUnit, String toUnit) {
        // Aquí puedes usar lógica local para simular resultados o integrar Retrofit
        HashMap<String, Double> toPascal = new HashMap<>();
        toPascal.put("Pa", 1.0);
        toPascal.put("Bar", 100000.0);
        toPascal.put("Psi", 6894.76);
        toPascal.put("Atm", 101325.0);
        toPascal.put("mmHg", 133.322);

        // Convertir a Pascal
        double valueInPascal = value * toPascal.get(fromUnit);

        // Convertir de Pascal a la unidad de destino
        double conversionFactor = toPascal.get(toUnit);
        return valueInPascal / conversionFactor;
    }
}