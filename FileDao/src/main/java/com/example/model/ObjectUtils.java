package com.example.model;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectUtils {

	public static int sizeof(Object obj) {
		Integer sizeinBytes = null;
	    ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
	    ObjectOutputStream objectOutputStream;
		try {
			objectOutputStream = new ObjectOutputStream(byteOutputStream);
			objectOutputStream.writeObject(obj);
			objectOutputStream.flush();
			objectOutputStream.close();
			sizeinBytes = byteOutputStream.toByteArray().length;
		} catch (IOException e) {
			e.printStackTrace();
		} 
	    return sizeinBytes;
	}
	
	/**
	 * Salva o objeto serializado em arquivo no disco.
	 * @param obj - Objeto a ser escrito no disco
	 * @param filename - Caminho completo do arquivo
	 */
	public static void saveToDisk(Object obj, String filepath) {
		try { 
			// Write to disk with FileOutputStream
			FileOutputStream fileOutputStream = new FileOutputStream(filepath);
	
			// Write object with ObjectOutputStream
			ObjectOutputStream objectOutputStream = new ObjectOutputStream (fileOutputStream);
	
			// Write object out to disk
			objectOutputStream.writeObject (obj);
			
			// close resources
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
	/**
	 * Restaura um objecto serializado do disco
	 * @param filepath
	 * @return
	 */
	public static Object loadFromDisk(String filepath) {
		Object obj = null;
		try { 
			// Read from disk using FileInputStream
			FileInputStream fileInputStream = new FileInputStream(filepath);
	
			// Read object using ObjectInputStream
			ObjectInputStream objectInputStream = new ObjectInputStream (fileInputStream);
	
			// Read an object
			obj = objectInputStream.readObject();
			
			// Close resources
			fileInputStream.close();
			objectInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
}
