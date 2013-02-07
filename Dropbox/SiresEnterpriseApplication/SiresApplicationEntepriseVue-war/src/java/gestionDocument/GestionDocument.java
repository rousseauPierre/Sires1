package gestionDocument;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class GestionDocument
{
	private String titre;
	private String texte;
	private boolean ouvert;
	
	private static final String cheminDocuments = "/home/pierre/Dropbox/data/documents/";
	
	public GestionDocument()
	{
		titre = "";
		texte = "";
		ouvert = false;
	}
	
	public GestionDocument(String titre, String texte)
	{
		this.titre = titre;
		this.texte = texte;
		this.ouvert = false;
	}
	
	public File creerFichier(String chemin, String titre)
	{
		File dossier = new File(chemin);
		
		if (!dossier.exists())
		{
			dossier.mkdirs();
		}
		
		File retour = new File(chemin, titre);
		return retour;
	}
	
	public void commit()
	{
		GregorianCalendar calendrier = new GregorianCalendar();
		
		String date = calendrier.get(Calendar.DATE)+"-";
		date+=(calendrier.get(Calendar.MONTH)+1)+"-";
		date+=calendrier.get(Calendar.YEAR)+"-";
		
		if (calendrier.get(Calendar.AM_PM) == 1)
			date+=(calendrier.get(Calendar.HOUR)+12)+"_";
		else
			calendrier.get(Calendar.HOUR);
			
		date+=calendrier.get(Calendar.MINUTE)+"_";
		date+=calendrier.get(Calendar.SECOND);
		File f = creerFichier(cheminDocuments + "releases/", titre + "-" + date + ".txt");
		
		try
		{
			f.createNewFile();
			FileWriter fw = new FileWriter(f);
			fw.flush();
			fw.write(texte);
			fw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void temp()
	{
		GregorianCalendar calendrier = new GregorianCalendar();
		
		String date = calendrier.get(Calendar.DATE)+"-";
		date+=(calendrier.get(Calendar.MONTH)+1)+"-";
		date+=calendrier.get(Calendar.YEAR)+"-";
		
		if (calendrier.get(Calendar.AM_PM) == 1)
			date+=(calendrier.get(Calendar.HOUR)+12)+"_";
		else
			calendrier.get(Calendar.HOUR);
			
		date+=calendrier.get(Calendar.MINUTE)+"_";
		date+=calendrier.get(Calendar.SECOND)+"_";
		date+=calendrier.get(Calendar.MILLISECOND);
		
		File f = creerFichier(cheminDocuments + "temp/", titre + "-" + date + ".txt");
		
		try
		{
			f.createNewFile();
			FileWriter fw = new FileWriter(f);
			fw.flush();
			fw.write(texte);
			fw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static GestionDocument getDocument(String titre, String version)
	{
		String titreComplet = titre + "-" + version;
		File f = new File(cheminDocuments + "releases/" + titreComplet + ".txt");
                System.out.println(f);
                String texte = "";
		
		try
		{
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine())
			{
				texte += sc.nextLine();
			}
			sc.close();
                        System.out.println(texte);
                }
		catch (FileNotFoundException e)
		{
			System.out.println("Fichier non trouvé!");
		}
		
		return new GestionDocument(titre, texte);
	}

    
	public static GestionDocument getLastVersion(String titre)
	{
		File f = new File(cheminDocuments + "releases/");
		File[] listeFichiers = f.listFiles();
		String[] versions = new String[listeFichiers.length];
		
		int j = 0;
		
		for (int i = 0; i < listeFichiers.length; i++)
		{
			if (listeFichiers[i].getAbsolutePath().substring(listeFichiers[i].getAbsolutePath().lastIndexOf(File.separator)
					+ 1, listeFichiers[i].getAbsolutePath().lastIndexOf(File.separator)+ titre.length() + 1).equals(titre))
			{
				versions[j] = listeFichiers[i].getAbsolutePath()
						.substring(listeFichiers[i].getAbsolutePath().lastIndexOf(File.separator)
								+titre.length()+2,listeFichiers[i].getAbsolutePath().length()-4);
				j++;
			}
		}
		
		String last = versions[0];
		
		for (int i = 1; i < versions.length; i++)
		{	
			if(compareDate(versions[i],last) == 1)
			{
				last = versions[i];
			}
		}
		
		return new GestionDocument(titre, last);
	}
	
	private static int compareDate(String date1, String date2)
	{
		String[] tab1 = date1.split("-");
		String[] tab2 = date2.split("-");
		
		if(Integer.parseInt(tab1[0]) >= Integer.parseInt(tab2[0]) &&
				Integer.parseInt(tab1[1]) >= Integer.parseInt(tab2[1]) &&
				Integer.parseInt(tab1[2]) >= Integer.parseInt(tab2[2]))
		{
			String[] heure1 = tab1[3].split("_");
			String[] heure2 = tab2[3].split("_");
			
			if (Integer.parseInt(heure1[0]) >= Integer.parseInt(heure2[0]) &&
					Integer.parseInt(heure1[1]) >= Integer.parseInt(heure2[1]) &&
					Integer.parseInt(heure1[2]) > Integer.parseInt(heure2[2]))
			{
				return 1;
			}
		}
		
		return 0;
	}
	
	public String getTitre()
	{
		return titre;
	}
	
	public void setTitre(String titre)
	{
		this.titre = titre;
	}
	
	public String getTexte()
	{
		return texte;
	}
	
	public void setTexte(String texte)
	{
		this.texte = texte;
	}
	
	public boolean isOuvert()
	{
		return ouvert;
	}
	
	public void ouvrir()
	{
		this.ouvert = true;
	}
	
	public void fermer()
	{
		this.ouvert = false;
	}
	
	public String toString()
	{
		return "Document [titre=" + titre + ", texte=" + texte + ", ouvert="
				+ ouvert + "]";
	}
	
	public static void main(String[] args)
	{
		GestionDocument d = new GestionDocument("Test","Adfgbhjwdxkgfqk");
		d.commit();
		d.temp();
		
                
		System.out.println(GestionDocument.getLastVersion("Test"));
	}
}
