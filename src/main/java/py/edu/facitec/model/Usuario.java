		package py.edu.facitec.model;
		import javax.persistence.Entity;
		import javax.persistence.Id;
		import javax.persistence.GeneratedValue;
		import javax.persistence.GenerationType;
		import java.time.LocalDate;
		import com.fasterxml.jackson.annotation.JsonFormat;
		
/**
* @author  Magno Portillo
* @version 1.0
*/	
		@Entity
		public class Usuario{
		
				@Id
				@GeneratedValue(strategy = GenerationType.IDENTITY)
				private Long id;
		
				private String nombre;
		
				private String apellido;
				@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
		
				private LocalDate fecha_registro;
		
				private String pass;
		
		public Usuario(){
		
		}
			
		public Usuario(Long id,String nombre,String apellido,LocalDate fecha_registro,String pass){
				this.id = id;
				this.nombre = nombre;
				this.apellido = apellido;
				this.fecha_registro = fecha_registro;
				this.pass = pass;
				}
			
//M�todos Getters y Setters
				public Long getId(){
				return id;
				}
				public String getNombre(){
				return nombre;
				}
				public String getApellido(){
				return apellido;
				}
				public LocalDate getFecha_registro(){
				return fecha_registro;
				}
				public String getPass(){
				return pass;
				}
		

				public void setId(Long id){
			this.id = id;
			}
				public void setNombre(String nombre){
			this.nombre = nombre;
			}
				public void setApellido(String apellido){
			this.apellido = apellido;
			}
				public void setFecha_registro(LocalDate fecha_registro){
			this.fecha_registro = fecha_registro;
			}
				public void setPass(String pass){
			this.pass = pass;
			}
		

			@Override
			public String toString() {
			return "Usuario["+"id=" + id+ ", "+"nombre=" + nombre+ ", "+"apellido=" + apellido+ ", "+"fecha_registro=" + fecha_registro+ ", "+"pass=" + pass+ ", "+"]";
			}

		}
