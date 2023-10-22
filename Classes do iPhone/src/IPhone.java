import AparelhoTelefonico.AparelhoTelefonico;
import NavegadorNaInternet.NavegadorNaInternet;
import ReprodutorMusical.ReprodutorMusical;

public class IPhone implements AparelhoTelefonico{

    public NavegadorNaInternet navegadorNaInternet;
    public ReprodutorMusical reprodutorMusical;

    public IPhone(){
        navegadorNaInternet = new Chrome();
        reprodutorMusical =  new ITunes();
    }

    @Override
    public void ligar() {
       System.out.println("Ligando o Iphone");
    }

    @Override
    public void atender() {
        System.out.println("Atendo ligação");
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("Iniciando correio de voz");
    }

    @Override
    public void desligar() {
        System.out.println("Desligando o Iphone");
    }
    
}
