/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jantarcanibais;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sumatra
 */
public class Cozinheiro implements Runnable{
    private final Travessa travessa;
    
    Cozinheiro(Travessa t){
        travessa = t;
    }
    
   
    @Override
    public void run() {
        while(true){
                travessa.enchetravessa();
        }
    }
    
}
