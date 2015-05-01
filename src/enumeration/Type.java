package enumeration;

public enum Type {
	INT,CHAR,VOID;
	
	public static Type get(String type){
		if(type.equals("int"))
			return Type.INT;
		else if(type.equals("char"))
			return Type.CHAR;
		else
			return Type.VOID;
	}
	
	public static String toString(Type type){
		if(type==Type.INT)
			return "int";
		else
			return "char";
	}
}
