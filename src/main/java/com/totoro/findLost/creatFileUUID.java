package com.totoro.findLost;

import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class creatFileUUID 
{
    public static void main( String[] args )
    {
        FileWriter fw;
        FileWriter fwSub;
		try {
			fw = new FileWriter("all.txt");
			fwSub = new FileWriter("sub.txt");
	        Integer i = 1;
	        String addTmp = "";
	        while (i < 10000000) {
	        	String tmp = UUID.randomUUID().toString();
	        	fw.write(tmp);
	            fw.write("\n");
	            if(i%10000 == 0) {
	            	System.out.println(i);
	            }
	            i++;
	            if(i == 9999999 || i == 1|| i == 2|| i == 5) {
	            	addTmp = addTmp + "\n" + tmp;
	            	continue;
	            }
	            fwSub.write(tmp);
	            fwSub.write("\n");
			}
	        System.out.println("漏掉的值为:\n" + addTmp);
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

//5580b174-7bc0-4467-b93c-77357bebe09a
//7d1d2a39-5bbd-41c6-8e1c-510bdb737117
//a5c330c3-c4c8-4d09-bbea-953b72ade990