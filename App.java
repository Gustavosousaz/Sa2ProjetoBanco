package Sa2ProjetoBanco;

import javax.swing.JOptionPane;
import Sa2ProjetoBanco.Conta.Conta;
import Sa2ProjetoBanco.Conta.ContaPF;
import Sa2ProjetoBanco.Conta.ContaPJ;

public class App {

    public static void main(String[] args) {
        // criar os vetores de objetos
        ContaPF contasPf[] = new ContaPF[10];
        ContaPJ contasPj[] = new ContaPJ[10];
        // criar a aplicação do banco
        boolean aberta = true;
        int PF = 0;
        int PJ = 0;
        int contaAtual = 0;
        while (aberta) {
            int acao = Integer.parseInt(JOptionPane.showInputDialog(
                    "Escolha a ação desejada:"
                            + "\n1- CRIAR CONTA PF"
                            + "\n2- CRIAR CONTA PJ"
                            + "\n3- ENTRAR CONTA PF"
                            + "\n4- ENTRAR CONTA PJ "
                            + "\n5- SAIR"));

            if (acao == 1) {
                // Criar conta PF
                contasPf[PF] = new ContaPF(); // objeto criado
                // preencher as informações da conta
                contasPf[PF].setNome(JOptionPane.showInputDialog("INFORME O NOME"));
                contasPf[PF].setnCpf(JOptionPane.showInputDialog("INFORME Cpf"));
                contasPf[PF].setSaldo(1000);
                contasPf[PF].setnConta(1000 + PF);
                JOptionPane.showMessageDialog(null,
                        " CONTA PF CRIADA COM SUCESSO " + "\n CLIENTE: " + contasPf[PF].getNome() + "\n CONTA: "
                                + contasPf[PF].getnConta() + "\n Cpf: " + contasPf[PF].getnCpf());
                PF++;

            } else if (acao == 2) {
                // Criar conta PJ
                contasPj[PJ] = new ContaPJ(); // objeto criado
                // preencher as informações da conta
                contasPj[PJ].setNome(JOptionPane.showInputDialog("INFORME O NOME"));
                contasPj[PJ].setnCnpj(JOptionPane.showInputDialog("INFORME CNPJ"));
                contasPj[PJ].setSaldo(4000);
                contasPj[PJ].setnConta(2000 + PJ);
                JOptionPane.showMessageDialog(null,
                        " CONTA PJ  CRIADA COM SUCESSO " + "\n CLIENTE: " + contasPj[PJ].getNome()
                                + "\n CONTA: " + contasPj[PJ].getnConta() + "\n CNPJ: "
                                + contasPj[PJ].getnCnpj());
                PJ++;

            } else if (acao == 3) {
                // // BUSCAR A CONTA JÁ CRIADA DA PF
                int nContaBusca = Integer.parseInt(JOptionPane.showInputDialog("Informe o nº da conta buscada:"));
                if (nContaBusca - 1000 >= 0 && nContaBusca - 1000 <= PF - 1) {
                    for (int i = 0; i < contasPf.length; i++) {
                        // busca pelo nº da conta
                        if (nContaBusca == contasPf[i].getnConta()) {
                            contaAtual = i;
                            JOptionPane.showMessageDialog(null, "Conta Encontrada");

                            boolean acessar = true;
                            while (acessar) {
                                int acao2 = Integer
                                        .parseInt(JOptionPane.showInputDialog("\n CONTA FÍSICA " + "\n CLIENTE: "
                                                + contasPf[contaAtual].getNome() + "\n CONTA: "
                                                + contasPf[contaAtual].getnConta()
                                                + "\n CPF: " + contasPf[contaAtual].getnCpf() + "\n AÇÃO DESEJADA:"
                                                + "\n1- VERIFICAR SALDO ATUAL"
                                                + "\n2- EFETUE UM SAQUE"
                                                + "\n3- FAÇA UM DEPÓSITO"
                                                + "\n4- FAÇA UM EMPRÉSTIMO"
                                                + "\n5- SAIR"));

                                if (acao2 == 1) {
                                    // jop
                                    JOptionPane.showMessageDialog(null,
                                            " SEU SALDO É DE " + contasPf[contaAtual].getSaldo());
                                } else if (acao2 == 2) {
                                    contasPf[contaAtual].saque();
                                } else if (acao2 == 3) {
                                    contasPf[contaAtual].deposito();
                                } else if (acao2 == 4) {
                                    contasPf[contaAtual].emprestimo();
                                } else {
                                    acessar = false;
                                }
                            }

                            break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Conta não encontrada");
                }
            } else if (acao == 4) { // BUSCAR A CONTA JÁ CRIADA DA PJ
                int nContaBusca = Integer.parseInt(JOptionPane.showInputDialog("Informe o nº da conta buscada:"));
                if (nContaBusca - 2000 >= 0 && nContaBusca - 2000 <= PJ - 1) {
                    for (int i = 0; i < contasPj.length; i++) {
                        // busca pelo nº da conta
                        if (nContaBusca == contasPj[i].getnConta()) {
                            contaAtual = i;
                            JOptionPane.showMessageDialog(null, "Conta Encontrada");

                            boolean acessar = true;
                            while (acessar) {
                                int acao2 = Integer
                                        .parseInt(JOptionPane.showInputDialog("\n CONTA JURÍDICA " + "\n CLIENTE: "
                                                + contasPj[contaAtual].getNome() + "\n CONTA: "
                                                + contasPj[contaAtual].getnConta()
                                                + "\n CNPJ: " + contasPj[contaAtual].getnCnpj() + "\n AÇÃO DESEJADA:"
                                                + "\n 1- verificar saldo"
                                                + "\n 2- Saque"
                                                + "\n 3- Depósito"
                                                + "\n 4- Empréstimo"
                                                + "\n 5- Sair"));

                                if (acao2 == 1) {
                                    JOptionPane.showMessageDialog(null,
                                            "SEU SALDO É DE " + contasPj[contaAtual].getSaldo());
                                } else if (acao2 == 2) {
                                    contasPj[contaAtual].saque();
                                } else if (acao2 == 3) {
                                    contasPj[contaAtual].deposito();
                                } else if (acao2 == 4) {
                                    contasPj[contaAtual].emprestimo();
                                } else {
                                    acessar = false;
                                }

                            }

                            break;
                        }

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Conta não existe");
                }

            }
        }

    }
}
