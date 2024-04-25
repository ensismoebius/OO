package org.dedira.reciclerviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.dedira.reciclerviews.model.Pessoa;

import java.util.List;

public class ListItemAdapter extends RecyclerView.Adapter<Item> {

    Context context;
    List<Pessoa> listaDePessoas;

    public ListItemAdapter(Context context, List<Pessoa> listaDePessoas) {
        this.context = context;
        this.listaDePessoas = listaDePessoas;
    }

    @NonNull
    @Override
    public Item onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Item(LayoutInflater.from(context).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Item holder, int position) {
        holder.nome.setText(listaDePessoas.get(position).nome);
        holder.sobrenome.setText(listaDePessoas.get(position).sobrenome);
    }

    @Override
    public int getItemCount() {
        return listaDePessoas.size();
    }
}
