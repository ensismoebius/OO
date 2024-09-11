package org.dedira.brocolis;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
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
                .addOnSuccessListener(evento -> {
                    // Se deu certo
                    expressao.id = evento.getId();
                    gatilho.executa(true, expressao);
                }).addOnFailureListener(evento -> {
                    // Se deu errado
                    gatilho.executa(false, expressao);
                });
    }

    public void atualizar(Expressao expressao, Gatilho gatilho, Map<String, Object> campos) {
        firebase.collection("expressoes")
                .document(expressao.id)
                .update(campos)
                .addOnSuccessListener(evento -> {
                    gatilho.executa(true, expressao);
                }).addOnFailureListener(evento -> {
                    gatilho.executa(false, expressao);
                });
    }

    public void carregaTodosOsDocumentos(ArrayList<Expressao> listaDeDocumentos, Gatilho gatilho) {
        firebase.collection("expressoes")
                .get()
                .addOnCompleteListener(evento -> {
                    if (evento.isSuccessful()) {
                        for (QueryDocumentSnapshot objeto : evento.getResult()) {
                            // Converte o objeto para um Documento
                            Expressao d = objeto.toObject(Expressao.class);
                            d.id = objeto.getId();

                            // Adiciona o documento na lista
                            listaDeDocumentos.add(d);
                        }
                        // Executa o gatilho para notificar sucesso
                        gatilho.executa(true, null);
                    } else {
                        // Executa a gatilho para notificar erro
                        gatilho.executa(false, null);
                    }
                });

    }

    public void apagarDocumento(String idDoDocumento, Gatilho gatilho) {
        firebase.collection("expressoes")
                .document(idDoDocumento)
                .delete().addOnSuccessListener(evento -> {
                    gatilho.executa(true, null);
                }).addOnFailureListener(evento -> {
                    gatilho.executa(false, null);
                });
    }
}
