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
public class Reno implements Runnable{
    private Data data;
    private Ventana ventana;
    public Reno(Data data, Ventana v){
        this.data=data;
        this.ventana=v;
    }

    @Override
    public void run() {
        while(true){
        try {
            data.getMutex().acquire();
            
        } catch (InterruptedException ex) {
            System.out.println("Reno exception"+ex);
        }
        if(data.getRenos()==data.getTOTAL_RENOS()-1){
            data.setRenos(data.getRenos()+1);
            data.getSemSanta().release();
            
            System.out.println("Llego el ultimo reno y desperto a Santa");
            ventana.update(ventana.getGraphics());
            data.getMutex().release();
            try {
                Thread.sleep((long)(Math.random()*1500+200));
                   } catch (InterruptedException ex) {
                       Logger.getLogger(Santa.class.getName()).log(Level.SEVERE, null, ex);
                   }
            
            try {
                data.getSemRenos().acquire();
                data.setRenos(0);
                ventana.update(ventana.getGraphics());
                 //Thread.sleep((long) (Math.random()*500));
            } catch (InterruptedException ex) {
                Logger.getLogger(Reno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            data.setRenos(data.getRenos()+1);
            System.out.println("Un reno llego de vacaciones. Hay "+data.getRenos());
            ventana.update(ventana.getGraphics());
            data.getMutex().release();
            try {
                Thread.sleep((long)(Math.random()*1500+200));
                   } catch (InterruptedException ex) {
                       Logger.getLogger(Santa.class.getName()).log(Level.SEVERE, null, ex);
                   }
            
        }
    }
    }
}
