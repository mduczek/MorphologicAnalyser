package Wildcards;

public class Consonant extends Wildcard {
	
	public String joint(){
		return "(";
	}
	public final String vowels = "aąeęioóuy";
	
	public boolean matches(String word, int jointIndex){
		return (jointIndex>0)&&(vowels.indexOf(word.charAt(jointIndex-1), 0)==-1);
		
	}
}
