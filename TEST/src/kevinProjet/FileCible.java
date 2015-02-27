package kevinProjet;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileCible {
	private String path = null;
	
	FileCible(String path){
		this.path=path;
	}
	
	public void FileCibleout(String msg){
			try {
				PrintWriter fichier = new PrintWriter(new FileWriter(path,true));
				fichier.println(msg);
				fichier.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
	}

}
