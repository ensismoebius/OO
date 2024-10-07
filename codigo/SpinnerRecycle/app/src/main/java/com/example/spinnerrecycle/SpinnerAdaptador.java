package com.example.spinnerrecycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SpinnerAdaptador extends BaseAdapter {

    private List<Comida> lista;
    private Context contexto;

    public SpinnerAdaptador(Context contexto, List<Comida> lista) {
        this.contexto = contexto;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return this.lista.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = LayoutInflater.from(contexto).inflate(R.layout.spinner_item, viewGroup, false);

        TextView txtSpnNome = itemView.findViewById(R.id.txtSpnNome);
        ImageView imgSpnImagem = itemView.findViewById(R.id.imgSpnImagem);

        txtSpnNome.setText(lista.get(i).nome);
        imgSpnImagem.setImageBitmap(lista.get(i).imagem);

        return  itemView;
    }
}
