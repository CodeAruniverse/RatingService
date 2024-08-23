package com.main.Rating.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.main.Rating.entities.Rating;

@Service
public interface RatingService {

	//saving multiple objects
	List<Rating> saveRating(List<Rating> ratings);
	
	//fetch all details of rating
	List<Rating> fetchAllRating();
	
	//fetch rating details by ratingId;
	Optional<Rating> getRatingById(String ratingId);
	
	//fetch rating details by userId;
	List<Rating> getRatingByUserId(String userId);
	
	//fetch rating details by hotelId;
	List<Rating> getRatingByHotelId(String hotelId);
}
