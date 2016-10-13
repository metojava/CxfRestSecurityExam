package org.example.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.example.user.User;
import org.example.user.UserList;
import org.springframework.stereotype.Service;
@Service("userService")
public class UserServiceImpl implements UserService {

	@Override
	@POST
	@Path("/addUser")
	@Consumes("application/x-www-form-urlencoded")
	@Produces({ "application/xml", "application/json" })
	public String createUser(User user) {
		// TODO Auto-generated method stub
		return "success";
	}

	@Override
	@GET
	@Path("/user/{id}")
	@Consumes({ "application/xml", "application/json" })
	@Produces({ "application/xml", "application/json" })
	public User getUser(@PathParam("id") int id) {
		User user = createUser();
		user.setId(id);
		return user;
	}

	private User createUser() {
		User user = new User();
		Random rnd = new Random();
		int rn = rnd.nextInt(1000);
		user.setId(rn);
		user.setAge(34);

		XMLGregorianCalendar calendar = null;
		try {
			GregorianCalendar c = new GregorianCalendar();
			DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
			c.setTime(df.parse("1996-04-01"));
			calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setSalary(5250.0);
		user.setBdate(calendar);
		user.setFname("User"+rn);
		user.setLname("UserFname"+rn);
		return user;
	}

	@Override
	@DELETE
	@Path("/delete/{id}")
	@Consumes({ "application/xml", "application/json" })
	@Produces({ "application/xml", "application/json" })
	public User deleteUser(@PathParam("id") int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PUT
	@Path("/addUser")
	@Consumes("application/x-www-form-urlencoded")
	@Produces({ "application/xml", "application/json" })
	public String updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GET
	@Path("/users")
	@Consumes({ "application/xml", "application/json" })
	@Produces({ "application/xml", "application/json" })
	public UserList getUsers() {
		UserList userList = new UserList();
		userList.getUser().add(createUser());
		userList.getUser().add(createUser());
		userList.getUser().add(createUser());
		userList.getUser().add(createUser());
		
		return userList;
	}

}
