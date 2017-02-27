package transliterator;
import java.io.*;
import java.io.FileReader;
public class MakeTable {
	public static void main(String[]args)throws Exception{
            
            BufferedWriter engOut= new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\users\\Wrath\\desktop\\table.txt",false),"UTF-8"));
            String shc,shv,sec,sev,sv,sc;
                    shv="इिअेोृुआैउूओ-ॅऑ.ॉए&ौऋऊऐ१२३४५६७८९०औऍॐ॑";
        sev="i  i  a  e  o  ri u  aa a  u  oo o  -  a  au .  o  e  &  au ri oo ai 1  2  3  4  5  6  7  8  9  0  au a  om a  ";
        
        shc="डयरवनदकजलमड़बगतसपणटधशषफहभचज़थफ़ग़ठढ़घखझक़ञःछख़ढऱय़";   
        sec="d  y  r  v  n  d  k  j  l  m  d  b  g  t  s  p  n  t  dh sh sh f  h  bh ch z  th f  g  th dh gh kh jh q  y  h  chhkh dh r  y  ";
        sv="इउओऑईऊऐ";
        sc="मबपभफ़";
              

            engOut.write(shc+"\r\n"+shv +"\r\n"+sec+"\r\n"+sev+  "\r\n" + sv + "\r\n" + sc + "\r\n\r\n" + "Don't edit this file. This is the file used by the program to convert hindi characters to english. This file should be placed in the \"Current Directory\" of the execution environment.");
            engOut.flush();
            engOut.close();
		    	}
}
