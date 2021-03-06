package com.jordanec.restbootexample.client;

import java.util.Collection;

import com.jordanec.restbootexample.model.*;
import com.jordanec.restbootexample.util.Constants;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.DELETE;

public interface ConfederationApi {
	public static final String MAIN_PATH = "/"+Constants.API_VERSION+"/"+Constants.CONFEDERATIONS_PATH;

	@POST(MAIN_PATH)
	Call<Status> createConfederation(@Body Confederation confederation);
	
	@GET(MAIN_PATH+"/{idConfederation}")
	Call<Confederation> readConfederation(@Path("idConfederation") int idConfederation);
	
	@GET(MAIN_PATH+"/"+Constants.NAME_VARIABLE+"={"+Constants.NAME_VARIABLE+"}")
	Call<Confederation> findByName(@Path(Constants.NAME_VARIABLE) String name);
	
	@PUT(MAIN_PATH+"/{idConfederation}")
	Call<Status> updateConfederation(@Body Confederation confederation, @Path("idConfederation") int idConfederation);
	
	@DELETE(MAIN_PATH+"/{idConfederation}")
	Call<Status> deleteConfederation(@Path("idConfederation") int idConfederation);
	
	@GET(MAIN_PATH)
	Call<Collection<Confederation>> listConfederations();
	
	@GET(MAIN_PATH+"/{idConfederation}/"+Constants.COUNTRIES_PATH)
	Call<Collection<Country>> readConfederationCountries(@Path("idConfederation") int idConfederation);
	
}
