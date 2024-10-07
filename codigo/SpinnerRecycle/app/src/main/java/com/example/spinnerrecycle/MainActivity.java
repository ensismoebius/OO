package com.example.spinnerrecycle;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<Comida> lista;

    private Spinner spinner;
    private SpinnerAdaptador spinnerAdaptador;

    private RecyclerView rcl_valores;
    private RecycleAdaptador recycleAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lista = BancoDeDados.carregaListaDeComidas(this);

        spinnerAdaptador = new SpinnerAdaptador(this, lista);
        spinner = findViewById(R.id.spn_valores);
        spinner.setAdapter(spinnerAdaptador);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, lista.get(i).nome, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "Nada selecionado", Toast.LENGTH_SHORT).show();
            }
        });

        recycleAdaptador = new RecycleAdaptador(this, lista, comida -> {
            Toast.makeText(MainActivity.this, comida.nome, Toast.LENGTH_SHORT).show();
        });
        rcl_valores = findViewById(R.id.rcl_valores);
        rcl_valores.setAdapter(recycleAdaptador);
        rcl_valores.setLayoutManager(new LinearLayoutManager(this));

    }
}