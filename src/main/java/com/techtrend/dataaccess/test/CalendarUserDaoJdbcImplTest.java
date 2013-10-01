package com.techtrend.dataaccess.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.techtrend.dataaccess.CalendarUserDao;
import com.techtrend.dataaccess.CalendarUserDaoJdbcImpl;
import com.techtrend.domain.CalendarUser;

public class CalendarUserDaoJdbcImplTest {
	
	private EmbeddedDatabase database;

	@Before
	public void setUp() throws Exception {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		database = builder.setType(EmbeddedDatabaseType.H2).
				addScript("database/h2/calendar-schema.sql").
				addScript("database/h2/calendar-data.sql").build();	
		assertNotNull(database);
	}

	@After
	public void tearDown() throws Exception {
		database.shutdown();
	}

	@Test
	public void testGetUser() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(database);
		CalendarUserDao dao = new CalendarUserDaoJdbcImpl(jdbcTemplate);
		CalendarUser user = dao.getUser(0);
		assertNotNull(user);
	}

}
