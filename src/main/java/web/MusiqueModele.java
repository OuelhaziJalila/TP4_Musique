package web;

import java.util.ArrayList;
import java.util.List;

public class MusiqueModele<Musique> {
    private String motCle;
    private List<Musique> musiques = new ArrayList<>();
    
    public String getMotCle() { return motCle; }
    public void setMotCle(String motCle) { this.motCle = motCle; }
    public List<Musique> getMusiques() { return musiques; }
    public void setMusiques(List<Musique> musiques) { this.musiques = musiques; }
}