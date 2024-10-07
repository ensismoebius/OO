package com.example.spinnerrecycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdaptador extends RecyclerView.Adapter {

    private final Context contexto;
    private final List<Comida> lista;
    private ExecutarAoClicar executarAoClicar;

    public interface ExecutarAoClicar {
        void aoClicar(Comida comida);
    }

    public RecycleAdaptador(Context contexto, List<Comida> lista, ExecutarAoClicar executarAoClicar) {
        this.executarAoClicar = executarAoClicar;
        this.contexto = contexto;
        this.lista = lista;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecycleItem(LayoutInflater.from(contexto).inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RecycleItem i = (RecycleItem) holder;

        i.txtRclNome.setText(lista.get(position).nome);
        i.imgRclImagem.setImageBitmap(lista.get(position).imagem);

        i.btnRclSalvar.setOnClickListener(v -> {
            executarAoClicar.aoClicar(lista.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
