package br.com.raphsousa.televisao;

import java.util.Scanner;

/**
 *
 * @author idrap
 */
public class ControlePrincipal {

    public static void main(String[] args) {
//      classe controle recebe como parametro um objeto de televisor e decodifi-
//      cador classes televisor/decodificador recebem a quantidade de canais
//      como parametro
        Televisor tv1 = new Televisor((short) 30);
        Decodificador dc1 = new Decodificador((short) 300);
        ControleRemoto controleTeste = new ControleRemoto(tv1, dc1);
        Scanner input = new Scanner(System.in);
        boolean quebra_looping = true;
        String pergunta_looping;
        
        
        while (quebra_looping) {
//      criei todas as perguntas para o usuario dentro da classe ControleRemoto
//      nao fiz todas as verificações para casos de inputs erroneos  mas para  
//      inputs seguindo as opçoes dadas funciona perfeitamente
            if (controleTeste.perguntaESelecionaAparelhoDesejado()) {
                controleTeste.perguntaAcaoDesejada();
                System.out.println("\nQuer continuar? Digite s ou n");
                pergunta_looping = input.next();
                quebra_looping = pergunta_looping.toLowerCase().
                        equals("s");
            }
        }
        
        
/*
        //        REALIZANDO TESTES AUTOMATICOS (DESCOMENTE PARA USÁ-LOS)
        Televisor tv_teste = new Televisor();
        Decodificador decodificador_teste = new Decodificador();
//        TESTANDO COM A CLASSE TELEVISOR
//                  VOLUME        
        controleTeste.selecionaAparelho(tv_teste);
        controleTeste.diminuiVolume();
        controleTeste.aumentaVolume();
        controleTeste.aumentaVolume();
        controleTeste.diminuiVolume();
        controleTeste.mudaCanalDesejado((short)700);
//                  CANAL
        controleTeste.mudaCanalDesejado((short)400);
        controleTeste.mudaCanalDesejado((short)-400);
        controleTeste.canalAnterior();
        controleTeste.canalAnterior();
        controleTeste.proximoCanal();
        
        
//        TESTANDO COM A CLASSE DECODIFICADOR
//                  VOLUME
        controleTeste.selecionaAparelho(decodificador_teste);
        controleTeste.aumentaVolume();
        controleTeste.diminuiVolume();
        controleTeste.aumentaVolume();
//                  CANAL
        controleTeste.proximoCanal();
        controleTeste.proximoCanal();
        controleTeste.proximoCanal();
        
        tv_teste.informaCanalEVolume();
        System.out.println("");
        decodificador_teste.informaCanalEVolume();
*/
    }
}