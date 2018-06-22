package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SecureAdminController {
	
	@RequestMapping("/users")	
	public @ResponseBody List<Customer> admin(@RequestParam(value="name", defaultValue="Krysta") String name) {        
		List<Customer> lst=Get_Customers();		
		return lst;
    }
	
	@RequestMapping("/getuserbyrol")
    public List<Customer> UsersByRol() {        
		List<Customer> lst=Get_Customers();		
		Predicate<Customer> byRol = c -> c.getRoleID() == 1;
		List<Customer> result = lst.stream().filter(byRol).collect(Collectors.<Customer> toList());
    	return result;
	}
	
	@RequestMapping("/getusingle")
    public Optional<Customer> GetUser(@RequestParam(value="name") String userName) {        
		List<Customer> lst=Get_Customers();		
		return lst.stream().filter(customer -> customer.getName().equals(userName))
				.findFirst();
	}
	
	private List<Customer> Get_Customers()
	{
		Customer cte1 = new Customer("Krysta", 1);
		Customer cte2 = new Customer("Samantha", 2);
		Customer cte3 = new Customer("Aline", 1);
		Customer cte4 = new Customer("Sara", 3);
		
		List<Customer> c = Arrays.asList(cte1,cte2,cte3,cte4);
		       
		return c;		
	}
	
	@RequestMapping(value = "/getcustomer")
	public Customer getcustomer() {
 
		Customer customer = new Customer("Krysta", 1);
		 
		return customer;
	}
}
