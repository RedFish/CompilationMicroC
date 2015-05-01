package enumeration;

public enum Mode {
	DIRECT,INDIRECT,DOUBLE_INDIRECT;
	
	public static Mode get(String mode){
		if(mode.equals("direct"))
			return Mode.DIRECT;
		else if(mode.equals("indirect"))
			return Mode.INDIRECT;
		else
			return Mode.DOUBLE_INDIRECT;
	}
	
	public static String toString(Mode mode){
		if(mode==Mode.DIRECT)
			return "direct";
		else if(mode==Mode.INDIRECT)
			return "indirect";
		else
			return "double_indirect";
	}
}
