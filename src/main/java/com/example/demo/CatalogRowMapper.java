package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CatalogRowMapper implements RowMapper<Catalog> {

	@Override
	public Catalog mapRow(ResultSet arg0, int arg1) throws SQLException {
		Catalog catalog = new Catalog();
		catalog.setDescription(arg0.getString(2));
		catalog.setId(arg0.getString(1));
		catalog.setName(arg0.getString(3));
		return catalog;
	}

	
}
