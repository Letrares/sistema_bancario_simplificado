

import java.util.Scanner;

public class TrabalhoGrauA {
    static boolean ContaAberta = false;
    static double saldo = 0.0;
    static double saldoInicial= 0.0;
    static int qtdDep = 0;
    static int qtdSaq = 0;
    static double deposito = 0.0;
    static double depTot = 0.0;
    static int saqTot = 0;
    static double jurosTot = 0.0;
    static double saldoMin = 0.0;
    static double saldoMax = 0.0;
    static String nome = "";

public static void atualizacao() {

    if (saldo < saldoMin) {
        saldoMin = saldo;
    }
    if (saldo > saldoMax){
        saldoMax = saldo;
    }

    
}      
    public static int menu(Scanner scanner) {
           
                System.out.print("\033\143");
        
             
                System.out.println("\n..:: Sistema Bancário Simplificado ::..\n");
                System.out.println("1 - Abrir conta");
                System.out.println("2 - Realizar depósito");
                System.out.println("3 - Realizar saque");
                System.out.println("4 - Aplicar Juros");
                System.out.println("5 - Simular Empréstimos");
                System.out.println("6 - Extrato");
                System.out.println("7 - Integrantes");
                System.out.println("8 - Sair\n");
        
                System.out.print("Escolha uma opção: ");
                int item = scanner.nextInt();
                scanner.nextLine();
                return item;
            }

    
    public static void opcao_1() {
        System.out.println("\nOpção escolhida: Abrir conta.\n");
        Scanner scanner = new Scanner(System.in);

        
        
        if(ContaAberta){
        System.out.println("\nSua conta já foi aberta! \n");
          return;}
        
        System.out.println("Informe seu nome: ");
        nome = scanner.nextLine();
        
        System.out.print("Digite o seu saldo: ");
        saldoInicial = scanner.nextDouble();
        saldo = saldoInicial;
        saldoMin = saldoInicial;
        saldoMax = saldoInicial;
        atualizacao();
        ContaAberta = true;
        System.out.println("\nSua conta foi aberta!\n");
        System.out.printf("\nNome: %s. Saldo: R$ %.2f\n\n", nome,saldo);
    }

    public static void opcao_2() {
        System.out.println("\nOpção escolhida: Realizar depósito.\n");
        Scanner scanner = new Scanner(System.in);
    

        if(!ContaAberta){
            System.out.println("Impossível realizar depósito! É necessário abrir uma conta!");
            return;
        }
    
        while(true){
            System.err.print("Informe o valor do depósito: ");
            deposito = scanner.nextDouble();
            
            if (deposito > 0){
                break;
            }
        }

    saldo += deposito;
    ++qtdDep;
    depTot += deposito;
    
    atualizacao();
    saldoInicial=saldoMin;
    System.out.printf("\nDepósito de R$ %.2f\n conluído!\n Seu novo saldo é R$ %.2f\n",deposito, saldo);
    
    }


    public static void opcao_3() {
        System.out.println("\nOpção escolhida: Realizar saque.\n");
        Scanner scanner = new Scanner(System.in);
        
        int nota100 = 100;
        int nota50 = 50;
        int nota20 = 20;
        int nota10 = 10;
        int nota5 = 5;
        int nota2 = 2;
        
        double saque = 0.0;
    
        if (!ContaAberta) {
            System.out.println("Impossível realizar saque! É necessário abrir uma conta!");
            return;
        }
    
        while (true) {
            System.out.print("Informe o valor do saque: ");
            saque = scanner.nextDouble();
    
            if (saque <= 0) {
                System.out.println("Impossível realizar saque! Valor deve ser acima de 0.");
            }  else if (saque > saldo) {
                System.out.println("Impossível realizar saque! Valor acima do saldo disponível.");
            } else {
                break;
            }
        }
        int valoresNotas = (int) saque;
    
        int qtd100 = (int) (valoresNotas / nota100);
        valoresNotas %= nota100;
    
        int qtd50 = (int) (valoresNotas / nota50);
        valoresNotas %= nota50;
    
        int qtd20 = (int) (valoresNotas / nota20);
        valoresNotas %= nota20;
    
        int qtd10 = (int) (valoresNotas / nota10);
        valoresNotas %= nota10;
    
        int qtd5 = (int) (valoresNotas / nota5);
        valoresNotas %= nota5;
    
        int qtd2 = (int) (valoresNotas / nota2);
        valoresNotas %= nota2;
    
        if (valoresNotas != 0) {
            System.out.println("Não foi possível realizar o saque com as notas disponíveis.");
            return;
        }
    
        saldo -= saque;
        ++qtdSaq;
        saqTot += saque;
        atualizacao();
        System.out.printf("\nSaque de R$ %.2f concluído!", saque);
        System.out.printf("\nSaldo disponível: R$ %.2f\n", saldo);
        System.out.println("Notas entregues:");
        if (qtd100 > 0) System.out.println("Notas de 100: " + qtd100);
        if (qtd50 > 0) System.out.println("Notas de 50: " + qtd50);
        if (qtd20 > 0) System.out.println("Notas de 20: " + qtd20);
        if (qtd10 > 0) System.out.println("Notas de 10: " + qtd10);
        if (qtd5 > 0) System.out.println("Notas de 5: " + qtd5);
        if (qtd2 > 0) System.out.println("Notas de 2: " + qtd2);
    
    
    }

