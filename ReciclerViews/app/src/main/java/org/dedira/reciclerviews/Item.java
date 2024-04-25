package org.dedira.reciclerviews;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Item extends RecyclerView.ViewHolder {

    TextView nome;
    TextView sobrenome;
    Button apagar;

    public Item(@NonNull View itemView) {
        super(itemView);
        nome = itemView.findViewById(R.id.txtNomeItem);
        apagar = itemView.findViewById(R.id.btnApagarItem);
        sobrenome = itemView.findViewById(R.id.txtSobrenomeItem);
    }
}
