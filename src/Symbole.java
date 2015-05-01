import enumeration.Mode;
import enumeration.Nature;
import enumeration.Type;


public class Symbole {
	private Type type;
	private Mode mode;
	private Nature nature;
	private int adresse;
	private int taille;

	public Symbole(Type type, Mode mode, Nature nature, int adresse, int taille){
		setType(type);
		setMode(mode);
		setNature(nature);
		setAdresse(adresse);
		setTaille(taille);
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public int getAdresse() {
		return adresse;
	}

	public void setAdresse(int valeur) {
		this.adresse = valeur;
	}

	public Nature getNature() {
		return nature;
	}

	public void setNature(Nature nature) {
		this.nature = nature;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public String toString(){
		String res = "";
		String tmp;
		int size = 5;
		//Type
		tmp=getType().toString();
		if(tmp.length()<=size) tmp+="\t";
		res+=tmp+"\t| ";
		//Mode
		tmp=getMode().toString();
		if(tmp.length()<=size+3) tmp+="\t ";
		res+=tmp+" | ";
		//Nature
		tmp=getNature().toString();
		//if(tmp.length()<=size) tmp+="\t";
		res+=tmp+"\t| ";
		//Valeur
		tmp=String.valueOf(getAdresse());
		if(tmp.length()<=size) tmp+="\t";
		res+=tmp+"\t| ";
		//Taille
		tmp=getTaille()+"";
		if(tmp.length()<=size) tmp+="\t";
		res+=tmp+"\t|";

		return res;
	}
}
