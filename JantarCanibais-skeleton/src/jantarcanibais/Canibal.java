package jantarcanibais;

public class Canibal implements Runnable{
    private final Travessa travessa;
    private final int id;
    
    Canibal(Travessa t, int id){
        travessa = t;
        this.id = id;
    }
    
    @Override
    public void run() {
        while(true){
            //aqui o canibal faz suas ações: servir-se, comer...
            travessa.seserve();
        }
        
    }
    
}
