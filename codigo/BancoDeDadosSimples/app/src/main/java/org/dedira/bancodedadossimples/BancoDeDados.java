package org.dedira.bancodedadossimples;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BancoDeDados {
    private final FirebaseFirestore instanciaDoFirebase;

    public BancoDeDados() {
        instanciaDoFirebase = FirebaseFirestore.getInstance();

        FirebaseFirestoreSettings.Builder carregadorDeConfiguracao = new FirebaseFirestoreSettings.Builder(instanciaDoFirebase.getFirestoreSettings());

        FirebaseFirestoreSettings settings = carregadorDeConfiguracao.build();

        instanciaDoFirebase.setFirestoreSettings(settings);
    }

    /**
     * Apaga um documento dada uma identificação de documento
     *
     * @param idDoDocumento
     * @param listener
     */
    public void apagarDocumento(String idDoDocumento, IMonitoradorDoBancoDeDados<Documento> listener) {

        instanciaDoFirebase.collection("Documentos") // Seleciona a coleção
                .document(idDoDocumento) // Seleciona o documento
                .delete() // Manda apagar o documento
                .addOnSuccessListener(
                        // Se apagou cai aqui
                        v -> listener.onLoadComplete(true, null)).addOnFailureListener(
                        // Se não apagou cai aqui
                        v -> listener.onLoadComplete(false, null));
    }

    /**
     * Atualiza os campos de um documento dada uma identificação de documento
     *
     * @param idDoDocumento
     * @param listaDeCamposParaAtualizar
     * @param listener
     */
    public void atualizaDocumento(String idDoDocumento, Map<String, Object> listaDeCamposParaAtualizar, IMonitoradorDoBancoDeDados<Documento> listener) {
        instanciaDoFirebase.collection("Documentos")// Seleciona a coleção
                .document(idDoDocumento) // Seleciona o documento
                .update(listaDeCamposParaAtualizar)// Atualiza os campos do documento
                .addOnSuccessListener(
                        // Cai aqui se atualizou
                        v -> listener.onLoadComplete(true, null)).addOnFailureListener(
                        // Cai aqui se não atualizou
                        v -> listener.onLoadComplete(false, null));
    }

    /**
     * Carrega todos os documentos de uma coleção
     *
     * @param listaDeDocumentos
     * @param listener
     */
    public void carregaTodosOsDocumentos(ArrayList<Documento> listaDeDocumentos, IMonitoradorDoBancoDeDados<Documento> listener) {
        instanciaDoFirebase.collection("Documentos")// Seleciona a coleção
                .get() // Recupera todos os documentos
                .addOnCompleteListener(solicitacao -> {

                    // Se conseguiu carregar todos então preenche a lista
                    if (solicitacao.isSuccessful()) {

                        // Preenche a lista
                        for (QueryDocumentSnapshot document : solicitacao.getResult()) {
                            Documento d = document.toObject(Documento.class);
                            d.id = document.getId();
                            listaDeDocumentos.add(d);
                        }

                        // Cai aqui se der tudo certo
                        listener.onLoadComplete(true, null);
                    } else {

                        // Cai aqui se der problema
                        listener.onLoadComplete(false, null);
                    }
                });
    }

    /**
     * Salva ou atualiza um documento
     *
     * @param d
     * @param listener
     */
    public void salvaDocumento(Documento d, IMonitoradorDoBancoDeDados<Documento> listener) {

        // Se for um novo documento adiciona ele na base
        if (d.id == null) {
            // Salva um novo estudante
            instanciaDoFirebase
                    .collection("Documentos")
                    .add(d);
        } else {

            // Atualiza o documento
            Map<String, Object> campos = new HashMap<>();
            campos.put("nome", d.nome);
            campos.put("idade", d.idade);

            // Chama o método que atualiza o documento
            atualizaDocumento(d.id, campos, listener);
        }
    }

    /**
     * Carrega um documento dado uma identificação de documento
     *
     * @param idDoDocumento
     * @param listener
     */
    public void carregaDocumento(String idDoDocumento, IMonitoradorDoBancoDeDados<Documento> listener) {

        // Cria a objeto que carregará o documento
        DocumentReference referenciaAoDcoumento;

        // Solicita o carregamento do documento
        try {
            referenciaAoDcoumento = instanciaDoFirebase.collection("Documentos").document(idDoDocumento);
        } catch (Exception e) {
            listener.onLoadComplete(false, null);
            return;
        }

        // Quando o documento é carregado...
        referenciaAoDcoumento.get().addOnCompleteListener(solicitacao -> {

                    if (solicitacao.getResult().toObject(Documento.class) == null) {
                        // Se der falha no carregamento cai aqui
                        listener.onLoadComplete(false, null);
                        return;
                    }

                    // Grava o documento no objeto
                    Documento d = solicitacao.getResult().toObject(Documento.class);

                    if (d == null) {
                        // Se o documento for nulo cai aqui
                        listener.onLoadComplete(true, null);
                        return;
                    }

                    // Informa o id do documento
                    d.id = referenciaAoDcoumento.getId();
                    // Se tudo der certo cai aqui
                    listener.onLoadComplete(true, d);
                })
                .addOnFailureListener(
                        // Se falhar cai aqui
                        tarefa -> listener.onLoadComplete(false, null)
                );
    }
}
