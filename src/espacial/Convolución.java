/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacial;

import espacial.OperacionesBasicas;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import org.jfree.chart.ChartColor;

/**
 *
 * @author robanac
 * TODO: tenemos que determinar el divisor
 * offset: es un valor que se añade al resulante
 */
public class Convolución {
   BufferedImage imagenOriginal;

   public Convolución(BufferedImage imagenOriginal) {
      this.imagenOriginal = imagenOriginal;
   }

   public Image convolucionar(int[] mascara, int div) {
      BufferedImage aux = new BufferedImage(this.imagenOriginal.getWidth(), this.imagenOriginal.getHeight(), 1);

      for(int x = 0; x < this.imagenOriginal.getWidth(); ++x) {
         for(int y = 0; y < this.imagenOriginal.getHeight(); ++y) {
            int rgb = this.convolucionar(x, y, mascara, div);
            Color nuevo = new Color(rgb);
            aux.setRGB(x, y, nuevo.getRGB());
         }
      }

      return herramientas.HerramientasImagen.toImage(aux);
   }

   private int convolucionar(int x, int y, int[] mascara, int div) {
      int aR = 0;
      int aG = 0;
      int aB = 0;
      Color aux = new Color(this.imagenOriginal.getRGB(x, y));
      int valorRojo = aux.getRed();

      for(int j = 0; j < mascara.length; ++j) {
         int rgb = this.obtenerRGB(x, y, j);
         if (rgb != 0) {
            aux = new Color(rgb);
            aR += aux.getRed() * mascara[j];
            aG += aux.getGreen() * mascara[j];
            aB += aux.getBlue() * mascara[j];
         }
      }

      aR /= div;
      aG /= div;
      aB /= div;
      aux = new Color(OperacionesBasicas.validar(aR), OperacionesBasicas.validar(aG), OperacionesBasicas.validar(aB));
      return aux.getRGB();
   }

   private int obtenerRGB(int x, int y, int j) {
      int rgb = 0;

      try {
         switch (j) {
            case 0:
               if (x - 1 >= 0 && y - 1 >= 0) {
                  if (x - 1 < this.imagenOriginal.getWidth() && y - 1 < this.imagenOriginal.getHeight()) {
                     rgb = this.imagenOriginal.getRGB(x - 1, y - 1);
                     break;
                  }

                  return 0;
               }

               return 0;
            case 1:
               if (x - 1 >= 0 && y >= 0) {
                  if (x - 1 < this.imagenOriginal.getWidth() && y < this.imagenOriginal.getHeight()) {
                     rgb = this.imagenOriginal.getRGB(x - 1, y);
                     break;
                  }

                  return 0;
               }

               return 0;
            case 2:
               if (x - 1 >= 0 && y + 1 >= 0) {
                  if (x - 1 < this.imagenOriginal.getWidth() && y + 1 < this.imagenOriginal.getHeight()) {
                     rgb = this.imagenOriginal.getRGB(x - 1, y + 1);
                     break;
                  }

                  return 0;
               }

               return 0;
            case 3:
               if (x >= 0 && y - 1 >= 0) {
                  if (x < this.imagenOriginal.getWidth() && y - 1 < this.imagenOriginal.getHeight()) {
                     rgb = this.imagenOriginal.getRGB(x, y - 1);
                     break;
                  }

                  return 0;
               }

               return 0;
            case 4:
               if (x >= 0 && y >= 0) {
                  if (x < this.imagenOriginal.getWidth() && y < this.imagenOriginal.getHeight()) {
                     rgb = this.imagenOriginal.getRGB(x, y);
                     break;
                  }

                  return 0;
               }

               return 0;
            case 5:
               if (x >= 0 && y + 1 >= 0) {
                  if (x < this.imagenOriginal.getWidth() && y + 1 < this.imagenOriginal.getHeight()) {
                     rgb = this.imagenOriginal.getRGB(x, y + 1);
                     break;
                  }

                  return 0;
               }

               return 0;
            case 6:
               if (x + 1 >= 0 && y - 1 >= 0) {
                  if (x + 1 < this.imagenOriginal.getWidth() && y - 1 < this.imagenOriginal.getHeight()) {
                     rgb = this.imagenOriginal.getRGB(x + 1, y - 1);
                     break;
                  }

                  return 0;
               }

               return 0;
            case 7:
               if (x + 1 >= 0 && y >= 0) {
                  if (x + 1 < this.imagenOriginal.getWidth() && y < this.imagenOriginal.getHeight()) {
                     rgb = this.imagenOriginal.getRGB(x + 1, y);
                     break;
                  }

                  return 0;
               }

               return 0;
            case 8:
               if (x + 1 >= 0 && y + 1 >= 0) {
                  if (x + 1 < this.imagenOriginal.getWidth() && y + 1 < this.imagenOriginal.getHeight()) {
                     rgb = this.imagenOriginal.getRGB(x + 1, y + 1);
                     return rgb;
                  }

                  return 0;
               }

               return 0;
         }
      } catch (Exception var6) {
         System.out.println();
      }

      return rgb;
   }
}


