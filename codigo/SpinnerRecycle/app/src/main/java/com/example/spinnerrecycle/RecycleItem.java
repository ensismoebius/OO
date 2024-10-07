package com.example.spinnerrecycle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleItem extends RecyclerView.ViewHolder {

    public ImageView imgRclImagem;
    public TextView txtRclNome;
    public Button btnRclSalvar;

    public RecycleItem(@NonNull View itemView) {
        super(itemView);

        txtRclNome = itemView.findViewById(R.id.txtRclNome);
        imgRclImagem = itemView.findViewById(R.id.imgRclImagem);
        btnRclSalvar = itemView.findViewById(R.id.btnRclSalvar);
    }
}
