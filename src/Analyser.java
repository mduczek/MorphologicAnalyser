import java.util.Deque;
import java.util.Set;

import javax.naming.directory.InvalidAttributesException;

import Tokarski.TokarskiIndex;
import Tokarski.TokarskiObj;
import Wildcards.Wildcard;

public class Analyser {

	protected Dictionary dict;
	protected TokarskiIndex indexTok;
	protected Set<Wildcard> wildcardSet;
	private boolean notFound;
	
	public Analyser(Dictionary dict, TokarskiIndex index, Set<Wildcard> wildcardSet) throws InvalidAttributesException {
		if(dict!=null && index != null && wildcardSet != null){
			this.dict = dict;
			this.wildcardSet = wildcardSet;
			indexTok = index;
		}else{
			throw new InvalidAttributesException();
		}
			
	}
	public void analyse(String str){
		notFound = true;
		for(int i=0; i<str.length(); i++){
			for(Wildcard w : wildcardSet){
				if(w.matches(str, i))
					algorithm(str.substring(0, i), w.joint(), str.substring(i));	
			}
		}
		if(notFound){
			System.out.println(":"+str+":<?>:<?>:<?>");
		}
		
	}
	void algorithm(String begining, String joint, String ending){
		Deque<TokarskiObj> endingList = indexTok.get(joint + ending);
		if(endingList!=null){
			for(TokarskiObj line : endingList){
				String form = dict.get(begining+line.ending);
				if(form != null && line.gramForm.compareTo(form)==0){
					System.out.println(":"+begining+ending+":"+begining+line.ending+":"+line.gramForm+":"+line.additionalForm);
					notFound = false;
				}
			}
		}
	}
}
