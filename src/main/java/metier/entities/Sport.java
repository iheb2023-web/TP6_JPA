package metier.entities;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Sport implements Serializable {

    @Id
    @Column(name = "IDSport")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSport;

    @Column(name = "NOMSport")
    private String nomSport;

    private String description;
    @Temporal(TemporalType.DATE)
    private Date dateFondation;
    
    
    private Genre genre;
    
    public Sport( String nomSport, String description, Date dateFondation) {
		super();
		this.nomSport = nomSport;
		this.description = description;
		this.dateFondation = dateFondation;

	}
    public Sport( String nomSport, String description, Date dateFondation, Genre gen) {
		super();
		this.nomSport = nomSport;
		this.description = description;
		this.dateFondation = dateFondation;
    	this.setGenre(gen);

	}

    public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Long getIdSport() {
		return idSport;
	}
	public void setIdSport(Long idSport) {
		this.idSport = idSport;
	}
	public String getNomSport() {
		return nomSport;
	}
	public void setNomSport(String nomSport) {
		this.nomSport = nomSport;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateFondation() {
		return dateFondation;
	}
	public void setDateFondation(Date dateFondation) {
		this.dateFondation = dateFondation;
	}
	public Sport() {
        super();
    }  	
	
	public Long getIdParoduit() {
        return idSport;
    }

    public void setIdProduit(Long idSport) {
        this.idSport = idSport;
    }

    public String getNomProduit() {
        return nomSport;
    }

    public void setNomProduit(String nomProduit) {
        this.nomSport = nomProduit;
    }
	
    
    
    
}
