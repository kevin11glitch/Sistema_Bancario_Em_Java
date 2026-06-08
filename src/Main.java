import java.util.Scanner;
import Classes.CadastroConta;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner recebe = new Scanner(System.in);

        int opcao;
        System.out.println("Seja bem-vindo(a) ao Sistema Bancário INOUT!");
        List<CadastroConta> usuarios = new ArrayList<>();

        do {
            System.out.println("Escolha uma opção abaixo: ");
            System.out.println("    1 - Criar Conta");
            System.out.println("    2 - Depositar");
            System.out.println("    3 - Sacar");
            System.out.println("    4 - Consultar Saldo");
            System.out.println("    5 - Sair");

            opcao = recebe.nextInt();
            recebe.nextLine();

            switch (opcao){
                case 1:
                    System.out.println("Informe seu nome: ");
                    String nome = recebe.nextLine();

                    System.out.println("Defina um numero para a conta: ");
                    int numero_conta = recebe.nextInt();
                    recebe.nextLine();

                    System.out.println("Informe o saldo inicial: ");
                    double saldo = recebe.nextDouble();
                    recebe.nextLine();

                    CadastroConta novaConta = new CadastroConta(numero_conta, nome, saldo);
                    usuarios.add(novaConta);
                    System.out.printf("Sua conta foi criada com sucesso, %s\n\n", nome);
                    break;

                case 2:
                    System.out.println("Informe o numero da sua conta: ");
                    int contaDeposito = recebe.nextInt();
                    recebe.nextLine();

                    System.out.println("Especifique a quantia que deseja depositar: ");
                    double valorDeposito = recebe.nextDouble();
                    recebe.nextLine();

                    if (valorDeposito <= 0) {
                        System.out.println("O valor deve ser maior que zero!\n");
                        break;
                    }

                    boolean contaEncontrada = false;
                    for (CadastroConta conta : usuarios) {
                        if (conta.getNumero_conta() == contaDeposito) {
                            conta.depositar(valorDeposito);

                            System.out.printf("Depósito de R$ %.2f realizado com sucesso!\n", valorDeposito);
                            System.out.printf("Novo saldo da conta %d: R$ %.2f\n\n", conta.getNumero_conta(), conta.getSaldo());
                            contaEncontrada = true;
                            break;
                        }
                    }

                    if (!contaEncontrada){
                        System.out.println("Conta não encontrada! Informe um número de conta válido.\n");
                    }
                    break;

                case 3:
                    System.out.println("Informe o numero da sua conta: ");
                    int sacar = recebe.nextInt();
                    recebe.nextLine();

                    System.out.println("Informe a quantia que deseja resgatar: ");
                    double quantiaSaque = recebe.nextDouble();
                    recebe.nextLine();

                    if (quantiaSaque <= 0) {
                        System.out.println("O valor deve ser maior que zero!\n");
                        break;
                    }

                    boolean contaEncontrada2 = false;
                    for(CadastroConta conta : usuarios){
                        if(conta.getNumero_conta() == sacar){
                            if (conta.sacar(quantiaSaque)) {
                                System.out.printf("Saque no valor de R$ %.2f realizado com sucesso!\n", quantiaSaque);
                                System.out.printf("Novo saldo da conta %d: R$ %.2f\n\n", conta.getNumero_conta(), conta.getSaldo());
                            } else {
                                System.out.println("Saldo insuficiente para realizar esta operação!\n");
                            }
                            contaEncontrada2 = true;
                            break;
                        }
                    }

                    if (!contaEncontrada2){
                        System.out.println("Conta não encontrada! Informe um número de conta válido.\n");
                    }
                    break;

                case 4:
                    System.out.println("Informe o numero da sua conta: ");
                    int consultarSaldo = recebe.nextInt();
                    recebe.nextLine();

                    boolean contaEncontrada3 = false;
                    for (CadastroConta conta : usuarios) {
                        if (conta.getNumero_conta() == consultarSaldo){
                            System.out.printf("%s, seu saldo atual é de R$ %.2f\n\n", conta.getNome_titular(), conta.getSaldo());
                            contaEncontrada3 = true;
                            break;
                        }
                    }

                    if (!contaEncontrada3){
                        System.out.println("Conta não encontrada! Informe um número de conta válido.\n");
                    }
                    break;

                case 5:
                    System.out.println("Obrigado por utilizar o Sistema Bancário INOUT! Até logo.");
                    break;

                default:
                    System.out.println("Digite uma opção válida (1, 2, 3, 4 ou 5):\n");
                    break;
            }

        } while (opcao != 5);
    }
}