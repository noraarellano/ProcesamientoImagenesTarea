/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagenes24.pkg1;

import espacial.Binarizacion;
import espacial.OperacionesBasicas;
import espacial.Convolución;
import gui.JFrameImg;
import herramientas.ColoresHitogrmas;
import herramientas.Graficador;
import java.awt.Image;

/**
 *
 * @author roban
 */
public class Imagenes241 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Image imagen = herramientas.HerramientasImagen.abrirImagen();
        //Image gris = OperacionesBasicas.escalaDeGrises(imagen);
        JFrameImg frame = new JFrameImg(imagen);
        
        Image ruido = espacial.Ruido.agregarRuidoAditivo(imagen, 5);
        JFrameImg frame3 = new JFrameImg(ruido);
       // ColoresHitogrmas ch = new ColoresHitogrmas(imagen);
        Convolución convo = new Convolución(herramientas.HerramientasImagen.toBufferedImage(imagen));
        Image nueva = convo.convolucionar(new int[]{1,1,1,
                                                    1,0,1,
                                                    1,1,1}, 8);
        
        JFrameImg frame2 = new JFrameImg(nueva);
        
       
    }
    
}
