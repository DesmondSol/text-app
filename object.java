/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.word.app;

/**
 *
 * @author hp
 */

import java.io.Serializable;
import java.util.Date;
public class object implements Serializable{
    
    String username;
    String[] editorUserName,dateEdited;
    String password;
    Date date;
    boolean status;
    Date created;
    int i=0;

    
  public object(String pass,Date dat,String user,boolean stat){
  date=dat;
  password=pass;
  username=user;
  status=stat;
  if (i==0){
  created=date;
  i++;}
//  dateEdited[0]=date.toString();
 // editorUserName[0]=System.getProperty("user.name");
  }

    object() {
        
    }
//int a=0,b=0;

    public void setDate(Date date) {
        this.date = date;
/**        dateEdited[b]=date.toString();
        b++;
        if (!(System.getProperty("user.name").equals(username))){
            
            editorUserName[a]=System.getProperty("user.name");
            a++;
        }*/
    }

   public String[] getEditorUserName() {
        return editorUserName;
    }

    public String[] getDateEdited() {
        return dateEdited;
    }
    
  
}

