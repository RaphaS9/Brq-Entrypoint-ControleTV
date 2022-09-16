package br.com.raphsousa.televisao;

/**
 *
 * @author idrap
 */
public abstract class Aparelho {
//    Classe aparelho é mae de televisor e decodificador coloquei o atributo 
//    nome do aparelho no construtor para nas classes filhos 
//    ser possivel identificar o que  estamos usando
    private byte volume = 0;
    private short canal = 1;
    private final String nomeDoAparelho;
    private final short qtdCanais;

    public Aparelho(String nomeDoAparelho, short qtdCanais) {
        this.nomeDoAparelho = nomeDoAparelho;
        this.qtdCanais = qtdCanais;
    }

    public String getNomeDoAparelho() {
        return nomeDoAparelho;
    }

    public byte getVolume() {
        return volume;
    }

    public void setVolume(byte volume) {
        this.volume = volume;
    }

    public short getCanal() {
        return canal;
    }

    public void setCanal(short canal) {
        this.canal = canal;
    }
   
    public void aumentaVolume() {
        if (volume < 100) {
            this.setVolume(++this.volume);
        }else{
            System.out.println("Volume máximo");}
    }
    
    public void diminuiVolume() {
        if (volume > 0) {
            this.setVolume(--this.volume);
        }else{
            System.out.println("Volume mínimo");}
    }
    
    public void mudaCanalDesejado(short canalDesejado) {
//        recebe o canal deseado e confere se esta no range da quantidade de
//        canais recebida no construtor
        if (canalDesejado <= this.qtdCanais && canalDesejado >=0) {
            this.setCanal(canalDesejado);
        }else{
            System.out.println("Canal inválido");
        }
    }    

    public void proximoCanal() {
        if (this.canal < this.qtdCanais) {
            this.setCanal(++this.canal);
        }else{
//            se o canal for igual ao limite de canais, o ciclo é renovado
//            e o canal é setado para 1
            this.setCanal((short) 1);
        }
    }

    public void canalAnterior() {
        if (this.canal > 1) {
            this.setCanal(--this.canal);
        }else{
//            se o canal for igual a 1, o ciclo é renovado
//            e o canal é setado para o ultimo canal
            this.setCanal(this.qtdCanais);
        }
    }    
    
    public void informaCanalEVolume() {
        System.out.println(String.format("""
                                         Utilizando o aparelho - %s\nCanal atual: %d\nVolume atual: %d""", 
                nomeDoAparelho, canal, volume));
    }
}
