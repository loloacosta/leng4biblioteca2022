package org.biblioteca.rest;
import java.util.HashSet;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.biblioteca.mov.rest.PrestamoLibroRest;
import org.biblioteca.mov.rest.PrestamoRest;
import org.jboss.resteasy.plugins.interceptors.CorsFilter;

import com.biblioteca.abm.rest.AutorRest;
import com.biblioteca.abm.rest.CiudadRest;
import com.biblioteca.abm.rest.ClienteRest;
import com.biblioteca.abm.rest.LibroRest;
import com.biblioteca.abm.rest.UsuarioRest;
@ApplicationPath("rest")
public class BibliotecaRestApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();
    private HashSet<Class<?>> classes = new HashSet<Class<?>>();
    
	public BibliotecaRestApplication() {
		CorsFilter corsFilter = new CorsFilter();
        corsFilter.getAllowedOrigins().add("*");
        corsFilter.setAllowedMethods("OPTIONS, GET, POST, DELETE, PUT, PATCH");
        singletons.add(corsFilter);
       
        classes.add(CiudadRest.class);
        classes.add(ClienteRest.class);
        classes.add(LibroRest.class);
        classes.add(AutorRest.class);
        classes.add(UsuarioRest.class);

        classes.add(PrestamoLibroRest.class);
        classes.add(PrestamoRest.class);
	}
	
	@Override
    public Set<Object> getSingletons() {
        return singletons;
    }

    @Override
    public HashSet<Class<?>> getClasses(){
      return classes;
    }
}