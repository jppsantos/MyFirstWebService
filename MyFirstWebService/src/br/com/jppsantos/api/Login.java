package br.com.jppsantos.api;

//Tipo do método
import javax.ws.rs.POST;
//Irá definir o caminho
import javax.ws.rs.Path;
import javax.ws.rs.PathParam; // precisamos desse import para poder passar os parâmetros
//Formato que irá devolver
import javax.ws.rs.Produces;
//Tipo de retorno
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;



@Path("login")
public class Login {
	
	@POST
	@Path("/{usuario}/{senha}")
	@Produces(MediaType.APPLICATION_JSON)
	public String autenticar(@PathParam("usuario") String usuario, @PathParam("senha") String senha) {
		
		ResponseMessage rm = new ResponseMessage();
		
		if (usuario.equals("joao") && senha.equals("123456")) {
			rm.setResponseCode("200");
			rm.setResponseMessage("Autenticacao efetuada com sucesso");
		} else {
			rm.setResponseCode("401");
			rm.setResponseMessage("Não autorizado");
		}
		
		return new Gson().toJson(rm);
	}
	

}
