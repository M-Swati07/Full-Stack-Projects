package com.swati.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    //Spring MongoTemplate offers more control and flexibility with manual query and mapping code, 
    //MongoRepository provides a higher-level abstraction with pre-defined methods for common CRUD operations and automatic mapping.
    
    //MongoTemplate is that the update can be done in a single database interaction. 
    //To use MongoTemplate, we create a custom repository where we build the update query.

    @Autowired
    private MongoTemplate mongoTemplate;
    
    public Review createReview(String imdbId, String userReview){
        Review review = reviewRepository.insert(new Review(userReview));
        mongoTemplate.update(Movie.class)           
            .matching(Criteria.where("imdbId").is(imdbId))          //To perform update operations using a particular field
            .apply(new Update().push("reviewIds").value(userReview))
            .first();

        return review;
    }
}
