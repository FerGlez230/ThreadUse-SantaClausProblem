/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemasanta;

import java.util.concurrent.Semaphore;

/**
 *
 * @author maryf
 */
public class ProblemaSanta {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Data data=new Data();
      
     
        
        Ventana ventana=new Ventana(data);
        Santa santa=new Santa(data, ventana);
       
        Duende duende=new Duende(data,ventana);
       
        Reno reno=new Reno(data, ventana);
        Thread hiloSanta=new Thread(santa);
        Thread hiloDuende=new Thread(duende);
        Thread hiloReno=new Thread(reno);
        hiloSanta.start();
        hiloDuende.start();
        hiloReno.start();
        
    }
    
}
