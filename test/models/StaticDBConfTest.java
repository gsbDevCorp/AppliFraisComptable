package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StaticDBConfTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetUser() {
		assertFalse("Aucun mot de passe défini",StaticDBConf.getUser().isEmpty());
	}
	
	@Test
	public void testGetPasswd() {
	
	}

}
