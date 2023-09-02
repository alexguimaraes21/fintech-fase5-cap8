package br.com.fiap.entities;

import java.util.ArrayList;
import java.util.List;

public class TipoLancamento {

    private String dsTipoLancamento;

    private List<TipoLancamento> lancamentos;

    public TipoLancamento() { this.lancamentos = new ArrayList<>(); }

    public String getDsTipoLancamento() {
        return dsTipoLancamento;
    }

    public void setDsTipoLancamento(String dsTipoLancamento) {
        this.dsTipoLancamento = dsTipoLancamento;
    }

    public void cadastrarTipoLancamento(String dsTipoLancamento) {
        TipoLancamento tipoLancamento = this;
        tipoLancamento.setDsTipoLancamento(dsTipoLancamento);
        this.lancamentos.add(tipoLancamento);
    }

    public void removerTipoLancamento(String dsTipoLancamento) {
        this.lancamentos.removeIf(obj -> dsTipoLancamento.equals(obj.dsTipoLancamento));
    }

    public void editarTipoLancamento(String dsTipoLancamento) {

        this.lancamentos.stream().filter(obj -> dsTipoLancamento.equals(obj.getDsTipoLancamento())).findFirst().ifPresent(
                tipoLancamento -> tipoLancamento.setDsTipoLancamento(dsTipoLancamento));
    }

    public TipoLancamento listarTipoLancamento(String dsTipoLancamento) {
        return this.lancamentos.stream().filter(usuario -> dsTipoLancamento.equals(usuario.getDsTipoLancamento())).findFirst().orElse(null);
    }

    public List<TipoLancamento> listarTiposLancamento() {
        return this.lancamentos;
    }
}
