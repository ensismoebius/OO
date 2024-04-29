package com.example.lista;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView listaDePessoas = findViewById(R.id.lstPessoas);
        listaDePessoas.setLayoutManager(new LinearLayoutManager(this));

        List<Pessoa> minhasPessoas = new ArrayList<Pessoa>();

        minhasPessoas.add(new Pessoa("Aga", "Silva", 2010));
        minhasPessoas.add(new Pessoa("Ega", "Silva", 2010));
        minhasPessoas.add(new Pessoa("Iga", "Silva", 2010));
        minhasPessoas.add(new Pessoa("Oga", "Silva", 2010));
        minhasPessoas.add(new Pessoa("Uga", "Silva", 2010));

        listaDePessoas.setAdapter(new Adaptador(minhasPessoas, this));

    }
}