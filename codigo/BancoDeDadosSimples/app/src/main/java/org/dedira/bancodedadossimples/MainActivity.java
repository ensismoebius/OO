package org.dedira.bancodedadossimples;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BancoDeDados bd = new BancoDeDados();

        Documento d = new Documento();
        d.nome = "Uga";
        d.idade = 1000;


        bd.salvaDocumento(d, (operacaoRealizadaComSucesso, documento) -> {
            if (operacaoRealizadaComSucesso) {
                // Faz alguma pra avisar que deu bom
            } else {
                // Avisa que deu problema
            }
        });

        Map<String, Object> campos = new HashMap<>();
        campos.put("nome", "Iga");
        campos.put("idade", 2000);

        bd.atualizaDocumento(d.id, campos, (operacaoRealizadaComSucesso, documento) -> {
            if (operacaoRealizadaComSucesso) {
                // Faz alguma pra avisar que deu bom
            } else {
                // Avisa que deu problema
            }
        });


        bd.apagarDocumento(d.id, (operacaoRealizadaComSucesso, documento) -> {
            if (operacaoRealizadaComSucesso) {
                // Faz alguma pra avisar que deu bom
            } else {
                // Avisa que deu problema
            }
        });
    }
}