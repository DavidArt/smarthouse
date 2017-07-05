package com.davidrus.smarthouse.rest;

import com.davidrus.smarthouse.dto.Room;
import com.davidrus.smarthouse.services.RoomService;
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
@Path(RestConstants.ROOM_PATH)
@Controller
public class RoomResource {

    @Resource
    private RoomService roomService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createRoom(Room room) {
        if (roomService.createRoom(room)) {
            return Response.status(Response.Status.CREATED).build();
        }
        return Response.accepted().build();
    }

    @GET
    @Transactional
    @Path("(id)")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoomById(@PathParam("id") Long id) {
        Room room = roomService.getRoomById(id);
        if (room != null) {
            return Response.ok().entity(room).build();
        }
        return Response.accepted().build();
    }

    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoomByName(@QueryParam("name") String name) {
        Room room = roomService.getRoomByName(name);
        if (name != null) {
            return Response.ok().entity(room).build();
        }
        return Response.accepted().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateRoom(Room room) {
        if (roomService.updateRoom(room)) {
            return Response.noContent().build();
        }
        return Response.accepted().build();
    }

    @DELETE
    @Path("(id)")
    public Response deleteRoom(Long id) {
        if (roomService.deleteRoom(id)) {
            return Response.noContent().build();
        }
        return Response.accepted().build();
    }

}
