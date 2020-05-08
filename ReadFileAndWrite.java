import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;


public class ReadFileAndWrite{
    public static void main(String[] args)throws IOException{
        //1.每一行的内容读取出来存在list<String>集合
        //1.1 集合对象
        List<String> list = new ArrayList<String>();
        //1.2一行行读取文件
        BufferedReader br = new BufferedReader(new FileReader("/Users/aa404863/Desktop/text.txt"));
        String line =null;
        while((line=br.readLine())!=null){//读取一个字符串
            list.add(line);
        }
        //2.当我们要写入文件时，倒序保存list集合中的内容到文件中
        BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/aa404863/Desktop/text_new.txt"));
        for(int i= list.size()-1;i>=0;i--){
            bw.write(list.get(i));
            bw.newLine();//换行
            System.out.println(list.get(i));
            //System.out.println(“\r\n”);
            
        }
        br.close();
        bw.close();
       //System.out.println("finished");
        
    }
}