package kevinProjet;

import java.io.Console;

public class logger {
	static String classeName = "";
	static String SimpleDateFormat = "";
	static formater form ;
	static String format = "";
    static ConsoleCible cons1;
    static FileCible file;
    private static Boolean choixConsole= false;
    private static Boolean choixFILE= false;
	public static void getlogger(Object msg) {
		classeName = msg.toString();
	}
	public static void format(formater formater,String forma) {
		form = formater;
		format=forma;
	}
	public static void format(String forma) {
		form = new formater();
		format=forma;
	}

	public static void info(String msg) {
		form.setFormat(format, classeName, level.INFO.toString(), msg);
		if(choixConsole){
		cons1.ConsoleCible(form.getFormat());
		}
		
		if(choixFILE){
			file.FileCibleout(form.getFormat());
			}
		
	}

	public static void error(String msg) {
		form.setFormat(format, classeName, level.ERROR.toString(), msg);
		if(choixConsole){
			cons1.ConsoleCible(form.getFormat());
			}
		if(choixFILE){
			file.FileCibleout(form.getFormat());
			}

	}

	public static void debug(String msg) {
		form.setFormat(format, classeName, level.DEBUG.toString(), msg);
		if(choixConsole){
			cons1.ConsoleCible(form.getFormat());
			}
		if(choixFILE){
			file.FileCibleout(form.getFormat());
			}
	}

	public static void addHandler(Object cons) {
//		if (msg.equals("fr.esia.ConsoleCible")) {
//			cons.ConsoleCible(form.getFormat());
		if(cons instanceof ConsoleCible){
		  cons1=(ConsoleCible)cons;
		  choixConsole=true;
		}
		
		if(cons instanceof FileCible){
			file=(FileCible)cons;
			choixFILE=true;
		}

	}
	
	public static void addHandler(String msg,String arg) {
		if (msg.equals("ConsoleCible")) {
			cons1 = new ConsoleCible();
			choixConsole=true;
			}
		
		if (msg.equals("FileCible")) {
			file = new FileCible(arg);
			choixFILE=true;
			}
		

	}
	
}
