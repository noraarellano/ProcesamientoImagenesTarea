/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author roban
 */
public class ColoresHitogrmas {
    double rojo[] = new double[256];
    double verde[] = new double[256];
    double azul[] = new double[256];
    Image imagen ;
    BufferedImage bufim;
    Graficador graf = new Graficador("Tono","Frecuencia","Hitograma de color");
    
    public ColoresHitogrmas(){
        this.imagen = HerramientasImagen.abrirImagen();
        this.bufim = HerramientasImagen.toBufferedImage(imagen);
        histogramas();        
    }
    
    public ColoresHitogrmas(Image imagen){
        this.imagen = imagen;
        this.bufim = HerramientasImagen.toBufferedImage(imagen);
        histogramas();
    }
    
    public void histogramas(){
        for(int x=0; x < bufim.getWidth(null);x++){
            for(int y=0; y<bufim.getHeight(null);y++){
                Color col = new Color(bufim.getRGB(x, y));
                rojo[col.getRed()]=rojo[col.getRed()]+1;
                verde[col.getGreen()]=verde[col.getGreen()]+1;
                azul[col.getBlue()]=azul[col.getBlue()]+1;
            }
        }
        graf.agregarSerie("Rojo", rojo);
        graf.agregarSerie("Verde", verde);
        graf.agregarSerie("Azul", azul);
        graf.crearGrafica();
        graf.muestraGrafica();
    }

}
