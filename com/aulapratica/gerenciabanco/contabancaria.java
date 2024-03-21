package com.aulapratica.gerenciabanco;
import java.util.Scanner;


class ContaBanco {
    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo;
    
    public ContaBanco(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = 0.0;
    }
    
    public void deposito(double quantia) {
        if(quantia > 0) {
        saldo += quantia;
            System.out.println("Deposito de R$" + quantia + " efetuado com sucesso.");
        }else {
            System.out.println("Valor de deposito inválido.");
        }
    }
    
    public void saque(double quantia) {
        if(quantia <= saldo) {
            saldo -= quantia;
            System.out.println("Saque de R$" + quantia + " efetuado com sucesso.");
        }else {
            System.out.println("Saldo insuficiente");
        }
    }   
    public double getSaldo() {
        return saldo;
    }   
}

public class GerenciaBanco {    
    private static boolean contaCriada = false;
    private static ContaBanco cliente; 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Criar conta:");
            System.out.println("2 - Consultar saldo");
            System.out.println("3 - Fazer depósito");
            System.out.println("4 - Fazer saque");
            System.out.println("5 - Encerrar aplicação");
            
            int escolha = scanner.nextInt();
            switch (escolha) {
                case 1 -> criarConta(scanner);
                    
                case 2 -> {
                    if (contaCriada) {
                        System.out.println("Saldo: R$" + cliente.getSaldo());
                    } else {
                        System.out.println("Você precisa cria uma conta primeiro");
                    }
                }

                    
                case 3 -> {
                    if (contaCriada) {
                        System.out.println("Informe o valor a ser deposito: ");
                        double valorDeposito = scanner.nextDouble();
                        cliente.deposito(valorDeposito);
                        
                    }else{
                        System.out.println("Você precisa cria uma conta primeiro");
                    }
                }
                case 4 -> {
                    if (contaCriada) {
                        System.out.println("Informe o valor a ser sacado: ");
                        double valorSaque = scanner.nextDouble();
                        cliente.saque(valorSaque);
                        
                    } else{
                        System.out.println("Você precisa cria uma conta primeiro");
                    }
                }
                case 5 -> {
                    continuar = false;
                    System.out.println("Encerrando a aplicação... ");
                }
                default -> System.out.println("Opção invalida, tente novamente.");                                                                               
            }          
        }
   
    }
    private static void criarConta(Scanner scanner) {
        System.out.println("Informe seu nome: ");
        String nome = scanner.next();
        System.out.println("Informe seu sobrenome: ");
        String sobrenome = scanner.next();
        System.out.println("Informer seu CPF: ");
        String cpf = scanner.next();        
        
        cliente = new ContaBanco(nome, sobrenome, cpf);
        contaCriada = true; // Define que a conta foi criada
        System.out.println("Conta criada com sucesso!");
        
     }
    
}
