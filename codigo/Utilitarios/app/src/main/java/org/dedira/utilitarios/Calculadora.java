package org.dedira.utilitarios;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculadora extends AppCompatActivity {

    private String fazerConta(Operacoes tipo, EditText valor1, EditText valor02) {
        float v1, v2, resultado = 0;

        try {
            v1 = Float.valueOf(valor1.getText().toString());
        } catch (NumberFormatException e) {
            return "Campo valor01 com número em formato errado";
        }

        try {
            v2 = Float.valueOf(valor02.getText().toString());
        } catch (NumberFormatException e) {
            return "Campo valor02 com número em formato errado";
        }

        switch (tipo) {
            case MAIS:
                resultado = v1 + v2;
                break;
            case MENOS:
                resultado = v1 - v2;
                break;
            case DIVISAO:
                resultado = v1 / v2;
                break;
            case MULTIPLICACAO:
                resultado = v1 * v2;
        }

        return String.valueOf(resultado);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        Button div = findViewById(R.id.btnDiv);
        Button mais = findViewById(R.id.btnMais);
        Button multi = findViewById(R.id.btnMult);
        Button menos = findViewById(R.id.btnMenos);

        EditText valor1 = findViewById(R.id.txtValor01);
        EditText valor2 = findViewById(R.id.txtValor02);
        TextView resultado = findViewById(R.id.txtResultado);

        div.setOnClickListener(v -> {
            resultado.setText(fazerConta(Operacoes.DIVISAO, valor1, valor2));
        });

        mais.setOnClickListener(v -> {
            resultado.setText(fazerConta(Operacoes.MAIS, valor1, valor2));
        });

        multi.setOnClickListener(v -> {
            resultado.setText(fazerConta(Operacoes.MULTIPLICACAO, valor1, valor2));
        });

        menos.setOnClickListener(v -> {
            resultado.setText(fazerConta(Operacoes.MENOS, valor1, valor2));
        });
    }
}