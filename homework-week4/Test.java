package com.geekbang.learntowrite;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author xz
 * @create 2022-06-27 21:49
 */
public class Test2 {
    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        //创建文件

        System.out.println("请输入文件名：");
        String fileName = in.nextLine().trim();
        File file = new File("." + File.separator + fileName + ".txt");
        if(!file.exists()){
            file.createNewFile();
            System.out.println(file.getName()+"文件已创建！");
        }
        //写入文件
        try{
            FileOutputStream fo = new FileOutputStream(file); // 造流
            OutputStreamWriter osw = new OutputStreamWriter(fo, StandardCharsets.UTF_8);
            // TODO 使用PrintWriter，可以方便的写入一行字符
            PrintWriter pw = new PrintWriter(osw);
            System.out.println("输入的内容会实时写入文件");
                String lineToWrite = in.nextLine().trim();
                System.out.println("写入内容为：" + lineToWrite);
            byte []buy = lineToWrite.getBytes();
            fo.write(buy);
            fo.close();
            //读取文件
            FileInputStream fi = new FileInputStream(file);

            byte []byt = new byte[2014]; //读数据
            int len = fi.read(byt); // fi.read(byt)返回字节数组byt的字节数
            System.out.println("读出文件的信息是：" + new String(byt,0,len));
            fi.close();
        }catch(Exception E){
            E.printStackTrace();
        }
    }
}
