package com.biblioteca.abm.rest;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.biblioteca.abm.session.AutorSession;
import org.biblioteca.entidad.Autor;

@Path("autor")
public class AutorRest {
@EJB AutorSession as;
	

//GET http://localhost:8080/BIBLIOTECA-WEB/rest/autor/list
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Map<String, Object> listar() throws Exception {
		Map<String, Object> retorno = new HashMap<String, Object>();
		retorno.put("success", true);
		retorno.put("result", as.buscarTodos());
		return retorno;
	}
	
// GET http://localhost:8080/BIBLIOTECA-WEB/rest/autor/consultar-por-nombre?nombre=?
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultar-por-nombre")
	public Map<String, Object> consultaPorNombre(@QueryParam("nombre") String nombre){
		
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			retorno.put("success", true);
			retorno.put("result", as.consultarAutoresPorNombre(nombre));
		}catch (Exception e) {
			retorno.put("success", false);
			retorno.put("error", e.getMessage());
		}
		
		return retorno;
	}
	

//GET http://localhost:8080/BIBLIOTECA-WEB/rest/autor/find/n
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/find/{codigo}")
	public Map<String, Object> buscar(@PathParam("codigo") Integer codigo) throws Exception {
		Map<String, Object> retorno = new HashMap<String, Object>();
		retorno.put("success", true);
		retorno.put("result", as.buscarPorCodigo(codigo));
		return retorno;
	}

//PUT http://localhost:8080/BIBLIOTECA-WEB/rest/autor/update
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Map<String, Object> actualizar(Autor autor) throws Exception {
		Map<String, Object> retorno = new HashMap<String, Object>();
		retorno.put("success", true);
		retorno.put("result", as.actualizar(autor));
		return retorno;
	}
	
// POST http://localhost:8080/BIBLIOTECA-WEB/rest/autor/incluir
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/incluir")
	public Map<String, Object> incluir(Autor autor) throws Exception {
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			retorno.put("success", true);
			retorno.put("result", as.incluir(autor));
		} catch (Exception e) {
			retorno.put("success", false);
			retorno.put("error", e.getMessage());
		}
		
		return retorno;
	}

//DELETE http://localhost:8080/BIBLIOTECA-WEB/rest/autor/delete/n
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/{codigo}")
	public Map<String, Object> borrar(@PathParam("codigo") Integer codigo) throws Exception {
		Map<String, Object> retorno = new HashMap<String, Object>();
		retorno.put("success", true);
		as.eliminar(codigo);
		return retorno;
	}
}