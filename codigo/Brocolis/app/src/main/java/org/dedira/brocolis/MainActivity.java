package org.dedira.brocolis;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView txtNome;
    private TextView txtSobrenome;

    private Button btnApaga;
    private Button btnAltera;
    private Button btnAbrecalculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = findViewById(R.id.txtNome);
        txtSobrenome = findViewById(R.id.txtSobrenome);
        btnAbrecalculadora = findViewById(R.id.btnAbrecalculadora);
        btnAltera = findViewById(R.id.btnAltera);
        btnApaga = findViewById(R.id.btnApaga);

        btnApaga.setOnClickListener(v -> {
            txtNome.setText("");
            txtSobrenome.setText("");
        });

        btnAltera.setOnClickListener(v -> {
            txtNome.setText("Iga");
            txtSobrenome.setText("Fogueira");
        });

        btnAbrecalculadora.setOnClickListener(v -> {
            Intent intent = new Intent(this, Calculadora.class);
            startActivity(intent);
        });
    }
}