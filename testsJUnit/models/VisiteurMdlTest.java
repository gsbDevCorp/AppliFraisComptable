package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controllers.VisiteurCtrl;

public class VisiteurMdlTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetAllVisitors() {
		assertTrue("Nombre de visiteurs retournés incorrect.",VisiteurMdl.getAllVisitors().size() == VisiteurMdl.getNbVisitors());
	}
	
	@Test
	public void testGetNbVisitors() {
		assertTrue("Mauvais nombre de visiteurs",VisiteurMdl.getNbVisitors() == 27);
	}

}
