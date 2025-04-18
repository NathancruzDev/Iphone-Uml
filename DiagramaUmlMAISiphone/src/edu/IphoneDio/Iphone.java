package edu.IphoneDio;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.Random;

public class Iphone implements TocarMusica,NavegarWeb,AparelhoTelefonico {

    Scanner scanner=new Scanner(System.in);
    //telefone variaveis
    long telephonicNumber;
    String mensagem;
    //safari variaveis;
    String url;




    public long resgatarNumero(){
        System.out.print("Insira um numero:");
        long number= scanner.nextLong();
        this.telephonicNumber=number;
        return this.telephonicNumber=number;
    }

    public static int contarDigitos(long telephonicNumber){
        return String.valueOf(Math.abs(telephonicNumber)).length();
    }

    public boolean discandoNumero(long telephonicNumber) throws IllegalArgumentException{

        if (telephonicNumber <= 0) {
            throw new IllegalArgumentException("O número não pode ser negativo ou zero.");
        }

        int digitCount = contarDigitos(telephonicNumber);

        if (digitCount > 15) {
            throw new IllegalArgumentException("O número não pode ter mais de 15 dígitos.");
        }

        return true;
    }

    @Override
    public void tocar() {
        System.out.println("Esta chamando pelo numero"+resgatarNumero());
    }

    public void tentativaLigar(){

        Random tentativas= new Random();
        for (int tentativa = 1; tentativa <= 5; tentativa++) {
            System.out.print("Tentativa " + tentativa + "... ");

            if (tentativas.nextBoolean()) { // 50% de chance
                System.out.println("conectado!");
                atender();
                return;
            }

            System.out.println("falhou.");

        }

        System.out.println("Não foi possível completar a ligação após 5 tentativas.");
        iniciarCorreioVoz();

    }


    @Override
    public void atender() {
        System.out.println("Numero atendido");
    }
    public String mensagemCorreioVoz(){
        System.out.println("Escreva a mensagem de voz:");
        mensagem= scanner.next();
        return mensagem;
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println(mensagemCorreioVoz());
    }

    //SAFARI
    ArrayList abas=new ArrayList<>();

    public String resgatarURL() {
        System.out.print("Insira a URL: ");
        this.url = scanner.next();  // Armazena e retorna
        return this.url;
    }


    @Override
    public void exibirPagina(String url) {
        this.url=url;
        System.out.println("aba:"+this.url);
    }

    @Override
    public void adicionarNovaAba() {
        String novaAba=resgatarURL();

        System.out.println("Nova aba adicionada:"+novaAba);

        abas.add(novaAba);

        System.out.println("Abas abertas:");

        for(int i=0; i >=abas.size();i++){
            System.out.println(abas.get(i));
        }

    }

    @Override
    public void atualizarPagina() {
        System.out.println("Atualizando pagina");
        System.out.println("Pagina atualizada!");
    }


    //MUSIC PLAYER
    String musica;

    @Override
    public void IniciarMusica() {
        System.out.println("Musica :"+ musica +" iniciada.");
    }

    @Override
    public void PausarMusica() {

    }
    public void escrevaAEscolha(){
        System.out.print("Qual musica deseja ouvir:");
        musica=scanner.next();
        this.musica=musica;
    }
    @Override
    public void selecionarMusica(String musica) {
       escrevaAEscolha();
    }
}
