package enumeration;

public enum Nature {
	FONCTION,PROCEDURE,VARIABLE,PARAM,TABLEAU;
	
	public static Nature get(String nature){
		if(nature.equals("fonction"))
			return Nature.FONCTION;
		else if(nature.equals("procedure"))
			return Nature.PROCEDURE;
		else if(nature.equals("variable"))
			return Nature.VARIABLE;
		else if(nature.equals("param"))
			return Nature.PARAM;
		else
			return Nature.TABLEAU;
	}
	
	public static String toString(Nature nature){
		if(nature==Nature.FONCTION)
			return "fonction";
		else if(nature==Nature.PROCEDURE)
			return "procedure";
		else if(nature==Nature.VARIABLE)
			return "variable";
		else if(nature==Nature.PARAM)
			return "param";
		else
			return "tableau";
	}
}
