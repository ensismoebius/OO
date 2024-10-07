package org.dedira.brocolis;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Atividade principal da aplicação.
 * {@link MainActivity} extende {@link AppCompatActivity}
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Elementos da tela.
     */

    // Campo de nome
    private TextView txtNome;
    // Campo de sobrenome
    private TextView txtSobrenome;

    /**
     * Botões da tela
     */

    // Botão de apagar
    private Button btnApaga;
    // Botão de alterar
    private Button btnAltera;
    //
    private Button btnAbrecalculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencia os elementos da tela
        txtNome = findViewById(R.id.txtNome);
        txtSobrenome = findViewById(R.id.txtSobrenome);
        btnAbrecalculadora = findViewById(R.id.btnAbrecalculadora);
        btnAltera = findViewById(R.id.btnAltera);
        btnApaga = findViewById(R.id.btnApaga);


        /**
         * Configura os listeners dos botões
         */

        // Botão apagar
        btnApaga.setOnClickListener(v -> {
            txtNome.setText("");
            txtSobrenome.setText("");
        });

        // Botão alterar
        btnAltera.setOnClickListener(v -> {
            txtNome.setText("Iga");
            txtSobrenome.setText("Fogueira");
        });

        // Botão abrir calculadora
        btnAbrecalculadora.setOnClickListener(v -> {
            // Abre a tela de calculadora
            Intent intent = new Intent(this, Calculadora.class);
            // Inicia a tela
            startActivity(intent);
        });
    }
}