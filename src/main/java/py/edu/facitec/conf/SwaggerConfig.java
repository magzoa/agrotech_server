

package py.edu.facitec.conf;

import java.util.List;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;



@Configuration
public class SwaggerConfig {
	
	
	@Bean
	public GroupedOpenApi petOpenApi() {
	   String paths[]= {"/api/**"};
	   return GroupedOpenApi.builder().group("api").pathsToMatch(paths)
	         .build();
	}
	

	
	
	@Bean
	public OpenAPI myOpenAPI() {
		Contact contact = new Contact();
		contact.setEmail("magzoaa@gmail.com");
		contact.setName("");
		contact.setUrl("URL");

		Server localServer = new Server();
		localServer.setUrl("http://localhost:8080");
		localServer.setDescription("Server URL in Local environment");

		
		License apacheLicense = new License()
				.name("Apache License Version 2.0")
				.url("https://www.apache.org/licenses/LICENSE-2.0");

		Info info = new Info()
				.title("agrotech")
				.contact(contact)
				.version("1.0")
				.description("This API exposes endpoints for: agrotech")
				.termsOfService("Terms of Service")
				.license(apacheLicense);

		return new OpenAPI()
				.info(info)
				.servers(List.of(localServer));
	}
	
	

}



