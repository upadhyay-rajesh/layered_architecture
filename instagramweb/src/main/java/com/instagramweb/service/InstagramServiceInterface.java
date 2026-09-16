package com.instagramweb.service;

import java.util.ArrayList;

import com.instagramweb.entity.Country;
import com.instagramweb.entity.InstagramUser;
import com.instagramweb.entity.State;

public interface InstagramServiceInterface {

	int createProfileService(InstagramUser iu);

	int loginProfileService(InstagramUser iu);

	InstagramUser viewProfileService(InstagramUser iu);

	int checkEmailService(InstagramUser iu);

	ArrayList<Country> loadCountryService();



	ArrayList<State> loadStateService(Country c);

}
