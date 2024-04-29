package com.example.lista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter {
    private final Context contexto;
    private List<Pessoa> lista;

    public Adaptador(List<Pessoa> lista, Context contexto) {
        this.lista = lista;
        this.contexto = contexto;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Item(LayoutInflater.from(contexto).inflate(R.layout.item_da_lista, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item i = (Item) holder;

        i.nome.setText(lista.get(position).nome);
    }

    @Override
    public int getItemCount() {
        return this.lista.size();
    }
}
