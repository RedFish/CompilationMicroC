/**
 * 
 * Permet de gérer les registres.
 *
 */

import java.util.Arrays;

public class Registres
{
	private int nombresRegistres;
	private int[] registres;
	private int decalage;

	public Registres(int nombreRegistres, int decalage)
	{
		this.nombresRegistres = nombreRegistres;
		this.decalage = decalage;
		registres = new int[nombreRegistres];
		for (int i = 0; i < nombreRegistres; i++)
			registres[i] = 1;
	}
	
	// Vrai si il reste un registre, faux sinon
	public boolean resteUnRegistre()
	{
		boolean res = false;
		for (int i=0; i<nombresRegistres; i++)
		{
			if (registres[i] == 1)
			{
				res = true;
				break;
			}
		}
		return res;
	}

	// Retourne un registre disponible
	public int getRegistreLibre()
	{
		int res = 0;
		for (int i=0; i<nombresRegistres; i++)
			if (registres[i] == 1)
			{
				res = i;
				registres[i] = 0;
				break;
			}
		return res + decalage;
				
	}
	
	// Permet de dire qu'un registre est disponible pour la suite
	public void libererRegiste(int registre)
	{
		registres[registre - decalage] = 1;
	}

	// Permet de dire qu'un registre est indisponible pour la suite
	public void prendreRegistre(int registre)
	{
		registres[registre - decalage] = 0;
	}

	@Override
	public String toString()
	{
		return "Registres [registres=" + Arrays.toString(registres) + "]";
	}
}
