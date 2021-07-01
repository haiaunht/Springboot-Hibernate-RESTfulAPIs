package com.launchacademy.thymeleafViews.services;

import java.util.List;

import com.launchacademy.thymeleafViews.models.Trip;

public interface TripService {

	List<Trip> getList();

	void addToList(Trip trip);
}
