package br.com.raphsousa.televisao;

import java.util.Scanner;

/**
 *
 * @author idrap
 */
public class ControleRemoto {
    private Aparelho aparelho;
    private short canal_atual;
    private byte volume;
    private final Televisor tv;
    private final Decodificador decodificador;
    private final Scanner input;

    
    public ControleRemoto(Televisor televisor, Decodificador decodificador) {
        input = new Scanner(System.in);
        this.tv = televisor;
        this.decodificador = decodificador;
    }
     
//    metodo usao somente para testes sem necessidade de inputs do usuario
    public void selecionaAparelho(Aparelho aparelho_selecionado) {
        this.aparelho = aparelho_selecionado;
    }
    
    public boolean perguntaESelecionaAparelhoDesejado(){
        String aparelhoDesejado;
        System.out.println("""
                           Digite o aparelho que deseja utilizar
                           (t - televisor ou d - decodificador):
                           """);
        aparelhoDesejado = input.next();
        
        switch (aparelhoDesejado.toLowerCase()) {
            case "t" -> {
                selecionaAparelho(tv);
            }
            case "d" -> {
                selecionaAparelho(decodificador);
            }
            default -> {
                System.out.println("Aparelho inválido");
                return false;
            }
        }
        return true;
    }
    
    public void perguntaAcaoDesejada(){
        short acao;
        short canal;
        System.out.println("""
                           Digite o  numero da açao que pretende fazer:
                           1 - aumenta volume
                           2 - diminui volume
                           3 - Proximo canal
                           4 - Canal anterior
                           0 - Caso queira digitar o número canal desejado
                           """);
        acao = input.nextShort();
        switch(acao){
            case (short) 0 -> {
                System.out.println("Digite o número do canal: ");
                canal = input.nextShort();
                mudaCanalDesejado(canal);
            }
            case (short) 1 -> this.aumentaVolume();
            case (short) 2 -> this.diminuiVolume();
            case (short) 3 -> this.proximoCanal();
            case (short) 4 -> this.canalAnterior();
            default -> System.out.println("Comando inválido");
        }
        this.aparelho.informaCanalEVolume();
    }
    
    public void aumentaVolume() {
        this.aparelho.aumentaVolume();
    }
    
    public void diminuiVolume() {
        this.aparelho.diminuiVolume();
    }
    
    public void mudaCanalDesejado(short canalDesejado) {
        this.aparelho.mudaCanalDesejado(canalDesejado);
    }
    
    public void proximoCanal() {
        this.aparelho.proximoCanal();
    }
    
    public void canalAnterior() {
        this.aparelho.canalAnterior();
    }
    
}
