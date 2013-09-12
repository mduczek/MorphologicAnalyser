package Tokarski;

public interface Line {
	
	public String getKey();
	//gramatical forms
	public String getForm();
	public String getAdditionalForm();
	//ending with wildcards removed
	public String getEnding();
	//returns true if a line is a comment
	public boolean comment(String str);
	//returns true only if a line is suitable to be added to the index
	public boolean read(String str);

}
