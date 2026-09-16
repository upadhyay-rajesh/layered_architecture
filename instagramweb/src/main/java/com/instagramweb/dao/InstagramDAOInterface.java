package com.instagramweb.dao;

import java.util.ArrayList;

import com.instagramweb.entity.Country;
import com.instagramweb.entity.InstagramUser;
import com.instagramweb.entity.State;

public interface InstagramDAOInterface {

	int createProfileDAO(InstagramUser iu);

	int loginProfileDAO(InstagramUser iu);

	InstagramUser viewProfileDAO(InstagramUser iu);

	int checkEmailDAO(InstagramUser iu);

	ArrayList<Country> loadCountryDAO();

	ArrayList<State> loadStateDAO(Country c);

}