    public static void opcao_4() {
        System.out.println("\nOpção escolhida: Aplicar Juros.\n");
        if (!ContaAberta) {
            System.out.println("Impossível realizar aplicação de juros! É necessário abrir uma conta!");
            return;}

        System.out.println("\nOpção escolhida: Aplicar Juros.\n");
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Informe a porcentagem do juros desejada: ");
        double juros = scanner.nextInt();
        double jurosPorcentagem = juros / 100.0;
        double calculo = saldo * jurosPorcentagem;
        

        if (juros < 0) { 
        System.out.println("Percentual deve ser acima de 0");
            return;
        }
        else if (juros > 0) {
        saldo += calculo;
        jurosTot += calculo;
        atualizacao();
        System.out.println("Aplicação de juros feita no valor de: " + jurosPorcentagem);
        System.out.println("Novo saldo : " + saldo);
        }
    }

    public static void opcao_5() {
        System.out.println("\nOpção escolhida: Simular Empréstimos.\n");
        
        Scanner scanner = new Scanner(System.in); 

        if (!ContaAberta) {
            System.out.println("É necessário ter uma conta aberta para simular empréstimos!");
            return;
        }


        System.out.print("Informe o valor do empréstimo que gostaria de simular: ");
        double valorEmprestimo =  scanner.nextDouble();

        System.out.print("Informe a porcentagem de juros mensal (%): ");
        double juros =  scanner.nextDouble();

        System.out.print("Informe o numero de meses para pagamento: ");
        int meses =  scanner.nextInt();

        if (valorEmprestimo <= 0 || juros <=0 || meses<= 0 ){
            System.out.println("Valores inválidos! Todos os valores devem ser positivos! ");
            return;
        }


        double taxaJuros = juros / 100;
        double valorJuros = valorEmprestimo * taxaJuros * meses;
        double valorTotal = valorEmprestimo + valorJuros;
        double valorParcela = valorTotal / meses;


        System.out.println("\nSimulação finalizada!\nResultado:");
        System.out.printf("Valor solicitado: R$ %.2f\n", valorEmprestimo);
        System.out.printf("Taxa de juros mensal: %.2f%%\n", juros);
        System.out.printf("Período: %d meses\n", meses);
        System.out.printf("Total de juros: R$ %.2f\n", valorJuros);
        System.out.printf("Valor total a pagar: R$ %.2f\n", valorTotal);
        System.out.printf("Valor da parcela mensal: R$ %.2f\n", valorParcela);
    }

    public static void opcao_6() {
        System.out.println("\nOpção escolhida: Extrato.\n");
        System.out.println("Nome do Cliente: " + nome);
        System.out.println("Saldo Inicial: R$" + saldoInicial);
        System.out.println("Saldo Atual: R$"+ saldo);
        System.out.println("Quantidade de Depósitos Realizados: " + qtdDep);
        System.out.println("Valor Total dos Depósitos Realizados: R$" + depTot);
        System.out.println("Quantidade de Saques Realizados: " + qtdSaq );
        System.out.println("Valor Total dos Saques Realizados: R$" + saqTot );
        System.out.println("Valor Total dos Juros Recebido: R$" + jurosTot);
        System.out.println("Saldo Mínimo: R$"+ saldoMin);
        System.out.println("Saldo Máximo: R$"+ saldoMax);
    }

    public static void opcao_7() {
        System.out.println("\nOpção escolhida: Integrantes.\n");

        System.out.println("..:: Integrantes ::..");
        System.out.println("Caynã Oliveira Ribeiro");
        System.out.println("Joana Cristina Da Luz");
        System.out.println("João Pedro Ourique Severo");
        System.out.println("Leandro Dutra Soares");
        System.out.println("Sarah Silveira Campello");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha = 0;

        while (escolha != 8) {
            escolha = menu(scanner);

            switch (escolha) {
                case 1:
                    opcao_1();
                    break;
                case 2:
                    opcao_2();
                    break;
                case 3:
                    opcao_3();
                    break;
                case 4:
                    opcao_4();
                    break;
                case 5:
                    opcao_5();
                    break;
                case 6:
                    opcao_6();
                    break;
                case 7:
                    opcao_7();
                    break;
                case 8:
                    System.out.println("\nSaindo do programa!\n");
                    break;
                default:
                    System.out.println("\nOpção desconhecida!\n");
                    break;
            }

            if (escolha != 8) {
                System.out.println("Pressione ENTER para continuar...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
