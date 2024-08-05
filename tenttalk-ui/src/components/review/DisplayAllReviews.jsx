import React, { useState, useEffect } from 'react';
import axios from 'axios';
import DisplayReview from './DisplayReview'

export function DisplayAllReviews({campgroundId}) {

    //initializes useState for reviews to be stored
    const [reviews, setReviews] = useState([]);

    //loads all reviews when page is loaded
    useEffect(() => {
        loadAllReviews();
    },[]);

    //sets state of reviews to the result of axios request
    const loadAllReviews = async () => {
        try {
            const result = await axios.get(`http://localhost:8080/campground/${campgroundId}`);
            console.log(result.data.reviews);
            setReviews(result.data.reviews);  
        } catch (error) {
            console.error('Error fetching reviews:', error);
        }
    }
    
    // maps reviews into array of DisplayReview components
    const listAllReviews = reviews.map(review => <DisplayReview id={review.id}/>);

    // filters reviews to include only reviews with given campgroundId
    // const campgroundReviews = reviews.filter(review =>
    //     review.
    // );

  return (
    <div>
        {listAllReviews}
    </div>
  )
}
