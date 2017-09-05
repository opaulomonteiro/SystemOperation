/* Este código é apenas uma sugestão de implementação. 
   Pode ser modificado conforme necessário. */

package jantarcanibais;

public class JantarCanibais {

    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        int i;
        int num_canibais = 5;
        int num_porcoes = 5;
        int tempo_execucao = 30; /* em segundos */

        Travessa travessa = new Travessa(num_porcoes);

        /* Dispara thread Cozinheiro */
        Thread cozinheiro = new Thread( new Cozinheiro(travessa));
        cozinheiro.start();
        
        /* Dispara threads Cabinais. */
        for(i=0; i<num_canibais; i++){
            Thread canibal = new Thread(new Canibal(travessa, i));
            canibal.start();
        }
        
        /* Aguarda o tempo de execução. */
        Thread.sleep(tempo_execucao * 1000);
        
        /* Finaliza todas as threads. */
        System.exit(0);
    }
    
}
