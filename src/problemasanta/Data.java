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
public class Data {
    final private int TOTAL_RENOS=9;
    final private int GRUPO_DUENDE=3;
    private int duendes=0;
    private int renos=0;
    private Semaphore mutex=new Semaphore(1);
    private Semaphore semSanta=new Semaphore(0);
    private Semaphore semDuendes=new Semaphore(0);
    private Semaphore semRenos=new Semaphore(0);

    public int getTOTAL_RENOS() {
        return TOTAL_RENOS;
    }

    public int getGRUPO_DUENDE() {
        return GRUPO_DUENDE;
    }

    public int getDuendes() {
        return duendes;
    }

    public void setDuendes(int duendes) {
        this.duendes = duendes;
    }

    public int getRenos() {
        return renos;
    }

    public void setRenos(int renos) {
        this.renos = renos;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }

    public Semaphore getSemSanta() {
        return semSanta;
    }

    public void setSemSanta(Semaphore semSanta) {
        this.semSanta = semSanta;
    }

    public Semaphore getSemDuendes() {
        return semDuendes;
    }

    public void setSemDuendes(Semaphore semDuendes) {
        this.semDuendes = semDuendes;
    }

    public Semaphore getSemRenos() {
        return semRenos;
    }

    public void setSemRenos(Semaphore semRenos) {
        this.semRenos = semRenos;
    }
    
    
}
