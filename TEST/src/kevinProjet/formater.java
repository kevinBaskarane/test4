package kevinProjet;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class formater {
	String format;

	public String getFormat() {
		return format;
	}

	public void setFormat(String format,String nom ,String level,String msg) {
		Date today = Calendar.getInstance().getTime();
		 SimpleDateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
		 String dateFormater= formatter.format(today);
 		this.format= dateFormater+format.replace("%NAME", nom).replace("%LEVEL", level).replace("%MESSAGE",msg);
	}

}
