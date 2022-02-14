package com.example.model;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;

public class Data {
	byte[] bytes = { 0x10, 0x20, 0x30, 0x40 };
	char[] chars = { 'a', 'b', 'c', 'd'} ;
	byte[] cbuf;
	
	public Data(){
		try {
			cbuf = FileUtils.readFileToByteArray(new File("c:/temp/texto3.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return String.format("Data [bytes=%s, chars=%s, cbuf=%s]", Arrays.toString(bytes), Arrays.toString(chars),
				Arrays.toString(cbuf));
	}

}
