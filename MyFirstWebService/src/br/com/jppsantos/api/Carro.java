package br.com.jppsantos.api;


// Tipo do método
import javax.ws.rs.GET;
// Irá definir o caminho
import javax.ws.rs.Path;
// Formato que irá devolver
import javax.ws.rs.Produces;
// Tipo de retorno
import javax.ws.rs.core.MediaType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;


@Path("carro")
public class Carro implements Serializable {
	private static final long serialVersionUID = 1L;

	@GET
	@Path("dados_carro")
	@Produces(MediaType.TEXT_PLAIN)
	public String dadosCarro() {
		return "Mustang";
	}
	
	@GET()
	@Path("lista")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarCarro() {
		
		try {
			List<CarroBean> carros = new ArrayList<CarroBean>();
			carros.add(new CarroBean("Volksvagem", "Gol"));
			carros.add(new CarroBean("Fiat", "Uno"));
			
			GenericEntity<List<CarroBean>> genericEntiry = new GenericEntity<List<CarroBean>>(carros) {};
			
			return Response.ok(genericEntiry, MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			
			return Response.status(Response.Status.BAD_REQUEST).build();		
		}	
	}
}
