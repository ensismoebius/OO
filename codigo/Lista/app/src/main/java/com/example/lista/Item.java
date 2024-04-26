package com.example.lista;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class Item extends RecyclerView.ViewHolder {

    public TextView nome;
    public TextView sobrenome;
    public TextView ano;

    public Item(View item) {
        super(item);

        nome = item.findViewById(R.id.txtNome);
        sobrenome = item.findViewById(R.id.txtSobrenome);
        ano = item.findViewById(R.id.txtAno);

    }
}
