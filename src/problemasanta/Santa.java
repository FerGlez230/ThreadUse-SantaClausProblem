/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemasanta;

import java.awt.Image;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author maryf
 */
public class Santa implements Runnable{
    private Data data;
    private Ventana ventana;
    public Santa(Data data, Ventana v){
        this.data=data;
        this.ventana=v;
    }
    @Override
    public void run() {
       while(true){
           try {
               data.getSemSanta().acquire();
               data.getMutex().acquire();
           } catch (InterruptedException ex) {
               System.out.println("Santa exception"+ex);
           }
           if(data.getRenos()==data.getTOTAL_RENOS()){
               data.getSemRenos().release();
               System.out.println("Santa salio a repartir regalos");
               try {
                       ventana.imageSanta = new ImageIcon(getClass().getResource("/img/"+ventana.urlSanta[1])).getImage();
                       ventana.update(ventana.getGraphics());
                       Thread.sleep(1000);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(Santa.class.getName()).log(Level.SEVERE, null, ex);
                   }
               data.getMutex().release();
               ventana.imageSanta = new ImageIcon(getClass().getResource("/img/"+ventana.urlSanta[0])).getImage();
               ventana.update(ventana.getGraphics());
               try {
                       Thread.sleep(100);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(Santa.class.getName()).log(Level.SEVERE, null, ex);
                   }
           }else{
               if(data.getDuendes()==data.getGRUPO_DUENDE()){
                   data.getSemDuendes().release();
                   System.out.println("Santa ayuda a los duendes");
                   try {
                       ventana.imageSanta = new ImageIcon(getClass().getResource("/img/"+ventana.urlSanta[2])).getImage();
                       ventana.update(ventana.getGraphics());
                       Thread.sleep(1000);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(Santa.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   
                   data.getMutex().release();
                   ventana.imageSanta = new ImageIcon(getClass().getResource("/img/"+ventana.urlSanta[0])).getImage();
                    ventana.update(ventana.getGraphics());
                    try {
                
                       Thread.sleep(100);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(Santa.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
           }
       }
    }
    
}
