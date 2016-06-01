package com.totoro.findLost;

import java.io.FileWriter;
import java.io.IOException;

public class creatFileNum 
{
    public static void main( String[] args )
    {
        //创建一个FileWriter对象
        FileWriter fw;
        FileWriter fwSub;
		try {
			fw = new FileWriter("all.txt");
			fwSub = new FileWriter("sub.txt");
	        //遍历clist集合写入到fileName中
	        Integer i = 1;
	        while (i < 10000000) {
	        	fw.write(String.format("%08d", i++));
	            fw.write("\n");
	            if(i%10000 == 0) {
	            	System.out.println(i);
	            }
	            if(i == 9990000 || i == 5) {
	            	continue;
	            }
	            fwSub.write(String.format("%08d", i));
	            fwSub.write("\n");
			}
	        //刷新缓冲区
	        fw.flush();
	        fwSub.flush();
	        //关闭文件流对象
	        fw.close();
	        fwSub.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("End");
    }
}
