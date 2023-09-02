package br.com.fiap.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Lancamento {

    private long cdLancamento;
    private double vlLancamento;
    private LocalDateTime dtLancamento;
    private String dsLancamento;
    private Conta conta;
    private TipoLancamento tipoLancamento;
    private Usuario cadastradoPor;

    private List<Lancamento> lancamentos;

    public Lancamento() { this.lancamentos = new ArrayList<>(); }

    public long getCdLancamento() {
        return cdLancamento;
    }

    public void setCdLancamento(long cdLancamento) {
        this.cdLancamento = cdLancamento;
    }

    public double getVlLancamento() {
        return vlLancamento;
    }

    public void setVlLancamento(double vlLancamento) {
        this.vlLancamento = vlLancamento;
    }

    public LocalDateTime getDtLancamento() {
        return dtLancamento;
    }

    public void setDtLancamento(LocalDateTime dtLancamento) {
        this.dtLancamento = dtLancamento;
    }

    public String getDsLancamento() {
        return dsLancamento;
    }

    public void setDsLancamento(String dsLancamento) {
        this.dsLancamento = dsLancamento;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public TipoLancamento getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(TipoLancamento tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public Usuario getCadastradoPor() {
        return cadastradoPor;
    }

    public void setCadastradoPor(Usuario cadastradoPor) {
        this.cadastradoPor = cadastradoPor;
    }

    public void cadastrarLancamento(long cdLancamento, double vlLancamento, LocalDateTime dtLancamento, String dsLancamento, Conta conta, TipoLancamento tipoLancamento, Usuario cadastradoPor) {
        Lancamento lancamento = this;
        lancamento.setCdLancamento(cdLancamento);
        lancamento.setVlLancamento(vlLancamento);
        lancamento.setDtLancamento(dtLancamento);
        lancamento.setDsLancamento(dsLancamento);
        lancamento.setConta(conta);
        lancamento.setTipoLancamento(tipoLancamento);
        lancamento.setCadastradoPor(cadastradoPor);
        this.lancamentos.add(lancamento);
    }

    public void removerLancamento(long cdLancamento) {
        this.lancamentos.removeIf(obj -> obj.cdLancamento == cdLancamento);
    }

    public void editarLancamento(long cdLancamento, double vlLancamento, LocalDateTime dtLancamento, String dsLancamento, Conta conta, TipoLancamento tipoLancamento, Usuario cadastradoPor) {

        Lancamento lancamento = this.lancamentos.stream().filter(obj -> obj.getCdLancamento() == cdLancamento).findFirst().orElse(null);
        if (null != lancamento) {
            lancamento.setVlLancamento(vlLancamento);
            lancamento.setDtLancamento(dtLancamento);
            lancamento.setDsLancamento(dsLancamento);
            lancamento.setConta(conta);
            lancamento.setTipoLancamento(tipoLancamento);
            lancamento.setCadastradoPor(cadastradoPor);
        }
    }

    public Lancamento listarLancamento(long cdLancamento) {
        return this.lancamentos.stream().filter(lancamento -> lancamento.getCdLancamento() == cdLancamento).findFirst().orElse(null);
    }

    public List<Lancamento> listarLancamentos() {
        return this.lancamentos;
    }
}
