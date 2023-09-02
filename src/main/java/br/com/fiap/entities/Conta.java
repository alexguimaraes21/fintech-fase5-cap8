package br.com.fiap.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Conta {
    private String nrAgencia;
    private String nrConta;
    private String nrBanco;

    /**
     * Atributo criado apenas para inicializar o Objeto e poder adicionar contas na lista para trabalhar nos testes
     */
    private List<Conta> contas;

    public String getNrAgencia() {
        return nrAgencia;
    }

    public void setNrAgencia(String nrAgencia) {
        this.nrAgencia = nrAgencia;
    }

    public String getNrConta() {
        return nrConta;
    }

    public void setNrConta(String nrConta) {
        this.nrConta = nrConta;
    }

    public String getNrBanco() {
        return nrBanco;
    }

    public void setNrBanco(String nrBanco) {
        this.nrBanco = nrBanco;
    }

    public Conta() {
        this.contas = new ArrayList<>();
    }

    public void cadastrarConta(String nrAgencia, String nrConta, String nrBanco) {
        Conta conta = this;
        conta.setNrAgencia(nrAgencia);
        conta.setNrConta(nrConta);
        conta.setNrBanco(nrBanco);
        this.contas.add(conta);
    }

    public void removerConta(String nrConta) {
        this.contas.removeIf(obj -> nrConta.equals(obj.nrConta));
    }

    public Conta listarConta(String nrConta) {
        return this.contas.stream().filter(conta -> nrConta.equals(conta.getNrConta())).findFirst().orElse(null);
    }

    public List<Conta> listarContas() {
        return this.contas;
    }
}
