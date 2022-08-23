/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemasanta;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maryf
 */
public class Duende implements Runnable{
    private Data data;
    private Ventana ventana;
    public Duende(Data data, Ventana v){
        this.data=data;
        this.ventana=v;
    }

    @Override
    public void run() {
        while(true){
            try {
                data.getMutex().acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(Duende.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(data.getDuendes()==data.getGRUPO_DUENDE()-1){
                data.setDuendes(data.getDuendes()+1);
                
                
                data.getSemSanta().release();
                ventana.update(ventana.getGraphics());
                System.out.println("Tres duendes despiertan a santa");
                data.getMutex().release();
                try {
                    Thread.sleep((long)(Math.random()*2500+600));
                   } catch (InterruptedException ex) {
                       Logger.getLogger(Santa.class.getName()).log(Level.SEVERE, null, ex);
                   }
                
                try {
                    data.getSemDuendes().acquire();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Duende.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                data.setDuendes(0);
                ventana.update(ventana.getGraphics());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Duende.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                data.setDuendes(data.getDuendes()+1);
                System.out.println("duendes "+data.getDuendes());
                ventana.update(ventana.getGraphics());
                data.getMutex().release();
                try {
                    Thread.sleep((long)(Math.random()*2500+600));
                   } catch (InterruptedException ex) {
                       Logger.getLogger(Santa.class.getName()).log(Level.SEVERE, null, ex);
                   }
                
            }
        }
    }
    
}
