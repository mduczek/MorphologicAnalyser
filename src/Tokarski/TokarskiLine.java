package Tokarski;


public class TokarskiLine implements Line {

	private String fields [];
	private String wildcards;
	private String additionalForm;
	
	public TokarskiLine(String usedWildcards){
		wildcards = usedWildcards;
	}
	
	@Override
	public String getKey() {
		return fields[1];
	}

	@Override
	public String getForm() {
		return fields[2];
	}

	@Override
	public String getEnding() {
		return fields[3];
	}

	@Override
	public boolean comment(String str) {
		return (str!=null)&&(str.charAt(0)=='%');
	}

	@Override
	public boolean read(String str) {
		if(comment(str)){
			return false;
		}
		fields = str.split(";");
		if(fields.length==5 && fields[1].length()!=0 && fields[2].length()!=0){
			int indexSp = fields[2].indexOf(' ');
			if(indexSp!=-1){
				additionalForm = fields[2].substring(indexSp+1);
				fields[2] = fields[2].substring(0, indexSp);
			}else{
				return false;
			}
			if(fields[3].length()==0 || fields[3].charAt(0)=='*'){
				fields[3]=fields[1];
			}
			fields[3] = fields[3].replaceAll("["+wildcards+"]", "");
			if( fields[3].compareTo( fields[3].replaceAll("[^a-ząęćęłńóśżź]", "") ) ==0){
				return true;
			}else{
				System.out.println("invalid line: " + str);
				return false;
			}
				
		}else{
			//wrong line
			System.out.println("invalid line: " + str);
			return false;
		}
	}

	@Override
	public String getAdditionalForm() {
		return additionalForm;
	}

}
