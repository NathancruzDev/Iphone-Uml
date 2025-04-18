package edu.IphoneDio;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Iphone Sistema = new Iphone();
        boolean ligado = true; // Controla se o sistema está ativo

        while (ligado) { // Loop principal
            System.out.println("\n====== Menu Inicial ======");
            System.out.println("[1] Music Player");
            System.out.println("[2] Telefone");
            System.out.println("[3] Safari");
            System.out.println("[99] Desligar");
            System.out.print("Insira por onde deseja navegar: ");
            int navegar = scanner.nextInt();
        //essas classes sao estaticas e estao abaixo, apenas funcionam para permitir o melhor funcionamento dos ‘loops’ no sistema.
            switch (navegar) {
                case 1:
                    menuMusicPlayer(scanner, Sistema);
                    break;
                case 2:
                    menuTelefone(scanner, Sistema);
                    break;
                case 3:
                    menuSafari(scanner, Sistema);
                    break;
                case 99:
                    System.out.println("====== Desligando... ======");
                    ligado = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }

    // ====== Métodos Auxiliares  ======

    private static void menuMusicPlayer(Scanner scanner, Iphone Sistema) {
        boolean noPlayer = true;
        while (noPlayer) {
            System.out.println("\n====== Music Player ======");
            System.out.println("[1] Selecionar música");
            System.out.println("[2] Iniciar música");
            System.out.println("[3] Pausar música");
            System.out.println("[4] Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome da música: ");
                    scanner.nextLine();
                    String musica = scanner.nextLine();
                    Sistema.selecionarMusica(musica);
                    break;
                case 2:
                    Sistema.IniciarMusica();
                    break;
                case 3:
                    Sistema.PausarMusica();
                    break;
                case 4:
                    noPlayer = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuTelefone(Scanner scanner, Iphone Sistema) {
        boolean telefoneAtivo=true;

        while(telefoneAtivo) {
            int navTelefone ;
            System.out.println("\n====== Telefone ======");
            Sistema.resgatarNumero();
            Sistema.contarDigitos(Sistema.resgatarNumero());
            Sistema.discandoNumero(Sistema.resgatarNumero());
            Sistema.tocar();
            Sistema.tentativaLigar();
            System.out.println("[1] tentar ligar novamente");
            System.out.println("[2] Correio de voz");
            System.out.println("[3] Sair");
            System.out.print("Insira uma opcao:");
            navTelefone=scanner.nextInt();
                if(navTelefone==1){
                    Sistema.resgatarNumero();
                    Sistema.discandoNumero(Sistema.resgatarNumero());
                    Sistema.tentativaLigar();
                } else if (navTelefone==2) {
                    Sistema.mensagemCorreioVoz();
                } else if (navTelefone==3) {
                    telefoneAtivo=false;
                }
                else {
                    System.out.println("Nenhuma alternativa encontrada...");
                }
        }
    }


    private static void menuSafari(Scanner scanner, Iphone Sistema) {
        boolean noSafari = true;
        while (noSafari) {
            System.out.println("\n====== Safari ======");
            Sistema.resgatarURL();
            Sistema.exibirPagina(Sistema.resgatarURL());
            System.out.println("[1] Adicionar nova aba");
            System.out.println("[2] Atualizar página");
            System.out.println("[3] Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Sistema.adicionarNovaAba();
                    break;
                case 2:
                    Sistema.atualizarPagina();
                    break;
                case 3:
                    noSafari = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}