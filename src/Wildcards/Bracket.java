package Wildcards;

public class Bracket extends Wildcard {
	public String joint(){
		return "(";
	}
	
	public boolean matches(String word, int jointIndex){
		return (jointIndex==0);
	}
}
