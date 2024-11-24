package ec.edu.monster.con_uni_restful_java_mov.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ec.edu.monster.con_uni_restful_java_mov.controller.HashUtils;
import ec.edu.monster.con_uni_restful_java_mov.controller.LoginController;
import ec.edu.monster.con_uni_restful_java_mov.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText etUsername = findViewById(R.id.etUsername);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                // Mostrar mensaje de campos vacíos
                Toast.makeText(this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show();
            } else {
                // Continuar con la autenticación
                String hashedPassword = HashUtils.hashPassword(password);
                loginUser(username, hashedPassword);
            }
        });
    }

    private void loginUser(String username, String password) {
        LoginController loginController = new LoginController();
        loginController.autenticar(username, password, this);
    }
}