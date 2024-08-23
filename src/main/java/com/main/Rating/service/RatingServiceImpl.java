package com.main.Rating.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.Rating.entities.Rating;
import com.main.Rating.repo.RatingRepo;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepo ratingRepo;

	@Override
	public List<Rating> saveRating(List<Rating> ratings) {
		List<Rating> savedRating = new ArrayList<>();
		for(Rating rating : ratings) {
			String ratingId = UUID.randomUUID().toString();
			rating.setRatingId(ratingId);
		}
		
		savedRating = this.ratingRepo.saveAll(ratings);
		return savedRating;
	}

	@Override
	public List<Rating> fetchAllRating() {
		return this.ratingRepo.findAll();
//		return null;
	}

	@Override
	public Optional<Rating> getRatingById(String ratingId) {
		// TODO Auto-generated method stub
		return this.ratingRepo.findById(ratingId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rating> getRatingByUserId(String userId) {
		// TODO Auto-generated method stub
		return (List<Rating>) this.ratingRepo.findByUserId(userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return (List<Rating>) this.ratingRepo.findByHotelId(hotelId);
	}

}
