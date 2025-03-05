package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.entities.Musique;

public class MusiqueDaoImpl implements IMusiqueDao {
    @Override
    public Musique save(Musique m) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO musiques(TITRE, DUREE) VALUES(?, ?)");
            ps.setString(1, m.getTitre());
            ps.setDouble(2, m.getDuree());
            ps.executeUpdate();
            
            PreparedStatement ps2 = conn.prepareStatement("SELECT MAX(ID_MUSIQUE) as MAX_ID FROM musiques");
            ResultSet rs = ps2.executeQuery();
            if (rs.next()) {
                m.setIdMusique(rs.getLong("MAX_ID"));
            }
            ps.close();
            ps2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

    @Override
    public List<Musique> musiquesParMC(String mc) {
        List<Musique> musiques = new ArrayList<>();
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM musiques WHERE TITRE LIKE ?");
            ps.setString(1, "%" + mc + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Musique m = new Musique();
                m.setIdMusique(rs.getLong("ID_MUSIQUE"));
                m.setTitre(rs.getString("TITRE"));
                m.setDuree(rs.getDouble("DUREE"));
                musiques.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musiques;
    }
    
    @Override
    public Musique getMusique(Long id) {
        Connection conn = SingletonConnection.getConnection();
        Musique m = new Musique();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM musiques WHERE ID_MUSIQUE = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                m.setIdMusique(rs.getLong("ID_MUSIQUE"));
                m.setTitre(rs.getString("TITRE"));
                m.setDuree(rs.getDouble("DUREE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }
    
    @Override
    public Musique updateMusique(Musique m) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE musiques SET TITRE=?, DUREE=? WHERE ID_MUSIQUE=?");
            ps.setString(1, m.getTitre());
            ps.setDouble(2, m.getDuree());
            ps.setLong(3, m.getIdMusique());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }
    
    @Override
    public void deleteMusique(Long id) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM musiques WHERE ID_MUSIQUE = ?");
            ps.setLong(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}