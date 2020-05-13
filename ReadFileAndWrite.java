//package com.ibm.tsdl.training;//package:In order to better organize the class
package tsdl.training;
//ファイルシステムによるシステム入出力用に提供package
//package for File system input&output
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

public class ReadFileAndWrite{//Only need one public interface
    public static void main(String[] args)throws IOException{//if it is finished, it will return -1.This method throws IOException
        try{
            Scanner scan = new Scanner(System.in);
            This_File file = new This_File();//creat object
            System.out.println("please enter your file path");
            file.file_path=scan.next();
            file.ReadFile();
            List<String> new_list = new ArrayList<String>();
            new_list = file.ReadFile();
            System.out.println("Do you want to save new content in new file? Yes or No");
            Scanner scan_res = new Scanner(System.in);
            String s = scan_res.next();
            if(s.equals("Yes") == true){
                
                Roleback_File newfile = new Roleback_File();
                System.out.println("please enter your new file path");
                Scanner scan_new = new Scanner(System.in);
                //Roleback_File newfile = new Roleback_File();
                newfile.newfile_path = scan_new.next();
                //newfile.newfile_path="/Users/aa404863/Documents/JavaProj/text_new.txt";
                newfile.WriteFile(new_list);
            }else{
                Roleback_File newfile = new Roleback_File();
                newfile.PrintFile(new_list);
            }
        }catch (FileNotFoundException e) {
        System.out.print("Please check this file path one more time");
        }
    }
}

class This_File{
    //1.read and save in list<String> 
    String file_path;
    public List<String> ReadFile() throws IOException{ 

        List<String> list = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(this.file_path));
        String line = null;
        while((line = br.readLine()) != null){//read the String by Line）
            list.add(line);
        }
        br.close();//close the br
        return list;
        
    }

}

class Roleback_File{
    String newfile_path;
    public void WriteFile(List<String> new_list) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(this.newfile_path));
        for(int i = new_list.size()-1;i>=0;i--){
            bw.write(new_list.get(i));
            bw.newLine();
            System.out.println(new_list.get(i));
            //System.out.println(“\r\n”); 
        }
        bw.close();//close the bw
    }
    public void PrintFile(List<String> new_list)throws IOException {
        for(int i = new_list.size()-1;i>=0;i--){
            System.out.println(new_list.get(i));
        }
    }

}