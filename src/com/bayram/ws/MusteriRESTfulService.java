package com.bayram.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bayram.dao.MusteriDAO;
import com.bayram.dao.impl.MusteriDAOImpl;
import com.bayram.model.Musteri;

@Path("/musteri")
public class MusteriRESTfulService {
	
	MusteriDAO musterDao=new MusteriDAOImpl();
	
	//-----------------------------GETLÝST-------------------------------------
	//	http://localhost:8080/RestfulMultipleOutputFormalJDBC/rest/musteri/liste
	
	@GET
	@Path("/liste")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML+";charset=utf-8"})
	public List<Musteri> getMusteriList() {
		
		List<Musteri> musteris=musterDao.musteriList();
		
		
		
		return musteris;
	}

	
	//-----------------------------GETBYID-------------------------------------
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_XML+";charset=utf-8"})
	public Musteri getMusteriById(@PathParam("id")  int id) {
		
		return musterDao.getMusteriById(id);
	}
	
	
	//-----------------------------ADD-------------------------------------
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON+";charset=utf-8"})
	public Response musteriEkle(Musteri musteri) {
	Musteri musteri2=musterDao.addMusteri(musteri);
		return Response.status(201).entity(musteri2).build();
	}
	
	
	//-----------------------------UPDATE-------------------------------------
	@PUT
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_XML+";charset=utf-8"})
	@Consumes({MediaType.APPLICATION_XML+";charset=utf-8"})
	public Response musteriUpdate(@PathParam("id")  int id,Musteri musteri) {
		musterDao.updateMusteri(musteri, id);
		return Response.status(200).build();
	}
	
	
	//-----------------------------DELETE-------------------------------------
	@DELETE
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_XML+";charset=utf-8"})
	public Response musteriDelete(@PathParam("id")  int id) {
		musterDao.deleteMusteri(id);
		return Response.status(200).build();
	}
	
	

}
