package br.com.fiap;

import br.com.fiap.entities.Conta;
import br.com.fiap.entities.Lancamento;
import br.com.fiap.entities.TipoLancamento;
import br.com.fiap.entities.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Fintech {
    public static void main(String[] args) {

        /*
         * TRABALHANDO COM A CLASSE CONTA
         */
        Conta contaUsuario = new Conta();
        int x = 0;

        System.out.println("Cadastrando contas para utilizar durante os testes");
        contaUsuario.cadastrarConta("0482","00033245-8","033");

        System.out.println("## Listando todas as contas cadastradas para o usuário ##");
        for (Conta conta : contaUsuario.listarContas()) {
            System.out.println("Conta " + x);
            System.out.println("   Agencia: " + conta.getNrAgencia());
            System.out.println("   Conta: " + conta.getNrConta());
            System.out.println("   Agencia: " + conta.getNrBanco());
            x++;
        }

        System.out.println("## Listando os detalhes apenas da Conta 00033245-8 ##");
        Optional<Conta> contaCadastrada = Optional.ofNullable(contaUsuario.listarConta("00033245-8"));
        if (contaCadastrada.isPresent()) {
            System.out.println("   Agencia: " + contaCadastrada.get().getNrAgencia());
            System.out.println("   Conta: " + contaCadastrada.get().getNrConta());
            System.out.println("   Agencia: " + contaCadastrada.get().getNrBanco());
        } else {
            System.out.println("## Conta 00033245-8 Não encontrada ##");
        }

        System.out.println("## Removendo a Conta 00033245-8 ##");
        contaUsuario.removerConta("00033245-8");

        System.out.println("## Verificando se a Conta 00033245-8 foi removida ##");
        contaCadastrada = Optional.ofNullable(contaUsuario.listarConta("00033245-8"));
        if (contaCadastrada.isPresent()) {
            System.out.println("## Conta não removida ##");
        } else {
            System.out.println("## Conta 00033245-8 Removida com sucesso ##");
        }

        // Criando nova conta para utilizá-la nos testes finais
        Conta novaConta = new Conta();
        novaConta.cadastrarConta("0345","00067254-1","146");

        System.out.println("\n\n");

        /*
         * TRABALHANDO COM A CLASSE USUARIO
         */
        Usuario usuarioTeste = new Usuario();
        x = 0;

        System.out.println("Cadastrando usuário para utilizar durante os testes");
        usuarioTeste.cadastrarUsuario("10874684005",
                "senha123",
                "usuario-teste-1",
                true,
                "Usuario Teste 1",
                "usuario.teste@gmail.com",
                LocalDate.of(1990,05,13));

        System.out.println("## Listando todos os usuarios cadastrados ##");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/uuuu");
        for (Usuario usuario : usuarioTeste.listarUsuarios()) {
            System.out.println("Usuario " + x);
            System.out.println("   CPF: " + usuario.getNrCpfUsuario());
            System.out.println("   Login: " + usuario.getNmUsuario());
            System.out.println("   Usuário ativo: " + usuario.isCkUsuarioAtivo());
            System.out.println("   Nome do usuário: " + usuario.getNmPessoa());
            System.out.println("   E-mail: " + usuario.getDsEmail());
            System.out.println("   Data de Nascimento: " + usuario.getDtNascimento().format(formatter));
            x++;
        }

        System.out.println("## Listando os detalhes apenas do Usuário Teste 1 ##");
        Optional<Usuario> usuarioCadastrado = Optional.ofNullable(usuarioTeste.listarUsuario("usuario-teste-1"));
        if (usuarioCadastrado.isPresent()) {
            System.out.println("   CPF: " + usuarioCadastrado.get().getNrCpfUsuario());
            System.out.println("   Login: " + usuarioCadastrado.get().getNmUsuario());
            System.out.println("   Usuário ativo: " + usuarioCadastrado.get().isCkUsuarioAtivo());
            System.out.println("   Nome do usuário: " + usuarioCadastrado.get().getNmPessoa());
            System.out.println("   E-mail: " + usuarioCadastrado.get().getDsEmail());
            System.out.println("   Data de Nascimento: " + usuarioCadastrado.get().getDtNascimento().format(formatter));
        } else {
            System.out.println("## Usuario [ usuario-teste-1 ] não encontrado  ##");
        }

        System.out.println("## Removendo o Usuário [ usuario-teste-1 ] ##");
        usuarioTeste.removerUsuario("usuario-teste-1");

        System.out.println("## Verificando se o usuário [ usuario-teste-1 ] foi removido ##");
        usuarioCadastrado = Optional.ofNullable(usuarioTeste.listarUsuario("usuario-teste-1"));
        if (contaCadastrada.isPresent()) {
            System.out.println("## Usuário não removido ##");
        } else {
            System.out.println("## Usuário [ usuario-teste-1 ] Removido com sucesso ##");
        }

        // Criando novo usuário para utilizá-lo nos testes finais
        Usuario novoUsuario = new Usuario();
        novoUsuario.cadastrarUsuario("70741392038",
                "novaSenha456",
                "teste-criacao-usuario",
                true,
                "Teste Criação de Usuário",
                "usuario.novo.teste@gmail.com",
                LocalDate.of(1987,2,28));
        System.out.println("\n\n");


        /*
         * TRABALHANDO COM A CLASSE TIPOLANCAMENTO
         */
        TipoLancamento tipoLancamento = new TipoLancamento();
        x = 0;

        System.out.println("Cadastrando TipoLancamento para utilizar durante os testes");
        tipoLancamento.cadastrarTipoLancamento("DEBITO");

        System.out.println("## Listando todos os TipoLancamento cadastrados ##");
        for (TipoLancamento tipoLancamento1 : tipoLancamento.listarTiposLancamento()) {
            System.out.println("TipoLancamento " + x);
            System.out.println("   Título: " + tipoLancamento1.getDsTipoLancamento());
            x++;
        }

        System.out.println("## Listando os detalhes apenas do TipoLancamento DEBITO ##");
        Optional<TipoLancamento> tipoLancamentoCadastrado = Optional.ofNullable(tipoLancamento.listarTipoLancamento("DEBITO"));
        if (tipoLancamentoCadastrado.isPresent()) {
            System.out.println("   Título: " + tipoLancamentoCadastrado.get().getDsTipoLancamento());
        } else {
            System.out.println("## TipoLancamento [ DEBITO ] não encontrado  ##");
        }

        System.out.println("## Removendo o TipoLancamento [ DEBITO ] ##");
        tipoLancamento.removerTipoLancamento("DEBITO");

        System.out.println("## Verificando se o TipoLancamento [ DEBITO ] foi removido ##");
        tipoLancamentoCadastrado = Optional.ofNullable(tipoLancamento.listarTipoLancamento("DEBITO"));
        if (tipoLancamentoCadastrado.isPresent()) {
            System.out.println("## TipoLancamento não removido ##");
        } else {
            System.out.println("## TipoLancamento [ DEBITO ] Removido com sucesso ##");
        }

        // Criando novo usuário para utilizá-lo nos testes finais
        TipoLancamento novoTipoLancamento = new TipoLancamento();
        novoTipoLancamento.cadastrarTipoLancamento("DEBITO");
        System.out.println("\n\n");


        /*
         * TRABALHANDO COM A CLASSE LANCAMENTO
         */
        Lancamento lancamento = new Lancamento();
        x = 0;

        System.out.println("Cadastrando Lancamento para utilizar durante os testes");

        lancamento.cadastrarLancamento(1,
                60.38,
                LocalDateTime.of(2023,9,02,12,57,33),
                "Conta de Luz",
                novaConta,
                novoTipoLancamento,
                novoUsuario);

        System.out.println("## Listando todos os Lancamento cadastrados ##");
        for (Lancamento lancamento1 : lancamento.listarLancamentos()) {
            System.out.println("Lancamento " + x);
            System.out.println("   Código: " + lancamento1.getCdLancamento());
            System.out.println("   Descrição: " + lancamento1.getDsLancamento());
            System.out.println("   Valor: " + lancamento1.getVlLancamento());
            System.out.println("   Conta: " + lancamento1.getConta().getNrConta());
            System.out.println("   Tipo de Lancamento: " + lancamento1.getTipoLancamento().getDsTipoLancamento());
            System.out.println("   Usuário responsável pela informação: " + lancamento1.getCadastradoPor().getNmPessoa());
            x++;
        }

        System.out.println("## Listando os detalhes apenas do Lancamento com Código [ 1 ] ##");
        Optional<Lancamento> lancamentoCadastrado = Optional.ofNullable(lancamento.listarLancamento(1));
        if (lancamentoCadastrado.isPresent()) {
            System.out.println("   Código: " + lancamentoCadastrado.get().getCdLancamento());
            System.out.println("   Descrição: " + lancamentoCadastrado.get().getDsLancamento());
            System.out.println("   Valor: " + lancamentoCadastrado.get().getVlLancamento());
            System.out.println("   Conta: " + lancamentoCadastrado.get().getConta().getNrConta());
            System.out.println("   Tipo de Lancamento: " + lancamentoCadastrado.get().getTipoLancamento().getDsTipoLancamento());
            System.out.println("   Usuário responsável pela informação: " + lancamentoCadastrado.get().getCadastradoPor().getNmPessoa());
        } else {
            System.out.println("## Lancamento [ 1 ] não encontrado  ##");
        }

        System.out.println("## Removendo o Lancamento [ 1 ] ##");
        lancamento.removerLancamento(1);

        System.out.println("## Verificando se o Lancamento [ 1 ] foi removido ##");
        lancamentoCadastrado = Optional.ofNullable(lancamento.listarLancamento(1));
        if (lancamentoCadastrado.isPresent()) {
            System.out.println("## Lancamento não removido ##");
        } else {
            System.out.println("## Lancamento [ 1 ] Removido com sucesso ##");
        }
    }
}