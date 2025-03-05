package test;

import java.util.List;

import dao.MusiqueDaoImpl;
import metier.entities.Musique;

public class TestMetier {
	public static void main(String[] args) {
		
        MusiqueDaoImpl metier = new MusiqueDaoImpl();
	
		Musique musique=new Musique("Imagine", 3.15);
		System.out.println(musique);
	
	System.out.println(musique);
    List<Musique> musiques = metier.musiquesParMC("Bohemian");
	for (Musique m : musiques) {
		System.out.println(m);

	}
}
}