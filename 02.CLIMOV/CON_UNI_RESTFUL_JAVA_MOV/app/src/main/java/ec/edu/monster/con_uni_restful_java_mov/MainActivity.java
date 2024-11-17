package ec.edu.monster.con_uni_restful_java_mov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import ec.edu.monster.con_uni_restful_java_mov.LoginController.*;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText etUsername = findViewById(R.id.etUsername);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();

            String hashedPassword = HashUtils.hashPassword(password);
             // Call your login API method here
            loginUser(username, hashedPassword);
        });
    }

    private void loginUser(String username, String password) {
        LoginController loginController = new LoginController();
        loginController.autenticar(username, password,this);
    }

}