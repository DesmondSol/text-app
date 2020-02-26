/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.word.app;

import java.awt.Font;

/**
 *
 * @author hp
 */
public class FontManagement {
Font font;
    /**
     *
     * @param selection
     * @param s
     * @param size
     */
    public void selectfont(String selection,int s, int size){
        if(selection.equals("AGF - Zemen")){
            font= new Font("AGF - ZEMEN",s,size);
        }if(selection.equals("Ge'ez-1")){
            font=new Font("GE'EZ-1",s,size);
        }if(selection.equals("ALXethiopian")){
            font=new Font("ALXETHIOPIAN",s,size);
        }
    }
    
    public Font getfont(){
        return font;
    }
}
