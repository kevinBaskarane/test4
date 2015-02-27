package kevinProjet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
// class de configuration du logger.
public class Configuration  {

	static logger log = new logger();
	public static void readConfiguration(String conf){
		HashMap<String, String> map = new HashMap<String, String>();
				
				HashMap<String, ArrayList <String>> cible = new HashMap<String, ArrayList <String>>();
				ArrayList <String> list = new ArrayList<String>();
				ArrayList <String> value = new ArrayList<String>();
				String oldValue ;
				String path="";
				String oldkey = null;
				String[] data1;
				String levelmod = null;
				String line;
				String message="";
				String name="";
				String formateur = null;
				Properties properties = new Properties();
				try {
					FileInputStream in = new FileInputStream(conf);
					BufferedReader br = new BufferedReader(new InputStreamReader(in,"UTF-8"));
					while ((line = br.readLine()) != null) {
						list.add(line);
					}
					for(String nom : list){
						if(nom.contains("name")){
							log.getlogger(nom.split("=")[1]);
							name=nom;
						}
						if(nom.contains("level")){	
						levelmod=nom;
						}
						if(nom.contains("message")){
						 message=nom;
						}
						if(nom.contains("formater")){
						formateur=nom;	
						}
						if(nom.contains("cible")){
							data1 = nom.split("cible");
							  if(nom.contains("path")){
								     data1 =  nom.split("cible");
								     data1= data1[1].split("\\.");
								     oldkey=data1[0].toString();
							  }else{
		                       data1= data1[1].split("=");
							  }
		                       if(oldkey!=data1[0].toString().trim()){
		                    	   oldkey=data1[0];
		                    	    value = new ArrayList<String>();
		                       }
		                           if(nom.contains("path")){
		                    	   value.add(data1[1]+"."+data1[2]);
		                           }else{
		                            value.add(data1[1]);   
		                           }
		                           oldkey=data1[0].toString().trim();
						           cible.put(oldkey, value);
		                     }			
						}
					
					ArrayList<String>valeur=new ArrayList<String>();
					for(Entry<String, ArrayList<String>> entry : cible.entrySet()) {
					    String cle = entry.getKey();
					    valeur = entry.getValue();
					    if(valeur.toString().trim().contains("ConsoleCible")){
					    	ajouterCible(name.split("=")[1], new ConsoleCible());
					    	setLayout(name.split("=")[1],new formater(),formateur.split("=")[1]);
					    	setLevel(name.split("=")[1],message.split("=")[1],levelmod.split("=")[1].toString().trim());
					    }
					    if(valeur.toString().trim().contains("FileCible")){
					    	ArrayList<String> val=valeur;
					    	path=val.get(1);
					    	ajouterCible(name.split("=")[1], new FileCible(path.split("=")[1].toString().trim()));
					    	setLayout(name.split("=")[1],new formater(),formateur.split("=")[1]);
				    	    setLevel(name.split("=")[1],message.split("=")[1],levelmod.split("=")[1].toString().trim());
					    	
					    	
					    	
					    }
					}
						
					in.close();	
				} catch (IOException e) {
					System.out.println("Unable to load config file.");
				}
				
			}
	
	// methode d' ajout de la cible. 
	public static void ajouterCible(String classe,Object cons){
		log.addHandler(cons);
		
	}
	// methode d'ajout du layout.
	public static void setLayout(String classe,formater form , String format){
	log.format(form,format);
		
	}
    // methode d ajout du Level.
	public static void setLevel(String classe,String conf,String lev){
        if(lev.equals("INFO")){
        	log.info(conf);;
        }
		if(lev.equals("DEBUG")){
			log.debug(conf);
		}
		if(lev.equals("ERROR")){
			log.error(conf);
		}
	}
	
	
}
