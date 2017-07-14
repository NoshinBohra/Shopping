package com.example.Shopping.Controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Shopping.Repository.Repository;
import com.example.Shopping.model.Product;

@RestController
public class Controller {
	
	@Autowired
	Repository repository;
	
	@RequestMapping("/save")
	public String process(){
		repository.save(new Product("Shirt","M",700,"Yes"));
		repository.save(new Product("Trouser","M",1700,"Yes"));
		repository.save(new Product("Shirt","L",1200,"Yes"));
		repository.save(new Product("Shirt","M",1000,"No"));
		repository.save(new Product("Jeans","M",2000,"Yes"));
		repository.save(new Product("Jeans","L",2500,"No"));
		
		return "Added Successfully";
	}
	
	@RequestMapping(value = "/saveproduct",method = RequestMethod.POST)
    public String saveProduct(@RequestBody Product data){
		if(data!= null)
		{
			repository.save(data);  
			return "Product Added";
		}
		else
			return "Enter valid Data";
			
    }
	
	@RequestMapping("/displayall")
	public List<Product> DisplayAll(){
		List<Product> products = new ArrayList<Product>();
		for(Product prod : repository.findAll()){
//			System.out.println("retrieve data"+prod.getId()+""+prod.getType());
			products.add(prod);
			
		}
		return products;
	}
	
//	@RequestMapping("/displayall")
//	public String DisplayAll(){
//		String result = "<html>";
//		
//		for(Product prod : repository.findAll()){
//			result +="<div>" + prod.toString() +"</div>";
//			System.out.println("retrieve data"+prod.getId()+""+prod.getType());
//		}
//		return result + "</html>";
//	}
	
	@RequestMapping(value = "findbyid/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Product findById(@PathVariable("id")long id){
		if(id > 0)
        {
			Product prod = repository.findOne(id);
			return prod;
        }
        return null;
    }
	
	@RequestMapping(value = "/findbysize/{size}",method = RequestMethod.GET)
	@ResponseBody
	public List<Product> fetchDataBySize(@PathVariable("size") String size){
		if(size != null)
	    {
			List<Product> products;
			products = repository.findBySize(size);
			return products;
	    }
		 return null;
	}
	
//	@RequestMapping("/findbysize")
//	public String fetchDataBySize(@RequestParam("size") String size){
//		String result = "<html>";
//		
//		for(Product prod: repository.findBySize(size)){
//			result += "<div>" + prod.toString() + "</div>"; 
//		}
//		
//		return result + "</html>";
//	}
	
	@RequestMapping(value = "/findbytype/{type}",method = RequestMethod.GET)
	@ResponseBody
	public List<Product> fetchDataByType(@PathVariable("type") String type){
		if(type != null)
	    {
			List<Product> products;
			products = repository.findByType(type);
			return products;
	    }
		 return null;
	}
	
	@RequestMapping(value = "/findbyavail/{avail}",method = RequestMethod.GET)
	@ResponseBody
	public List<Product> fetchDataByAvail(@PathVariable("avail") String avail){
		if(avail != null)
	    {
			List<Product> products;
			products = repository.findByAvail(avail);
			return products;
	    }
		 return null;
	}


//	@RequestMapping(value="deleteproduct/{id}",method=RequestMethod.DELETE)
//    @ResponseBody
//    public String deleteProduct(@PathVariable("id") long id){
//      
//        if(id > 0)
//        {
//        	if(repository.findOne(id) != null)
//        	{
//        		repository.delete(id);
//        		return "Product  Deleted";
//        	}
//        	else
//        	{
//        		return "Product Doesnt Exist";
//        	}
//        }
//        else
//        	return "Enter valid Id";
//    }
//	
	
}
