package com.famsa.aplicacion;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.famsa.exceptions.ImageCaptureExc;

public class ImageCapture {

	static final Logger logger = Logger.getLogger(ImageCapture.class.getName());
	static FileHandler fileHandler;

	public static void main(String[] args) throws ImageCaptureExc {
    	
		boolean continua = false;
		
		try {
			continua = ImageCapture.inicio(args);
		} catch (ImageCaptureExc e) {
			throw new ImageCaptureExc(e.toString(), e);
		}

		if (continua) {
			int i = 0;
			for (int j=0;j<10;j++) {
				i=i+1;
			}
		} else {
			logger.log(Level.INFO, "SIN PROCESAR INFORMACION.");
		}
		
		fileHandler.close();
	}
	
    private static boolean inicio(String[] args) throws ImageCaptureExc {
    	
		String nomArc = String.format("%s.log",	ImageCapture.class.getName());
		
		try {
			fileHandler = new FileHandler(nomArc);
		} catch (SecurityException | IOException e1) {
			throw new ImageCaptureExc(e1.toString(), e1);
		}

		logger.addHandler(fileHandler);
		SimpleFormatter formatter = new SimpleFormatter();
		fileHandler.setFormatter(formatter);
		fileHandler.setLevel(Level.ALL);
		logger.setLevel(Level.ALL);		

		boolean regreso = false;
		
    	String parametros = null;
        for (String s: args) {
        	parametros = s;
        }
        if (parametros==null) {
        	logger.log(Level.INFO, "FALTA INFORMACION PARA CONTINUAR CON EL PROCESO.");
        } else if (parametros.equals("-i") || parametros.equals("-I")) {
        	logger.log(Level.INFO, "COMANDO EJECUTADO CORRECTAMENTE.");
        } else if (parametros.equals("-p") || parametros.equals("-P")) {
        	regreso=true;
        }

		return regreso;
    }
	

}