		package py.edu.facitec.model;
		import javax.persistence.Entity;
		import javax.persistence.Id;
		import javax.persistence.GeneratedValue;
		import javax.persistence.GenerationType;
		
/**
* @author  Magno Portillo
* @version 1.0
*/	
		@Entity
		public class Experto{
		
				@Id
				@GeneratedValue(strategy = GenerationType.IDENTITY)
				private Long id;
		
				private String nombre;
		
				private String apellido;
		
				private String especialidad;
		
		public Experto(){
		
		}
			
		public Experto(Long id,String nombre,String apellido,String especialidad){
				this.id = id;
				this.nombre = nombre;
				this.apellido = apellido;
				this.especialidad = especialidad;
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
				public String getEspecialidad(){
				return especialidad;
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
				public void setEspecialidad(String especialidad){
			this.especialidad = especialidad;
			}
		

			@Override
			public String toString() {
			return "Experto["+"id=" + id+ ", "+"nombre=" + nombre+ ", "+"apellido=" + apellido+ ", "+"especialidad=" + especialidad+ ", "+"]";
			}

		}
