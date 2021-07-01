package com.launchacademy.thymeleafViews.repositories;

import org.springframework.data.repository.CrudRepository;

import com.launchacademy.thymeleafViews.models.Trip;

//this interface automatically provide all methods for saving/retrieving data to/from db
public interface TripRepository extends CrudRepository<Trip, Integer>{

}
