		package py.edu.facitec.model;
		import javax.persistence.Entity;
		import javax.persistence.Id;
		import javax.persistence.GeneratedValue;
		import javax.persistence.GenerationType;
		import java.time.LocalDate;
		import com.fasterxml.jackson.annotation.JsonFormat;
		import java.math.BigDecimal;
		
/**
* @author  Magno Portillo
* @version 1.0
*/	
		@Entity
		public class Pronostico{
		
				@Id
				@GeneratedValue(strategy = GenerationType.IDENTITY)
				private Long id;
				@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
		
				private LocalDate fecha;
		
				private String fechaString;
		
				private BigDecimal precipitacion;
		
				private String observacion;
		
		public Pronostico(){
		
		}
			
		public Pronostico(Long id,LocalDate fecha,String fechaString,BigDecimal precipitacion,String observacion){
				this.id = id;
				this.fecha = fecha;
				this.fechaString = fechaString;
				this.precipitacion = precipitacion;
				this.observacion = observacion;
				}
			
//M�todos Getters y Setters
				public Long getId(){
				return id;
				}
				public LocalDate getFecha(){
				return fecha;
				}
				public String getFechaString(){
				return fechaString;
				}
				public BigDecimal getPrecipitacion(){
				return precipitacion;
				}
				public String getObservacion(){
				return observacion;
				}
		

				public void setId(Long id){
			this.id = id;
			}
				public void setFecha(LocalDate fecha){
			this.fecha = fecha;
			}
				public void setFechaString(String fechaString){
			this.fechaString = fechaString;
			}
				public void setPrecipitacion(BigDecimal precipitacion){
			this.precipitacion = precipitacion;
			}
				public void setObservacion(String observacion){
			this.observacion = observacion;
			}
		

			@Override
			public String toString() {
			return "Pronostico["+"id=" + id+ ", "+"fecha=" + fecha+ ", "+"fechaString=" + fechaString+ ", "+"precipitacion=" + precipitacion+ ", "+"observacion=" + observacion+ ", "+"]";
			}

		}
