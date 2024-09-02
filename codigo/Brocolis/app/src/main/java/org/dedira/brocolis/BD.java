package org.dedira.brocolis;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

import java.util.Map;

public class BD {

    private final FirebaseFirestore firebase;

    public BD() {
        // Inicializa o Firebase
        firebase = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings.Builder carregadorDeConfiguracao = new FirebaseFirestoreSettings.Builder(firebase.getFirestoreSettings());

        FirebaseFirestoreSettings settings = carregadorDeConfiguracao.build();

        firebase.setFirestoreSettings(settings);
    }

    public void salvar(Expressao expressao, Gatilho gatilho) {
        firebase.collection("expressoes")
                .add(expressao)
                .addOnSuccessListener( evento -> {
                    // Se deu certo
                    expressao.id = evento.getId();
                    gatilho.executa(true, expressao);
                }).addOnFailureListener( evento -> {
                    // Se deu errado
                    gatilho.executa(false, expressao);
                });
    }

    public void atualizar(Expressao expressao, Gatilho gatilho, Map<String, Object> campos) {
        firebase.collection("expressoes")
                .document(expressao.id)
                .update(campos)
                .addOnSuccessListener( evento -> {
                    gatilho.executa(false, expressao);
                }).addOnFailureListener( evento -> {
                    gatilho.executa(false, expressao);
                });
    }
}
