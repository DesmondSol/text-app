/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.word.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.TextAttribute;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;



/**
 *
 * @author hp
 */
public class MYWORDAPP implements ActionListener,KeyListener{
    
    JFrame frame;
    JTextArea txa,edna,edti;
    JScrollPane scrlp;
    String txtstr;
    String filename;
    JMenuBar menubar;
    JMenu file,help;
    JMenuItem Open,New,Save,SaveAs,Close,devdetail,how;
    boolean modified=false;
    FileOutputStream fos;
    FileInputStream fis;
    JFileChooser dialog;
    String str;
    JToolBar tb;
    JComboBox color;
    JComboBox ffont;
    JComboBox bkcolor;
  JTextField na,tfCount,la,pas,stat;
    
    String[] coloritems={"ጥቁር","ቀይ","ብርቱካናማ","ሰማያዊ","አረንዴ","ወይነጠጅ"};
    String[] fontitems={"AGF - Zemen","Ge'ez-1","ALXethiopian"};
    String[] bakcolor={"ነጭ","ቀለል ያለ ግራጫ","ቢጫ"};
  
    JSlider size;
    JButton plain,bold,italic,underline,cont;
   // Font font=new Font("nyala",1,18);
    
    
    String initDial;
object secObject;
    int s=1;
     FontManagement fman=new FontManagement();
    ColorManagemnt colman=new ColorManagemnt();
    BgcolManagement bgcoman=new BgcolManagement();
     
    
    MYWORDAPP(){
        secObject = new object();
        dialog=new JFileChooser();
        Color colorc,bgco;
        Font font;
        colorc=colman.getcolor();
        bgco=bgcoman.getbgcolor();
        
        frame= new JFrame();
        frame.setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon("APB.ico");
        frame.setIconImage(icon.getImage());
         
        txa=new JTextArea();
        
        scrlp=new JScrollPane(txa);
        
        menubar= new JMenuBar();
         menubar.setBackground(java.awt.Color.cyan);
         
         file=new JMenu("መዝገብ"); file.setMnemonic('መ');
       file.setFont(new Font("Nyala", 0, 18));
       help=new JMenu("እርዳታ"); help.setMnemonic('እ');
       help.setFont(new Font("Nyala", 0, 18));
         Open=new JMenuItem("ክፈት   ctrl+o");Open.setMnemonic('ክ');
       Open.setFont(new Font("Nyala", 0, 18));
         New=new JMenuItem("አዲስ   ctrl+n"); New.setMnemonic('አ');
       New.setFont(new Font("Nyala", 0, 18));
         Save=new JMenuItem("አስቀምጥ ctrl+s"); Save.setMnemonic('አ');
       Save.setFont(new Font("Nyala", 0, 18));
         SaveAs=new JMenuItem("አዲስ አስቀምጥ");
       SaveAs.setFont(new Font("Nyala", 0, 18));
         Close=new JMenuItem("ዝጋ");
       Close.setFont(new Font("Nyala", 0, 18));
         devdetail=new JMenuItem("ስለሰሪዉ");
       devdetail.setFont(new Font("Nyala", 0, 18));
         how=new JMenuItem("እንዴት ልጠቀም");
       how.setFont(new Font("Nyala", 0, 18));
       
       // menu optioms
       tb =new JToolBar();
       tb.setBackground(java.awt.Color.LIGHT_GRAY);
       tb.setLayout(new GridLayout(10,0));
       JLabel lb=new JLabel("ማስተካከያ");
       lb.setFont(new Font("Nyala", 0, 18));
       JPanel co=new JPanel();
       JLabel c1=new JLabel("የጽሁፍ ቀለም");
       c1.setFont(new Font("Nyala", 0, 18));
       co.setLayout(new GridLayout(2,0));
       color=new JComboBox(coloritems);
       color.setFont(new Font("Nyala", 0, 16));
       color.setBackground(java.awt.Color.cyan);
       
        JPanel bk=new JPanel();
       JLabel c2=new JLabel("ጀርባ ቀለም");
       c2.setFont(new Font("Nyala", 0, 18));
       c2.setBackground(java.awt.Color.cyan);
       bk.setLayout(new GridLayout(2,0));
       bkcolor=new JComboBox(bakcolor);
       bkcolor.setFont(new Font("Nyala", 0, 16));
       bkcolor.setBackground(java.awt.Color.cyan);
    
    JPanel ff=new JPanel();
       JLabel c3=new JLabel("መጻፊያ አማራጮች");
       c3.setFont(new Font("Nyala", 0, 18));
       c3.setBackground(java.awt.Color.cyan);
       ff.setLayout(new GridLayout(2,0));
        ffont=new JComboBox(fontitems);             //color.setFont(font);
        ffont.setSelectedItem("ALXethiopian");
        ffont.setBackground(java.awt.Color.cyan);
        txa.setFont(new Font("ALXETHIOPIAN",s,30));
//for my size jslider start
        size=new JSlider(10,50);
        size.setOrientation(JSlider.HORIZONTAL);
        size.setMinorTickSpacing(1);
        size.setMajorTickSpacing(10);
        size.setPaintLabels(true);
        size.setPaintTicks(true);  
//end of slider options
        plain= new JButton("ንፁህ");
        plain.setFont(new Font("Nyala", 0, 18));
        bold= new JButton("አወፍር");
        bold.setFont(new Font("Nyala", 0, 18));
        italic= new JButton("አንጋድ");
        italic.setFont(new Font("Nyala", 0, 18));
        underline= new JButton("አስምር");
        underline.setFont(new Font("Nyala", 0, 18));
        JPanel pn=new JPanel();
        pn.setLayout(new FlowLayout(FlowLayout.LEFT));
        txa.setLineWrap(true);
        pn.add(plain);
        pn.add(bold);
        pn.add(italic);
        pn.add(underline);
        tb.add(lb);
        tb.add(size);
        
        ff.add(c3);
        ff.add(ffont);        
        tb.add(ff);
        
        co.add(c1);
        co.add(color);     
        tb.add(co);
        
        bk.add(c2);
        bk.add(bkcolor);
        tb.add(bk);
        
 
        tb.add(pn);
         
        JLabel empty=new JLabel(" ");
        tb.add(empty);
        //object info
        JPanel lo=new JPanel();
        lo.setLayout(new GridLayout(2,0));
        JLabel ob1=new JLabel("ስለ ፋይሉ መረጃ");
       ob1.setFont(new Font("Nyala", 0, 18));
       lo.add(ob1);
       JPanel lo2=new JPanel();
       lo2.setLayout(new GridLayout(3,2));
       
      
           //object info
       JLabel name=new JLabel("By");
        na = new JTextField("", 14); 
        na.setEditable(false); 
       JLabel ca=new JLabel("created date");
        tfCount = new JTextField("", 14); //tfCount,la,pas,stat
        tfCount.setEditable(false); 
       JLabel da=new JLabel("last edited date");
        la = new JTextField("", 14); 
        la.setEditable(false); 
       JLabel pa=new JLabel("password");
        pas = new JTextField("", 14); 
        pas.setEditable(false);
        
       JLabel sta=new JLabel("editable");
            
        stat = new JTextField("", 10);
        stat.setEditable(false);
        cont=new JButton("More");
        
        lo2.add(name);
        lo2.add(na);
        lo2.add(pa);
        lo2.add(pas);
        lo2.add(ca);
        lo2.add(tfCount);
        
        JPanel lo3=new JPanel();
       lo3.setLayout(new GridLayout(3,2));
        lo3.add(da);
        lo3.add(la);
        lo3.add(sta);
        lo3.add(stat);
        lo3.add(cont);
        tb.add(lo);
        tb.add(lo2);
        tb.add(lo3);
        file.add(New);
        file.add(Open); 
        file.add(Save);
        file.add(SaveAs);
        file.add(Close);
        
        help.add(devdetail);
        help.add(how);
        
        menubar.add(file);
        menubar.add(help);
        
        frame.add(menubar,BorderLayout.NORTH);
        frame.add(scrlp,BorderLayout.CENTER);
        frame.add(tb,BorderLayout.EAST);
        
        frame.setSize(1140, 650);
        frame.setVisible(true);
        frame.setFont(new Font("Nyala", 0, 48));
        frame.setTitle("ያልተሰየመ - ቃላት መጻፊያ");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        size.addChangeListener((ChangeEvent e) -> {
            JSlider size1 = (JSlider) e.getSource();
            if (!size1.getValueIsAdjusting()) {
                int sii = size1.getValue();
                fman.selectfont(ffont.getSelectedItem().toString(), s, sii);
                txa.setFont(fman.getfont());
            }
        });
        
        New.addActionListener(this);
        Open.addActionListener(this);
        Save.addActionListener(this);
        SaveAs.addActionListener(this);
        Close.addActionListener(this);
        devdetail.addActionListener(this);
        how.addActionListener(this);
        color.addActionListener(this);
        ffont.addActionListener(this);
        bkcolor.addActionListener(this);
        txa.addKeyListener( this);
       plain.addActionListener(this);
       bold.addActionListener(this);
       italic.addActionListener(this);
       underline.addActionListener(this);
       cont.addActionListener(this);
       //short key
       Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK,true));
       Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK,true));
      New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK,true));
         
}
     
    @Override
    public void keyTyped(KeyEvent e)
   {
       if(!(txa.getText().isEmpty()))
           modified=true;
       else
           modified=false;
   }
     @Override
    public void keyPressed(KeyEvent e) {
       //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
         //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == plain){
          s=0;
          fman.selectfont(ffont.getSelectedItem().toString(), s, size.getValue());
          txa.setFont(fman.getfont());
        }if (e.getSource() == bold){
            s=1;
            fman.selectfont(ffont.getSelectedItem().toString(), s, size.getValue());
            txa.setFont(fman.getfont());
        }if (e.getSource() == italic){
            s=2;
            fman.selectfont(ffont.getSelectedItem().toString(), s, size.getValue());
            txa.setFont(fman.getfont());
        }if(e.getSource()==underline){
            //wait a bit
           // txa.
           
            Map<TextAttribute, Integer> fontAttributes = new HashMap<>();
           fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
             
          txa.setFont(fman.getfont().deriveFont(fontAttributes));
         
        }if(e.getSource() == cont){
            
            JFrame cooo = new JFrame();
            cooo.setLayout(new GridLayout(2,2));
            
            
                    cooo.setSize(550, 400);
                    cooo.setLocation(200, 200);
                    
                    JLabel names=new JLabel("names of file editors");
                    edna = new JTextArea(); 
                    edna.setEditable(false); 
                    JLabel times=new JLabel("dates of file edited");
                    edti = new JTextArea(); 
                    edti.setEditable(false); 
                    cooo.add(names);
                    cooo.add(edna);
                    cooo.add(times);
                    cooo.add(edti);
                    
                    cooo.setResizable(false);
                    cooo.setVisible(true);
        }if(e.getSource() == Open){
            open();
        }if(e.getSource()==New){
            New();
        }if(e.getSource()==Save){
            
            if(frame.getTitle().equals("ያልተሰየመ - ቃላት መጻፊያ"))
            save();
            else{
                ObjectOutputStream os = null;
                try {
                    os = new ObjectOutputStream(
                            new FileOutputStream(filename));
                    try {
                        os.writeUTF(txa.getText());
                    } catch (IOException ex) {
                        Logger.getLogger(MYWORDAPP.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    os.writeObject(secObject);
                    secObject.setDate(new Date());
                    la.setText(secObject.date.toString());
/**                     int b=secObject.editorUserName.length;
        int v=secObject.editorUserName.length;
         for(int i=0;i<b;i++){
          edna.setText(secObject.editorUserName[i]);
         edna.setText(" ,");}
         for(int i=0;i<v;i++){
          edti.setText(secObject.dateEdited[i]);
         edna.setText(" ,");} */
                    os.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MYWORDAPP.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MYWORDAPP.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        secObject.setDate(new Date());
                        la.setText(secObject.date.toString());
                  /**      int b=secObject.editorUserName.length;
         int v=secObject.editorUserName.length;
         for(int i=0;i<b;i++){
          edna.setText(secObject.editorUserName[i]);
         edna.setText(" ,");}
         for(int i=0;i<v;i++){
          edti.setText(secObject.dateEdited[i]);
         edna.setText(" ,");}*/
                        os.close();
                    } catch (IOException ex) {
                        Logger.getLogger(MYWORDAPP.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
                
        }if(e.getSource()==SaveAs){
            save();
        }if(e.getSource()==Close){
            isModified();
            if(isModified()==1){
                ObjectOutputStream os = null;
                try {
                    os = new ObjectOutputStream(
                            new FileOutputStream(filename));
                    try {
                        os.writeUTF(txa.getText());
                    } catch (IOException ex) {
                        Logger.getLogger(MYWORDAPP.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    os.writeObject(secObject);
                    secObject.setDate(new Date());
                    la.setText(secObject.date.toString());

                    os.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MYWORDAPP.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MYWORDAPP.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        secObject.setDate(new Date());
                        la.setText(secObject.date.toString());
                 
                        os.close();
                        System.exit(0);
                    } catch (IOException ex) {
                        Logger.getLogger(MYWORDAPP.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }}
                
            System.exit(0);
            
        }if(e.getSource()==devdetail){
            
            JFrame rt = new JFrame();
            rt.setLayout(new BorderLayout());
            JPanel fr = new JPanel();
                    rt.setSize(450, 300);
                    rt.setLocation(200, 200);
              //      JLabel img=new JLabel(icon.newfile);
                    fr.setLayout(new GridLayout(7, 2));
                    JLabel lname = new JLabel("  ስም");
                    lname.setFont(new Font("Nyala", 0, 18));
                    JLabel name2 = new JLabel("  ሰለሞን ጥጋቡ");
                    name2.setFont(new Font("Nyala", 0, 18));
                    JLabel id = new JLabel("  መለያ ቁጥር");
                    id.setFont(new Font("Nyala", 0, 18));
                    JLabel id1 = new JLabel("BDU-1010981");
                    JLabel dept = new JLabel("  Department");
                    JLabel dept1 = new JLabel("Software Engineering");
                    JLabel phn = new JLabel(" ስልክ ቁጥር ");
                    phn.setFont(new Font("Nyala", 0, 18));
                    JLabel phn1 = new JLabel("+251-923214663");
                    JLabel email = new JLabel("  ኢሜል");
                    email.setFont(new Font("Nyala", 0, 18));
                    JLabel email1 = new JLabel("SolTig66@gmail.com");
                    fr.add(lname);
                    fr.add(name2);
                    fr.add(id);
                    fr.add(id1);
                    fr.add(dept);
                    fr.add(dept1);
                    fr.add(phn);
                    fr.add(phn1);
                    fr.add(email);
                    fr.add(email1);
                    
                    
                     ImageIcon icon;
                    JLabel ico = new JLabel("        \n \n\n\n");
                   
            icon = new ImageIcon("D:\\2ND YEAR JAVA PROJECTS\\MY WORD APP\\APB.ico");
                    rt.setIconImage(icon.getImage());
                    
                    JLabel ico1 = new JLabel("        \n \n");
                    ico.setIcon(new ImageIcon("D:\\2ND YEAR JAVA PROJECTS\\MY WORD APP\\APB.ico"));
                    
                    rt.add(ico,BorderLayout.NORTH);
                    rt.add(ico1,BorderLayout.WEST);
                    rt.add(fr,BorderLayout.CENTER);
                    rt.setResizable(false);
                    rt.setVisible(true);
            
        }if(e.getSource()==how){
           // MYWORDAPP initDial=MYWORDAPP.findProgram("a.html");
           Runtime ru=Runtime.getRuntime();
            try {
                ru.exec("C:\\Program Files\\Internet Explorer\\iexplore");
            } catch (IOException ex) {
                Logger.getLogger(MYWORDAPP.class.getName()).log(Level.SEVERE, null, ex);
            }
           
           
        }if(e.getSource()==ffont){
             fman.selectfont(ffont.getSelectedItem().toString(), s, size.getValue());
         txa.setFont(fman.getfont());
            
        }if(e.getSource()==color){
            
            colman.selectcolor(color.getSelectedItem().toString());
            txa.setForeground(colman.getcolor());
        }if(e.getSource()==bkcolor){
            
            bgcoman.selectbgcolor(bkcolor.getSelectedItem().toString());
            txa.setBackground(bgcoman.getbgcolor());
        }
        
    }
    
   
    
     public int isModified()
   {
       int x=JOptionPane.showConfirmDialog(frame, "The text in the "+frame.getTitle()+" has changed\nDo you want to save it", "Notepad", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
        switch (x) {
            case JOptionPane.YES_OPTION:
                return 1;
            case JOptionPane.NO_OPTION:
                return 2;
            default:
                return 3;
        }
   }


    
    

     void save() {
        FileDialog fd;
        fd = new FileDialog(this.frame, "Save", FileDialog.SAVE);
        initDial = JOptionPane.showInputDialog(Save, "Password", "የይለፍ ቃል አስገባ", s);
        fd.setFont(new Font("Nyala", 0, 48));
        fd.setVisible(true);
        
        
        
        if (fd.getFile() != null) {

            filename = fd.getDirectory() + fd.getFile().concat(".SolTig");
            frame.setTitle(filename);
        }
        secObject = new object(initDial, new Date(), System.getProperty("user.name"),true);
          na.setText(secObject.username);    //tfCount,la,pas,stat
          tfCount.setText(secObject.created.toString());
          la.setText(secObject.date.toString());
          pas.setText(secObject.password);
          String a;
           if(secObject.status==true){
               a="True";
           }else a="False";
          stat.setText(a);
     
    /**     int b=(int)secObject.getDateEdited().length;
         int v=(int)secObject.getEditorUserName().length;
         String g=Arrays.toString(secObject.getDateEdited()),p=Arrays.toString(secObject.getEditorUserName());
      edna.setText(g);
      edti.setText(p);
           for(int i=0;i<b;i++){
          edna.setText(secObject.editorUserName[i]);
         edna.setText(" ,");}
         for(int i=0;i<v;i++){
          edti.setText(secObject.getdateEdited[i]);
         edna.setText(" ,");} */
          
        try {
            try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename))) {
                os.writeUTF(txa.getText());
                os.writeObject(secObject);
            }
        } catch (IOException ex) {
            System.out.println("file not found");
        }
    }
    
     void open() {
        FileDialog fd = new FileDialog(this.frame, "Open", FileDialog.LOAD);
        fd.setVisible(true);
        if (fd.getFile() != null) {
            filename = fd.getDirectory() + fd.getFile();
            initDial = JOptionPane.showInputDialog(Open,"enter pass", "የይለፍ ቃል አስገባ", WIDTH);
        }
        try {
            FileInputStream of = new FileInputStream(filename);
            try (ObjectInputStream os = new ObjectInputStream(of)) {
                String temp = os.readUTF();
                secObject=new object();
                secObject = (object) os.readObject();
                if (initDial.equals(secObject.password)) {
                    frame.setTitle(filename);
                    txa.setText(temp);
                    int a = txa.getDocument().getLength();
                    
                } else {
                    JOptionPane.showMessageDialog(Open, "Incorrect password");
                }
                na.setText(secObject.username);    //tfCount,la,pas,stat
             tfCount.setText(secObject.created.toString());
             la.setText(secObject.date.toString());
             pas.setText(secObject.password);
             String a;
             if(secObject.status==true){
               a="True";
             }else a="False";
             stat.setText(a);
            }
     /**       int b=secObject.editorUserName.length;
         int v=secObject.editorUserName.length;
         for(int i=0;i<b;i++){
          edna.setText(secObject.editorUserName[i]);
         edna.setText(" ,");}
         for(int i=0;i<v;i++){
          edti.setText(secObject.dateEdited[i]);
         edna.setText(" ,");}*/
        } catch (IOException | ClassNotFoundException ex) {
        }

    }
         void New() {
        File file = new File(frame.getTitle());
        if (!(file.exists())) {
            if (modified==true) {
                
                
                int a = JOptionPane.showConfirmDialog(Open, "Would you like to save the file", "WARNNING", 1, 3);
                     

                if (a == 0) {
                    save();
                } else {
                    txa.setText(null);
                    frame.setTitle("ያልተሰየመ - ቃላት መጻፊያ");
                    
                }
            }
        }
        txa.setText(null);
        frame.setTitle("ያልተሰየመ - ቃላት መጻፊያ");
    }
    
     
public static void main(String[] args) {
        MYWORDAPP mywordapp = new MYWORDAPP();
    }

   
}