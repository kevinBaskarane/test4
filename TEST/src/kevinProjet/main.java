package kevinProjet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore.Entry;
import java.util.Map.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

public class main {

	public static void main(String[] args) {
		handler();

	}

	private static void handler() {
		// TODO Auto-generated method stub
		// mode fichier properties
		 String appPATH = System.getProperty("user.dir");
		 String configPath = appPATH + "\\src\\A.Properties";
		 Configuration.readConfiguration(configPath);
		
		// mode java code
		 logger.getlogger(main.class); // associer nom du logger 
		 logger.addHandler("ConsoleCible","");// definir la cible 1
		 logger.addHandler("FileCible","C:/Users/baskaranes/log9.txt");// definir cible numero 2 
		 logger.format("[NAME=%NAME LEVEL=%LEVEL MESSAGE=%MESSAGE]");// definir le format 
		 logger.info("Test log ESIEA");
		 logger.error("lolo");
		 logger.error("Test log ESIEA");		
	}

}
