package Wildcards;

public class DashVowel extends Wildcard {
	
	public String joint(){
		return "-V";
	}
	public final String vowels = "aąeęioóuy";
	
	public boolean matches(String word, int jointIndex){
		return (jointIndex == 0)||(jointIndex>1 && (vowels.indexOf(word.charAt(jointIndex-1), 0)!=-1));
	}
}
