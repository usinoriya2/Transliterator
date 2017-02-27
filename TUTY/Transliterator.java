
/*
 * CS-101 Project
 * Hindi to English Transliterator
*/


import java.io.*;

class Transliterator {

    public static void main(String[] args){

        try{
            String shc,shv,sec,sev,sv,sc;
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"),"UTF-8"));
            BufferedReader table = new BufferedReader(new InputStreamReader(new FileInputStream("table.txt"),"UTF-8"));
            shc = table.readLine();
            shv=table.readLine();
            sec = table.readLine();
            sev = table.readLine();
            sv = table.readLine();
            sc = table.readLine();
            
            table.close();

            BufferedWriter engOut= new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt",false),"UTF-8"));

            String a;

            while( (a = in.readLine()) != null){


            boolean cons = false;
            for(int i = 0; i < a.length();i++)
            {

                if(a.charAt(i)==65279) continue;
                if(a.charAt(i)==2381){
                    cons=false;
                    if((i == a.length() -2) && a.charAt(i+1) ==2352) {int x = shc.indexOf(a.charAt(i+1));engOut.write(sec.substring(3*(x), 3*(x) +3).trim() + "a");engOut.flush(); break;}
                    continue;
                }

                if(sv.indexOf(a.charAt(i))!=-1){
                    if (cons) engOut.write("a");
                    cons = false;
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

                if( a.charAt(i)==2306|| a.charAt(i)==2305){
                    char c = 'n';
                    if( (i == a.length() - 1) || (sc.indexOf(a.charAt(i+1) ) != -1)) c = 'm';
                    if (cons) engOut.write("a" + c); else engOut.write(c);
                    cons = false;
                    engOut.flush();
                    continue;

                }


                if (a.charAt(i) ==2366){
                    if ((i == a.length() - 1) || (a.charAt(i+1)== ' ')) engOut.write("a"); else engOut.write("aa");
                    cons=false;
                    engOut.flush();
                    continue;
                }

                if (a.charAt(i) ==2368 || a.charAt(i) ==2312){
                    if ((i == a.length() - 1) || (a.charAt(i+1)== ' ')) engOut.write("i"); else engOut.write("ee");
                    cons=false;
                    engOut.flush();
                    continue;
                }

                if (a.charAt(i) ==2370){
                    if ((i == a.length() - 1) || (a.charAt(i+1)== ' ')) engOut.write("u"); else engOut.write("oo");
                    cons=false;
                    engOut.flush();
                    continue;
                }


                int x = shc.indexOf(a.charAt(i));


                if ( x !=-1) {

                        if (cons) engOut.write("a");
                        engOut.write(sec.substring(3*(x), 3*(x) +3).trim());
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
    catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
