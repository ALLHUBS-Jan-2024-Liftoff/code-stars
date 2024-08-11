import React, { useState, useEffect } from 'react'
import axios from 'axios';
import { DisplayRating } from './DisplayRating';
import UpdateReviewForm from './UpdateReviewForm';

export default function DisplayReview({id}) {

  const [review, setReview] = useState([]);

  // updates: manages edit mode
  const [isEditing, setIsEditing] = useState(false); 

  //loads review when page is loaded
  useEffect(() => {
    loadReview();
},[]);

  //gets review data by id via axios when review is loaded
  const loadReview = async () => {
    const result = await axios.get(`http://localhost:8080/review/${id}`);
    setReview(result.data); 
}

// updates - handle edit button click
  const handleEditClick = () => {
    setIsEditing(true); 
  };


  return (
    <div className="card">
      <div className="card-header">
        <h4>User's Review: <DisplayRating rating={review.rating}/></h4> 
      
        </div>
      <div className="card-body">
        {!isEditing ? (
          <>
            <p>"{review.feedback}"</p>

            {/* Conditionally render the Edit button if the current user is the author */}
            {/* {currentUserId === review.authorId && ( */}
              <button onClick={handleEditClick} className="btn btn-warning">
                Edit Review
              </button>
            {/* )} */}
          </>
        ) : (
          // Render the UpdateReviewForm component when in edit mode
          <UpdateReviewForm reviewId={id} reviewData={review} />
        )}
      </div>
    </div>
  );
}



