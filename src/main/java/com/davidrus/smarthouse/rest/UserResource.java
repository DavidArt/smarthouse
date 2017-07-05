package com.davidrus.smarthouse.rest;

import com.davidrus.smarthouse.dto.User;
import com.davidrus.smarthouse.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by david on 24-Jun-17.
 */

@Slf4j
@Path(RestConstants.USER_PATH)
@Controller
public class UserResource {

    @Resource
    UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        if (userService.createUser(user)) {
            return Response.status(Response.Status.CREATED).build();
        }
        return Response.accepted().build();
    }

    @GET
    @Transactional
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id") Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return Response.ok().entity(user).build();
        }
        return Response.accepted().build();
    }

    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByName(@QueryParam("name") String name) {
        User user = userService.getUserByName(name);
        if (user != null) {
            return Response.ok().entity(user).build();
        }
        return Response.accepted().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(User user) {
        if (userService.updateUser(user)) {
            return Response.noContent().build();
        }
        return Response.accepted().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(Long id) {
        if (userService.deleteUser(id)) {
            return Response.noContent().build();
        }
        return Response.accepted().build();
    }

}
