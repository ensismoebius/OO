package com.example.teste;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtMensagem = this.findViewById(R.id.txtMensagem);

        Button btnMensagem = this.findViewById(R.id.btnMensagem);
        btnMensagem.setOnClickListener(v -> {
            String valor = txtMensagem.getText().toString();
            Toast.makeText(this, valor, Toast.LENGTH_LONG).show();
        });
    }
}