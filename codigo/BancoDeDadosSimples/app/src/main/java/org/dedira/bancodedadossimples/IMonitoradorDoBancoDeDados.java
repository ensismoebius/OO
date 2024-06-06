package org.dedira.bancodedadossimples;

public interface IMonitoradorDoBancoDeDados<TipoDeDocumentoQueVaiSerUsado> {
    void onLoadComplete(boolean operacaoRealizadaComSucesso, TipoDeDocumentoQueVaiSerUsado documento);
}
