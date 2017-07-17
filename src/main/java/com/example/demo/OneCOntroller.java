package com.example.demo;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OneCOntroller {
	
	@Autowired
	JdbcTemplate template;
	@Autowired
	CatalogRepository repo;
	
	@RequestMapping("/dataJDBCRowMapper")
	public String getData()
	{
		StringBuilder build = new StringBuilder();
		List<Catalog> cList = template.query("select * from catalog",new CatalogRowMapper());
		Iterable<Catalog> s = repo.findAll();
		Iterator< Catalog> it = s.iterator();
		while(it.hasNext())
		{
			System.out.println("******************************************************"+it.next().getName());
			build.append("******************************************************");
		}
		
		for(Catalog c:cList)
		{
			build.append("Name "+c.getName()+"\tDescr: "+c.getDescription()+"\br");
		}
		return "Data: "+build;
	}
	
	@RequestMapping("/dataJPA")
	public String getData1()
	{
		List<Catalog> cList = template.query("select * from catalog",new CatalogRowMapper());
		StringBuilder build = new StringBuilder();
		for(Catalog c:cList)
		{
			build.append("Name "+c.getName()+"\tDescr: "+c.getDescription()+"\n");
		}
		return "Data: "+build;
	}
}
