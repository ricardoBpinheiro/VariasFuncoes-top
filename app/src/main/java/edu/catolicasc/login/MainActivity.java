package edu.catolicasc.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private EditText editTextSenha;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.EtLogin);
        editTextSenha = findViewById(R.id.EtSenha);
        button = findViewById(R.id.buttonTimer);


        button.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final String login = editText.getText().toString();
            final String senha = editTextSenha.getText().toString();

            if (login.equals("r") && senha.equals("r")){
                Toast.makeText(MainActivity.this, "Login com sucesso", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, TelaAtividades.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(MainActivity.this, "Login ou senha incorretos", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
