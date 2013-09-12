import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {
	protected HashMap<String, String> data;
	
	public Dictionary(){
		data = new HashMap<String, String>(100);
	}
	
	public void read(String path){
		try {
			Scanner s_plik = new Scanner(new File(path));
			String linia;
			while(s_plik.hasNext()){
				linia = s_plik.nextLine();
				String fields [] =linia.split(" ");
				if(fields.length>1){
					data.put(fields[0], fields[1]);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("cannot find the file with dictionary");
		}
	}
	public String get(String str){
		return data.get(str);
	}
}
