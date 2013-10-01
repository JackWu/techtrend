/**
 * 
 */
package com.techtrend.dataaccess.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.techtrend.dataaccess.VehicleDao;
import com.techtrend.dataaccess.VehicleDaoJdbcImpl;
import com.techtrend.domain.Vehicle;

/**
 * @author jackwu
 *
 */
public class VehicleDaoJdbcImplTest {
	
	private EmbeddedDatabase database;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		database = builder.setType(EmbeddedDatabaseType.H2).
				addScript("database/h2/calendar-schema.sql").
				addScript("database/h2/calendar-data.sql").build();	
		assertNotNull(database);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		database.shutdown();
	}

	@Test
	public void testFirst() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(database);
		VehicleDao dao = new VehicleDaoJdbcImpl(jdbcTemplate);
		List<Vehicle> vehicles = dao.getVehicles();
		assertNotNull(vehicles);
		
	}

}