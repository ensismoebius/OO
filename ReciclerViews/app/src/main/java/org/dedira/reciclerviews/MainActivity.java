package org.dedira.reciclerviews;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.dedira.reciclerviews.model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int spanCount = 2;
        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        pessoas.add(new Pessoa("Uga", "Silva", 2010));
        pessoas.add(new Pessoa("Uga", "Silva", 2010));
        pessoas.add(new Pessoa("Uga", "Silva", 2010));
        RecyclerView rc = findViewById(R.id.listaTeste);
//        rc.setLayoutManager(new LinearLayoutManager(this));
        rc.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        rc.setLayoutManager(new GridLayoutManager(this, spanCount));
//        rc.setLayoutManager(new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL));


        rc.setAdapter(new ListItemAdapter(this, pessoas));
    }
}