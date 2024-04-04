package org.dedira.utilitarios;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCalculadora = findViewById(R.id.btnAbrirCalculadora);

        btnCalculadora.setOnClickListener(referenciaAoBotaoQueFoiClicado -> {
            Intent intencaoDeAbrir = new Intent(this, Calculadora.class);
            startActivity(intencaoDeAbrir);
        });


    }
}