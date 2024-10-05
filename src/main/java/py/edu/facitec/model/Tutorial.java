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
		public class Tutorial{
		
				@Id
				@GeneratedValue(strategy = GenerationType.IDENTITY)
				private Long id;
		
				private String titulo;
		
				private String texto;
		
				private String imagen;
				@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
		
				private LocalDate fecha;
		
		public Tutorial(){
		
		}
			
		public Tutorial(Long id,String titulo,String texto,String imagen,LocalDate fecha){
				this.id = id;
				this.titulo = titulo;
				this.texto = texto;
				this.imagen = imagen;
				this.fecha = fecha;
				}
			
//M�todos Getters y Setters
				public Long getId(){
				return id;
				}
				public String getTitulo(){
				return titulo;
				}
				public String getTexto(){
				return texto;
				}
				public String getImagen(){
				return imagen;
				}
				public LocalDate getFecha(){
				return fecha;
				}
		

				public void setId(Long id){
			this.id = id;
			}
				public void setTitulo(String titulo){
			this.titulo = titulo;
			}
				public void setTexto(String texto){
			this.texto = texto;
			}
				public void setImagen(String imagen){
			this.imagen = imagen;
			}
				public void setFecha(LocalDate fecha){
			this.fecha = fecha;
			}
		

			@Override
			public String toString() {
			return "Tutorial["+"id=" + id+ ", "+"titulo=" + titulo+ ", "+"texto=" + texto+ ", "+"imagen=" + imagen+ ", "+"fecha=" + fecha+ ", "+"]";
			}

		}
