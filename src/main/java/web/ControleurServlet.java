package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.IMusiqueDao;
import dao.MusiqueDaoImpl;
import metier.entities.Musique;


@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.do" })
public class ControleurServlet extends HttpServlet {
    IMusiqueDao metier;

    @Override
    public void init() throws ServletException {
        metier = new MusiqueDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/index.do")) {
            request.getRequestDispatcher("musiques.jsp").forward(request, response);
        } else if (path.equals("/chercher.do")) {
            String motCle = request.getParameter("motCle");
            MusiqueModele model = new MusiqueModele();
            model.setMotCle(motCle);
            List<Musique> musiques = metier.musiquesParMC(motCle);
            model.setMusiques(musiques);
            request.setAttribute("model", model);
            request.getRequestDispatcher("musiques.jsp").forward(request, response);
        } else if (path.equals("/saisie.do")) {
            request.getRequestDispatcher("saisieMusique.jsp").forward(request, response);
        } else if (path.equals("/save.do") && request.getMethod().equals("POST")) {
            String titre = request.getParameter("titre");
            double duree = Double.parseDouble(request.getParameter("duree"));
            Musique m = metier.save(new Musique(titre, duree));
            request.setAttribute("musique", m);
            response.sendRedirect("chercher.do?motCle=");
        } else if (path.equals("/supprimer.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            metier.deleteMusique(id);
            response.sendRedirect("chercher.do?motCle=");
        } else if (path.equals("/editer.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            Musique m = metier.getMusique(id);
            request.setAttribute("musique", m);
            request.getRequestDispatcher("editerMusique.jsp").forward(request, response);
        } else if (path.equals("/update.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            String titre = request.getParameter("titre");
            double duree = Double.parseDouble(request.getParameter("duree"));
            Musique m = new Musique();
            m.setIdMusique(id);
            m.setTitre(titre);
            m.setDuree(duree);
            metier.updateMusique(m);
            response.sendRedirect("chercher.do?motCle=");
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}