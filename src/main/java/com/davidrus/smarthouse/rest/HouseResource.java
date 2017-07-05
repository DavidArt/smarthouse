package com.davidrus.smarthouse.rest;

import com.davidrus.smarthouse.dto.House;
import com.davidrus.smarthouse.services.HouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by david on 24-Jun-17.
 */
@Slf4j
@Path(RestConstants.HOUSE_PATH)
@Controller
public class HouseResource {

    @Resource
    HouseService houseService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createHouse(House house) {
        if (houseService.createHouse(house)) {
            return Response.status(Response.Status.CREATED).build();
        }
        return Response.accepted().build();
    }

    @GET
    @Transactional
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHouseById(@PathParam("id") Long id) {
        House house = houseService.getHouseById(id);
        if (house != null) {
            return Response.ok().entity(house).build();
        }
        return Response.accepted().build();
    }

    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHouseByName(@QueryParam("name") String name) {
        House house = houseService.getHouseByName(name);
        if (house != null) {
            return Response.ok().entity(house).build();
        }
        return Response.accepted().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateHouse(House house) {
        if (houseService.updateHouse(house)) {
            return Response.noContent().build();
        }
        return Response.accepted().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteHouse(Long id) {
        if (houseService.deleteHouse(id)) {
            return Response.noContent().build();
        }
        return Response.accepted().build();
    }

}
