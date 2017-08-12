/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catcherr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author vudung
 */
public class err {
    public static String onlyNumber(String s){
        if(s == null || s.trim().isEmpty()){
            return "Please enter salary";
        }
        s=s.trim();
        s=s.replace("\\s+", "");
        Pattern p=Pattern.compile("[^0-9,.]");
        Matcher m=p.matcher(s);
        boolean b=m.find();
        if(b==true){
            return "Please enter numerical type";
        }
        
        
        return "";
    }
    public static void copyFile(String path,String path2, String name){
        try{
           File filetocopy=new File(path); 
           FileInputStream inputstream=new FileInputStream(filetocopy);
           FileChannel inChannel=inputstream.getChannel();
           
           //File newfile= new File("/Users/vudung/Documents/demo/web/assets/img/faces/"+name);
           File newfile2=new File(path2);
           
           //FileOutputStream outputStream=new FileOutputStream(newfile);
           FileOutputStream outputStream2=new FileOutputStream(newfile2);
           //FileChannel outChannel=outputStream.getChannel();
           FileChannel outChannel2=outputStream2.getChannel();
           
           //inChannel.transferTo(0, filetocopy.length(), outChannel);
           inChannel.transferTo(0, filetocopy.length(), outChannel2);
           File filetocopy2=new File(path);
           filetocopy2.delete();
           inputstream.close();
           //outputStream.close();
           outputStream2.close();
           //outChannel.close();
           outChannel2.close();
           
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        
        //err.copyFile("code.jpg");
        //generate random UUIDs
    
    }
}
