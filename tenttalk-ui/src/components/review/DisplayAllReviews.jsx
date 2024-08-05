import React, { useState, useEffect } from 'react';
import axios from 'axios';
import DisplayReview from './DisplayReview'

export function DisplayAllReviews() {

    //initializes useState for reviews to be stored
    const [reviews, setReviews] = useState([]);

    //loads all reviews when page is loaded
    useEffect(() => {
        loadAllReviews();
    },[]);

    //sets state of reviews to the result of axios request
    const loadAllReviews = async () => {
        try {
            const result = await axios.get(`http://localhost:8080/review/getAll`);
            console.log(result.data);
            setReviews(result.data);  
        } catch (error) {
            console.error('Error fetching reviews:', error);
        }
        
    }
    

  return (
    <div>
        {/* map function to call DisplayReview by id for each review object in reviews array */}
        <DisplayReview />
    </div>
  )
}
