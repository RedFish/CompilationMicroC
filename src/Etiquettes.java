/**
 * 
 * Permet de gérer les étiquettes
 *
 */

public class Etiquettes
{
	private int numeroEtiquetteSuivante;
	
	public Etiquettes()
	{
		this.numeroEtiquetteSuivante = 0;
		numeroEtiquetteSuivante++;
	}
	
	public String getEtiquetteSuivante()
	{
		String res = "Etiquette" + numeroEtiquetteSuivante;
		numeroEtiquetteSuivante++;
		return res;
	}
}