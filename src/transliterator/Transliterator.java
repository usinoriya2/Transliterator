/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transliterator;
import java.io.*;
/**
 *
 * @author Wrath
 */
public class Transliterator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        String shc,shv,sec,sev;
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\users\\Wrath\\desktop\\utf.txt"),"UTF-8"));

        BufferedWriter engOut= new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\users\\Wrath\\desktop\\output.txt",false),"UTF-8"));
        //BufferedWriter dualOut= new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\users\\Wrath\\desktop\\temp.txt",false),"UTF-8"));
        String a;
        shv="इिअेोृुआैउूओ-ॅऑ.ॉए&ौऋऊऐ१२३४५६७८९०औऍॐ॑";
        sev="i  i  a  e  o  ri u  aa a  u  oo o  -  a  au .  o  e  &  au ri oo ai 1  2  3  4  5  6  7  8  9  0  au a  om a  ";
        
        shc="डयरवनदकजलमड़बगतसपणटधशषफहभचज़थफ़ग़ठढ़घखझक़ञःछख़ढऱय़";   
        sec="d  y  r  w  n  d  k  j  l  m  d  b  g  t  s  p  n  t  dh sh sh f  h  bh ch z  th f  g  th dh gh kh jh q  y  h  chhkh dh r  y  ";
        
        while( (a = in.readLine()) != null){
            
          //engOut.write(a + " = ") ;
          //engOut.flush();
            
        boolean cons = false;
        for(int i = 0; i < a.length();i++)
        {
            //System.out.println(a.charAt(i));
            
            //if (Character. a.charAt(i)){}
            
            if(a.charAt(i)=='﻿') continue;
            if(a.charAt(i)=='्'){
                cons=false;
                if((i == a.length() -2) && a.charAt(i+1) =='र') {int x = shc.indexOf(a.charAt(i+1));engOut.write(sec.substring(3*(x), 3*(x) +3).trim() + "a");engOut.flush(); break;}
                continue;
            }
            
            if("इउओऑईऊऐ".indexOf(a.charAt(i))!=-1){
                if (cons) engOut.write("a");
                //int x = shv.indexOf(a.charAt(i));
                //engOut.write(sev.substring(3*(x), 3*(x)+3).trim());
                cons = false;
                //engOut.flush();
                //continue;
            }
         
            if((int)(a.charAt(i)) <200){
                engOut.write(a.charAt(i));
                cons=false;
                continue;
            }
            
            if(a.charAt(i)==' ') {
                engOut.write(" ");
                cons=false;
                engOut.flush();
                continue;
            }
            
            if( a.charAt(i)=='ं'|| a.charAt(i)=='ँ'){
                char c = 'n';
                if( (i == a.length() - 1) || ("मबपभफ़".indexOf(a.charAt(i+1) ) != -1)) c = 'm';
                if (cons) engOut.write("a" + c); else engOut.write(c);
                cons = false;
                engOut.flush();
                continue;
                
            }
            
            
            if (a.charAt(i) =='ा'){
                if ((i == a.length() - 1) || (a.charAt(i+1)== ' ')) engOut.write("a"); else engOut.write("aa");
                cons=false;
                engOut.flush();
                continue;
            }

            if (a.charAt(i) =='ी' || a.charAt(i) =='ई'){
                if ((i == a.length() - 1) || (a.charAt(i+1)== ' ')) engOut.write("i"); else engOut.write("ee");
                cons=false;
                engOut.flush();
                continue;
            }
            
            if (a.charAt(i) =='ू'){
                if ((i == a.length() - 1) || (a.charAt(i+1)== ' ')) engOut.write("u"); else engOut.write("oo");
                cons=false;
                engOut.flush();
                continue;
            }


            int x = shc.indexOf(a.charAt(i));
            
            //System.out.println(x);
            
            if ( x !=-1) {
                
                    if (cons) engOut.write("a");
                    engOut.write(sec.substring(3*(x), 3*(x) +3).trim());
                    //System.out.println(sec.substring(3*x, 3*x +3).trim());
                    cons =true;
                    
                
                
            } else{
                x = shv.indexOf(a.charAt(i));
                if ( x !=-1){
                    engOut.write(sev.substring(3*(x), 3*(x)+3).trim());
                    cons = false;
                } else {engOut.write("?"); cons= false;}
            }
            engOut.flush();
        }
        engOut.write("\r\n");
        engOut.flush();
        }
    engOut.close();
    in.close();
    }
    
    
}
