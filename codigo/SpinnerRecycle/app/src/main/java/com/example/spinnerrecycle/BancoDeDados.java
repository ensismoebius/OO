package com.example.spinnerrecycle;

import android.content.Context;
import android.graphics.BitmapFactory;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

    @NonNull
    public static List<Comida> carregaListaDeComidas(Context context) {
        List<Comida> lista = new ArrayList<>();

        Comida Avocado = new Comida();
        Avocado.nome = "Abacate";
        Avocado.imagem = BitmapFactory.decodeResource(context.getResources(), R.drawable.abacate);
        lista.add(Avocado);

        Comida Banana = new Comida();
        Banana.nome = "Banana";
        Banana.imagem = BitmapFactory.decodeResource(context.getResources(), R.drawable.banana);
        lista.add(Banana);

        Comida Coconut = new Comida();
        Coconut.nome = "Côco";
        Coconut.imagem = BitmapFactory.decodeResource(context.getResources(), R.drawable.coco);
        lista.add(Coconut);

        Comida Guava = new Comida();
        Guava.nome = "Goiaba";
        Guava.imagem = BitmapFactory.decodeResource(context.getResources(), R.drawable.goiaba);
        lista.add(Guava);

        Comida Lemon = new Comida();
        Lemon.nome = "Limão";
        Lemon.imagem = BitmapFactory.decodeResource(context.getResources(), R.drawable.limao);
        lista.add(Lemon);

        Comida Mango = new Comida();
        Mango.nome = "Manga";
        Mango.imagem = BitmapFactory.decodeResource(context.getResources(), R.drawable.manga);
        lista.add(Mango);

        Comida Orange = new Comida();
        Orange.nome = "Laranja";
        Orange.imagem = BitmapFactory.decodeResource(context.getResources(), R.drawable.laranja);
        lista.add(Orange);

        return lista;
    }

}
