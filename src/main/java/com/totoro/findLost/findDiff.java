package com.totoro.findLost;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class findDiff {

	public static void main(String[] args) {
		System.out.println("Start");
		BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("UTF-8")), 10000000, 0.0000001);
		try {
			System.out.println("开始读取sub文件并生成二进制向量...");
			long startTime=System.currentTimeMillis();
	        FileReader reader = new FileReader("sub.txt");
	        BufferedReader br = new BufferedReader(reader);
	        String str = null;
	        while((str = br.readLine()) != null) {
	        	bloomFilter.put(str);
	        }
			br.close();
			reader.close();
			long endTime=System.currentTimeMillis();
			System.out.println("读取sub文件生成二进制向量结束");
			System.out.println("读取文件用时：" + (endTime-startTime)/1000 +"s");
			
			System.out.println("开始读取all文件并进行检测...");
			startTime=System.currentTimeMillis();
			reader = new FileReader("all.txt");
			br = new BufferedReader(reader);
			str = null;
			while((str = br.readLine()) != null) {
				boolean mayBeContained = bloomFilter.mightContain(str);
				if(!mayBeContained){
					System.out.println(str);
				}
	        }
			br.close();
			reader.close();
			endTime=System.currentTimeMillis();
			System.out.println("检测all文件结束");
			System.out.println("检测用时：" + (endTime-startTime)/1000 +"s");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("End");

	}

}
