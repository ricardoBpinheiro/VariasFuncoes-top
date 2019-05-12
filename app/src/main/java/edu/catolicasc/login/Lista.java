package edu.catolicasc.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private ListView listView;
    private ArrayList<String> listaProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depois_do_login);

        editText = findViewById(R.id.EtLista);
        button = findViewById(R.id.button2);
        listView = findViewById(R.id.Lista);
        listaProdutos = new ArrayList<>();

        button.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            listaProdutos.add(editText.getText().toString());  //Adiciona o valor que esta escrito no EditText e coloca na lista
            ArrayAdapter arrayAdapter = new ArrayAdapter(Lista.this, android.R.layout.simple_list_item_1, listaProdutos);
            listView.setAdapter(arrayAdapter);
            editText.setText("");
        }
    };
}
