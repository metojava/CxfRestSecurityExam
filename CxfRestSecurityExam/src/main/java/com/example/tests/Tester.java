package com.example.tests;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String name = "arabuli";//"Arabuli";
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		
		//10 - $2a$10$uTV0YzlwMeiPfSFc4wXGIugiji2GG5AJa.aYF6gIzSdMlTocYaMTK
		//5 -  $2a$05$p4O6FgkjR10CCesMZOPqI.K3ev1XYweQDmL6Hq3sN8Os/muClxqWq
		//switch strength to :
		//10 - $2a$10$YPDVPM6cyAaUxV4.ddFZzOYdzyMlrlZB5LXCAxxHXn1aFounnU01.
		// so it gives always different result
		String hashedName = encoder.encode(name);
		System.out.println(hashedName);
		

	}

}
