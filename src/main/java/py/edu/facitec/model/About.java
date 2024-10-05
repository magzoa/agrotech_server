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
		public class About{
		
				@Id
				@GeneratedValue(strategy = GenerationType.IDENTITY)
				private Long id;
		
				private String descripcion;
		
		public About(){
		
		}
			
		public About(Long id,String descripcion){
				this.id = id;
				this.descripcion = descripcion;
				}
			
//M�todos Getters y Setters
				public Long getId(){
				return id;
				}
				public String getDescripcion(){
				return descripcion;
				}
		

				public void setId(Long id){
			this.id = id;
			}
				public void setDescripcion(String descripcion){
			this.descripcion = descripcion;
			}
		

			@Override
			public String toString() {
			return "About["+"id=" + id+ ", "+"descripcion=" + descripcion+ ", "+"]";
			}

		}
