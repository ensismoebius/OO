package org.dedira.brocolis;

import android.app.Activity;
import android.widget.Toast;

public class GatilhoGrafico implements Gatilho {

    private final Activity referenciaParaUmaAtividade;

    public GatilhoGrafico(Activity atividade) {
        this.referenciaParaUmaAtividade = atividade;
    }

    @Override
    public void executa(boolean sucesso, Expressao expressao) {
        if (sucesso) {
            Toast.makeText(
                    referenciaParaUmaAtividade,
                    "Sucesso! id: " + expressao.id,
                    Toast.LENGTH_SHORT
            ).show();
        } else {
            Toast.makeText(
                    referenciaParaUmaAtividade,
                    "Erro",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}
