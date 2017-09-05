package jantarcanibais;


public class Travessa {
    int porcoes;
    
    Travessa(int M) {
        porcoes = M;
    }
    
    /* Chamada pelos canibais. 
       Retorna true se conseguiu se servir, senão retorna falso. 
    */
    public boolean seserve(){

        //sincronização para se servir.
        return true;
    }

    /* Chamado pelo cozinheiro. */
    public void enchetravessa(){
        
        //sincronização para encher a travessa.
        
    }
}
    
    

