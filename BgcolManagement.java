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
public class BgcolManagement {
    Color bgcol;
     public void selectbgcolor(String selection){
        if(selection.equals("ነጭ")){ //"ነጭ","ቀለል ያለ ግራጫ","ቀለል ያለ ቡኒ"
            bgcol=Color.WHITE;
        }
        if(selection.equals("ቀለል ያለ ግራጫ")){ 
            bgcol=Color.lightGray;
        }
        if(selection.equals("ቢጫ")){ 
            bgcol=Color.YELLOW;
        }
    }
    public Color getbgcolor(){
        return bgcol;
    }
    
}
