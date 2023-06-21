package certus.edu.pe.modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "personal")
@Data
@AllArgsConstructor
@NoArgsConstructor

//@NamedQueries({	@NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p")	, @NamedQuery(name  = "Personal.findByIdPersonal", query = "SELECT p FROM Personal p WHERE p.idpersonal = :idpersonal")	, @NamedQuery(name  = "Personal.findByNombre", query = "SELECT p FROM Personal p WHERE p.nombre = :nombre")	, @NamedQuery(name  = "Personal.findByDni", query = "SELECT p FROM Personal p WHERE p.dni = :dni")	, @NamedQuery(name  = "Personal.findByCargo", query = "SELECT p FROM Personal p WHERE p.cargo = :cargo")	, @NamedQuery(name  = "Personal.findByImagen", query = "SELECT p FROM Personal p WHERE p.imagen = :imagen")})

public class Personal implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = true)
	private Integer idpersonal;
	
	@Basic(optional = false)
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "dni")
	private Integer dni;
	
	@Column(name = "cargo")
	private String cargo;
	
	@Column(name = "imagen")
	private String imagen;


}
