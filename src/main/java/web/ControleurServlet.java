package web;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.IGenreDao;
import dao.ISportDao;
import dao.GenreDaoImpl;
import dao.SportDaoImpl;
import metier.entities.Genre;
import metier.entities.Sport;

@WebServlet(name = "ControleurServlet", urlPatterns = { "/controleur", "*.do" })
public class ControleurServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ISportDao metierSport;
    private IGenreDao metierGenre;

    @Override
    public void init() throws ServletException {
        metierSport = new SportDaoImpl();
        metierGenre = new GenreDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        
        if(path.equals("/index.do")){
			request.getRequestDispatcher("sports.jsp").forward(request, response);
        }
        
        
        else if (path.equals("/chercher.do")) {
            String motCle = request.getParameter("motCle");
            List<Sport> sports = metierSport.sportParMC(motCle);
            
            SportModele model = new SportModele(); // Instanciez votre modèle
            model.setMotCle(motCle);
            model.setSp(sports); // Utilisez setSport() pour définir la liste de sports
            
            request.setAttribute("model", model); // Ajoutez le modèle à la requête
            request.getRequestDispatcher("sports.jsp").forward(request, response);
        }
        
        
        
        
        else if (path.equals("/saisie.do")) {
            List<Genre> genres = metierGenre.getAllCategories();
            GenreModel model= new GenreModel();
			model.setGenres(genres);
            request.setAttribute("genres", genres);
            
            request.getRequestDispatcher("saisieSport.jsp").forward(request, response);
            
        }
        
        else if (path.equals("/save.do") && request.getMethod().equals("POST")){
            String nom = request.getParameter("nom");
            String description = request.getParameter("description");
            Date dateFondation = null;
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            try {
                dateFondation = simpleDateFormat.parse(request.getParameter("date_fondation"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Long genreId = Long.parseLong(request.getParameter("genre"));
            Genre genre = metierGenre.getGenre(genreId);
            Sport sport = metierSport.save(new Sport(nom, description, dateFondation, genre));
            request.setAttribute("sport", sport);
            response.sendRedirect("chercher.do?motCle=");
            
            
        } else if (path.equals("/supprimer.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			metierSport.deleteSport(id);
			response.sendRedirect("chercher.do?motCle=");
        } 
        
        else if (path.equals("/editer.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            Sport sport = metierSport.getSport(id);
            request.setAttribute("sport", sport);
            List<Genre> genres = metierGenre.getAllCategories();
            GenreModel model = new GenreModel();
            model.setGenres(genres);
            request.setAttribute("genres", genres);
            request.getRequestDispatcher("editerSport.jsp").forward(request, response);
        } 
        
        else if (path.equals("/update.do")) {
			Date dateSp = new Date();

            Long id = Long.parseLong(request.getParameter("id"));
            String nom = request.getParameter("nom");
            String description = request.getParameter("description");
            Sport sport = new Sport();
            
            sport.setIdSport(id);
            sport.setNomSport(nom);
            sport.setDescription(description);
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            
           
            try {
                dateSp = 
                		simpleDateFormat.parse(request.getParameter("date_fondation"));
                
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
            sport.setDateFondation(dateSp);

            Long genreId = Long.parseLong(request.getParameter("genre"));
            Genre genre = metierGenre.getGenre(genreId);
            sport.setGenre(genre);
            metierSport.updateSport(sport);
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
