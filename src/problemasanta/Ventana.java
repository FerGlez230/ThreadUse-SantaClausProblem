/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemasanta;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author maryf
 */
public class Ventana extends JFrame {
    private Graphics gBuffer;
    Image imageFondo, image, imageSanta;
    private Data data;
    String urlSanta[]={"santaDormido.png","santaCostal.png",  "santaRegalo.png"};
    String urlDuende[]={"duende1.png", "duende2.png", "duende3.png"};
    public void inicializar(){ 
        setSize(800,500);
        setTitle("Problema Santa");
        setLayout(null);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        String url = "/img/fondo.jpg";
        imageFondo = new ImageIcon(getClass().getResource(url)).getImage();
        imageSanta = new ImageIcon(getClass().getResource("/img/"+urlSanta[0])).getImage();
       
        setVisible(true);
        }
     public Ventana(Data data){
        this.data=data;
        inicializar();
    }
    public void paint(Graphics g){
        super.paint(g);
       
        update(g);
       
    }
    public void update(Graphics g){ 
     
       BufferedImage buffer=new BufferedImage(800,500,BufferedImage.TYPE_INT_ARGB);
       gBuffer=buffer.getGraphics();
       
       //gBuffer.fillRect(0, 0, 800, 500);
       gBuffer.drawImage(imageFondo, 0, 0, 800,500,this);
       dibujarDuende();
       dibujarReno();
       dibujarSanta();
       g.drawImage(buffer, 0, 0, this);
       
    }
    public void dibujarDuende(){
        int x=100;
        int y=350;
        for(int i=0; i<data.getDuendes(); i++){
            image = new ImageIcon(getClass().getResource("/img/"+urlDuende[i])).getImage();
            gBuffer.drawImage(image, x, y, this);
            x+=100;
        }
    }
    public void dibujarReno(){
        int x=50;
        int y=30;
        for(int i=0; i<data.getRenos(); i++){
            image = new ImageIcon(getClass().getResource("/img/reno.png")).getImage();
            gBuffer.drawImage(image, x, y,68,68, this);
            x+=70;
        }
    }
    public void dibujarSanta(){
        int x=400;
        int y=300;
        gBuffer.drawImage(imageSanta, x, y, this);
    }
}
