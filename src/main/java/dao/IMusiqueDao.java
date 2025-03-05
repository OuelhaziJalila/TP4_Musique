package dao;

import java.util.List;
import metier.entities.Musique;

public interface IMusiqueDao {
	public Musique save(Musique m);

	public List<Musique> musiquesParMC(String mc);


	public Musique getMusique(Long id);

	public Musique updateMusique(Musique m);

	public void deleteMusique(Long id);
}


