/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.word.app;

import java.awt.Color;


/**
 *
 * @author hp
 */
public class ColorManagemnt {
  Color col;
    public void selectcolor(String selection){
        if(selection.equals("ጥቁር")){
            col=Color.BLACK;
        }if(selection.equals("ቀይ")){ 
            col=Color.RED;
        }if(selection.equals("ብርቱካናማ")){
            col=Color.ORANGE;
        }if(selection.equals("ሰማያዊ")){
            col=Color.BLUE;
        }if(selection.equals("አረንዴ")){
            col=Color.GREEN;
        }if(selection.equals("ወይነጠጅ")){
            col=Color.MAGENTA;
        }
            
    }
    public Color getcolor(){
        return col;
    }
    
   
}
