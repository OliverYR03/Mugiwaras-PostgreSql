package certus.edu.pe.modelo;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="opiniones")
@NamedQueries({
	@NamedQuery(name = "Opiniones.findAll", query = "SELECT p FROM Opiniones p")
	, @NamedQuery(name  = "Opiniones.findByIdOpinion", query = "SELECT p FROM Opiniones p WHERE p.idopinion = :idopinion")
	, @NamedQuery(name  = "Opiniones.findByIdPlato", query = "SELECT p FROM Opiniones p WHERE p.idplato = :idplato")
	, @NamedQuery(name  = "Opiniones.findByNombre", query = "SELECT p FROM Opiniones p WHERE p.idcliente = :idcliente")
	, @NamedQuery(name  = "Opiniones.findByDescripcion", query = "SELECT p FROM Opiniones p WHERE p.calificacion = :calificacion")
	, @NamedQuery(name  = "Opiniones.findByPrecio", query = "SELECT p FROM Opiniones p WHERE p.comentario = :comentario")
	, @NamedQuery(name  = "Opiniones.findByTipoPlato", query = "SELECT p FROM Opiniones p WHERE p.fecha = :fecha")
})

public class Opiniones implements Serializable{

	private static final long serialVersionUID = 1L;

		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = true)
		private Integer idopinion;
		
		@Basic(optional = true)
	    @Column(name ="idplato")
		private Integer idplato;
		
		@Basic(optional = true)
	    @Column(name ="idcliente")
		private Integer idcliente;
	    
	    @Column(name ="calificacion")
		private Integer calificacion;
	    
	    @Column(name ="comentario")
		private String  comentario;
	    
	    @Column(name ="fecha")
		private String  fecha;
	    
	    public Opiniones() {
	    	
	    }

		public Opiniones(Integer idopinion, Integer idplato, Integer idcliente, Integer calificacion, String comentario,
				String fecha) {
			super();
			this.idopinion = idopinion;
			this.idplato = idplato;
			this.idcliente = idcliente;
			this.calificacion = calificacion;
			this.comentario = comentario;
			this.fecha = fecha;
		}

		public Integer getIdopinion() {
			return idopinion;
		}

		public void setIdopinion(Integer idopinion) {
			this.idopinion = idopinion;
		}

		public Integer getIdplato() {
			return idplato;
		}

		public void setIdplato(Integer idplato) {
			this.idplato = idplato;
		}

		public Integer getIdcliente() {
			return idcliente;
		}

		public void setIdcliente(Integer idcliente) {
			this.idcliente = idcliente;
		}

		public Integer getCalificacion() {
			return calificacion;
		}

		public void setCalificacion(Integer calificacion) {
			this.calificacion = calificacion;
		}

		public String getComentario() {
			return comentario;
		}

		public void setComentario(String comentario) {
			this.comentario = comentario;
		}

		public String getFecha() {
			return fecha;
		}

		public void setFecha(String fecha) {
			this.fecha = fecha;
		}

		@Override
		public String toString() {
			return "Opiniones [idopinion=" + idopinion + ", idplato=" + idplato + ", idcliente=" + idcliente
					+ ", calificacion=" + calificacion + ", comentario=" + comentario + ", fecha=" + fecha + "]";
		}
	    
	    
}
	
