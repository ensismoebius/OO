package org.dedira.brocolis;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

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
                    gatilho.executa(true);
                }).addOnFailureListener( evento -> {
                    // Se deu errado
                    gatilho.executa(false);
                });
    }
}
