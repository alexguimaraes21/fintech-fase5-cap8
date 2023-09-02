package br.com.fiap.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario extends Pessoa {
    private long cdUsuario;
    private String nrCpfUsuario;
    private String dsSenha;
    private String nmUsuario;
    private boolean ckUsuarioAtivo;

    /**
     * Atributo criado apenas para inicializar o Objeto e poder adicionar contas na lista para trabalhar nos testes
     */
    private List<Usuario> usuarios;

    public Usuario() {
        this.ckUsuarioAtivo = true;
        this.usuarios = new ArrayList<>();
    }

    public Long getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(Long cdsuario) {
        this.cdUsuario = cdsuario;
    }

    public String getNrCpfUsuario() {
        return nrCpfUsuario;
    }

    public void setNrCpfUsuario(String nrCpfUsuario) {
        this.nrCpfUsuario = nrCpfUsuario;
    }

    public String getDsSenha() {
        return dsSenha;
    }

    public void setDsSenha(String dsSenha) {
        this.dsSenha = dsSenha;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public boolean isCkUsuarioAtivo() {
        return ckUsuarioAtivo;
    }

    public void setCkUsuarioAtivo(boolean ckUsuarioAtivo) {
        this.ckUsuarioAtivo = ckUsuarioAtivo;
    }

    public void cadastrarUsuario(String nrCpfUsuario, String dsSenha, String nmUsuario, boolean ckUsuarioAtivo, String nmPessoa, String dsEmail, LocalDate dtNascimento) {
        Usuario usuario = this;
        usuario.setNrCpfUsuario(nrCpfUsuario);
        usuario.setDsSenha(dsSenha);
        usuario.setNmUsuario(nmUsuario);
        usuario.setCkUsuarioAtivo(ckUsuarioAtivo);
        usuario.setNmPessoa(nmPessoa);
        usuario.setDsEmail(dsEmail);
        usuario.setDtNascimento(dtNascimento);
        this.usuarios.add(usuario);
    }

    public void removerUsuario(String nrCpfUsuario) {
        this.usuarios.removeIf(obj -> obj.nrCpfUsuario == nrCpfUsuario);
    }

    public void editarUsuario(String nrCpfUsuario, String dsSenha, String nmUsuario, boolean ckUsuarioAtivo, String nmPessoa, String dsEmail, LocalDate dtNascimento) {

        Usuario usuario = this.usuarios.stream().filter(obj -> nrCpfUsuario.equals(obj.getNrCpfUsuario())).findFirst().orElse(null);
        if (null != usuario) {
            usuario.setDsSenha(dsSenha);
            usuario.setNmUsuario(nmUsuario);
            usuario.setCkUsuarioAtivo(ckUsuarioAtivo);
            usuario.setNmPessoa(nmPessoa);
            usuario.setDsEmail(dsEmail);
            usuario.setDtNascimento(dtNascimento);
        }
    }

    public Usuario listarUsuario(String nmUsuario) {
        return this.usuarios.stream().filter(usuario -> nmUsuario.equals(usuario.getNmUsuario())).findFirst().orElse(null);
    }

    public List<Usuario> listarUsuarios() {
        return this.usuarios;
    }
}