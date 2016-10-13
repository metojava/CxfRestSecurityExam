package org.example.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.example.user.User;
import org.example.user.UserList;

@Path("/UserService")
public interface UserService {

	@POST
	@Path("/addUser")
	@Consumes({ "application/x-www-form-urlencoded" })
	@Produces({ "application/xml", "application/json" })
	public String createUser(User user);

	@GET
	@Path("/user/{id}")
	@Consumes({ "application/xml", "application/json" })
	@Produces({ "application/xml", "application/json" })
	public User getUser(@PathParam("id") int id);

	@DELETE
	@Path("/delete/{id}")
	@Consumes({ "application/xml", "application/json" })
	@Produces({ "application/xml", "application/json" })
	public User deleteUser(@PathParam("id") int id);

	@PUT
	@Path("/addUser")
	@Consumes({ "application/x-www-form-urlencoded" })
	@Produces({ "application/xml", "application/json" })
	public String updateUser(User user);

	@GET
	@Path("/users")
	@Consumes({ "application/xml", "application/json" })
	@Produces({ "application/xml", "application/json" })
	public UserList getUsers();

}
