package com.instagramweb.service;

import java.util.ArrayList;

import com.instagramweb.dao.InstagramDAO;
import com.instagramweb.dao.InstagramDAOInterface;
import com.instagramweb.entity.Country;
import com.instagramweb.entity.InstagramUser;
import com.instagramweb.entity.State;

public class InstagramService implements InstagramServiceInterface {

	@Override
	public int createProfileService(InstagramUser iu) {
		InstagramDAOInterface id = new InstagramDAO();
		int i = id.createProfileDAO(iu);
		return i;
	}

	@Override
	public int loginProfileService(InstagramUser iu) {
		InstagramDAOInterface id = new InstagramDAO();
		int i = id.loginProfileDAO(iu);
		return i;
	}

	@Override
	public InstagramUser viewProfileService(InstagramUser iu) {
		InstagramDAOInterface id = new InstagramDAO();
		InstagramUser i = id.viewProfileDAO(iu);
		return i;
	}

	@Override
	public int checkEmailService(InstagramUser iu) {
		InstagramDAOInterface id = new InstagramDAO();
		int i = id.checkEmailDAO(iu);
		return i;
	}

	@Override
	public ArrayList<Country> loadCountryService() {
		InstagramDAOInterface id = new InstagramDAO();
		ArrayList<Country> cc =id.loadCountryDAO();
		return cc;
	}

	
	@Override
	public ArrayList<State> loadStateService(Country c) {
		InstagramDAOInterface id = new InstagramDAO();
		ArrayList<State> cc =id.loadStateDAO(c);
		return cc;	
	}

}
