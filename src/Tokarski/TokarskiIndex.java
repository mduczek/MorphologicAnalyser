package Tokarski;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class TokarskiIndex {
	protected HashMap<String, Deque<TokarskiObj> > data;
	protected Line line;
	
	public TokarskiIndex(Line useLine){
		data = new HashMap<String, Deque<TokarskiObj> >(100);
		line = useLine;
	}
	
	public void load(String path){
		try {
			Scanner s_plik = new Scanner(new File(path));
			while(s_plik.hasNext()){
				if(line.read(s_plik.nextLine()) ){
					Deque<TokarskiObj> tokObject = data.get(line.getKey());
					if(tokObject == null){
						tokObject = new LinkedList<TokarskiObj>();
						tokObject.add(new TokarskiObj(line.getForm(),line.getEnding(), line.getAdditionalForm()));
						data.put(line.getKey(), tokObject);
					}else{
						tokObject.add(new TokarskiObj(line.getForm(),line.getEnding(), line.getAdditionalForm()));
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("cannot find the file with TokarskiIndex");
		}
	}
	public Deque<TokarskiObj> get(String str){
		return data.get(str);
	}
	public void print(){
		Set<String> setKey = data.keySet();
		for(String key : setKey){
			Deque<TokarskiObj> kolejka = data.get(key);
			System.out.print("/");
			for(TokarskiObj elem : kolejka){
				System.out.println(key +" "+ elem.gramForm +" "+ elem.ending);
			}
		}
			
	}
}