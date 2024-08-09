import React, { useState } from 'react'
import { useEffect } from 'react';
import axios from 'axios';
import { DisplayRating } from './DisplayRating';

export default function DisplayReview({id}) {

  const [review, setReview] = useState([]);

  //loads review when page is loaded
  useEffect(() => {
    loadReview();
},[]);

  //gets review data by id via axios when review is loaded
  const loadReview = async () => {
    const result = await axios.get(`http://localhost:8080/review/${id}`);
    setReview(result.data); 
}


  return (
    <div className="card">
      <div className="card-header">
        <h4>User's Review: <DisplayRating rating={review.rating}/></h4> 
      </div>
      <div className="card-body">
        <p>"{review.feedback}"</p>

        {/* edit review component*/}
        {/* <button className="btn btn-primary" onClick={handleUpdateClick}>
          Edit Review
        </button> */}

      </div>
    </div>
  )
}
