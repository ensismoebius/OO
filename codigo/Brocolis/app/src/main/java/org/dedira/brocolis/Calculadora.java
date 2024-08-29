package org.dedira.brocolis;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Calculadora extends AppCompatActivity {

    private EditText txtNumeroA;
    private EditText txtNumeroB;
    private Button btnSoma;
    private Button btnSubtrair;
    private Button btnMultiplicar;
    private Button btnDividir;
    private Button btnPotencia;

    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        txtNumeroA = findViewById(R.id.txtNumeroA);
        txtNumeroB = findViewById(R.id.txtNumeroB);
        txtResultado = findViewById(R.id.txtResultado);
        btnPotencia = findViewById(R.id.btnPotencia);
        btnSoma = findViewById(R.id.btnSoma);
        btnSubtrair = findViewById(R.id.btnSubtrair);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);

        btnSoma.setOnClickListener(v -> {
            double numeroA = Double.parseDouble(txtNumeroA.getText().toString());
            double numeroB = Double.parseDouble(txtNumeroB.getText().toString());
            double resultado = numeroA + numeroB;
            txtResultado.setText(String.valueOf(resultado));

            BD bd = new BD();
            Expressao expressao = new Expressao();
            expressao.expressao = numeroA + " + " + numeroB;
            expressao.resultado = String.valueOf(resultado);
            bd.salvar(expressao, sucesso -> {
                if(sucesso){
                    Toast.makeText(
                            this,
                            "Sucesso",
                            Toast.LENGTH_SHORT
                    ).show();
                }else{
                    Toast.makeText(
                            this,
                            "Erro",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            });
        });

        btnSubtrair.setOnClickListener(v -> {
            double numeroA = Double.parseDouble(txtNumeroA.getText().toString());
            double numeroB = Double.parseDouble(txtNumeroB.getText().toString());
            double resultado = numeroA - numeroB;
            txtResultado.setText(String.valueOf(resultado));
        });

        btnMultiplicar.setOnClickListener(v -> {
            double numeroA = Double.parseDouble(txtNumeroA.getText().toString());
            double numeroB = Double.parseDouble(txtNumeroB.getText().toString());
            double resultado = numeroA * numeroB;
            txtResultado.setText(String.valueOf(resultado));
        });

        btnDividir.setOnClickListener(v -> {
            double numeroA = Double.parseDouble(txtNumeroA.getText().toString());
            double numeroB = Double.parseDouble(txtNumeroB.getText().toString());
            double resultado = numeroA / numeroB;
            txtResultado.setText(String.valueOf(resultado));
        });

        btnPotencia.setOnClickListener(v -> {
            double numeroA = Double.parseDouble(txtNumeroA.getText().toString());
            double numeroB = Double.parseDouble(txtNumeroB.getText().toString());
            double resultado = Math.pow(numeroA, numeroB);
            txtResultado.setText(String.valueOf(resultado));
        });
    }
}