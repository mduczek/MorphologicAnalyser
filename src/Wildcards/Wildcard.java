package Wildcards;

public abstract class Wildcard {
	
	public String joint(){
		return "";
	}
	
	public boolean matches(String word, int jointIndex){
		return jointIndex>=0;
	}
	public int hashCode(){
		return joint().hashCode();
	}
	public boolean equals(Object obj){
		if(!(obj instanceof Wildcard)) return false;
		Wildcard u = (Wildcard) obj;
		return joint().compareTo(u.joint())==0;
	}
	
	
}
