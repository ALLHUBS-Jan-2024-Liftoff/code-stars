import React, { useState } from 'react'
import { useEffect } from 'react';
import axios from 'axios';

export default function DisplayReview({id}) {

  const [review, setReview] = useState([]);

  //loads review when page is loaded
  useEffect(() => {
    loadReview();
},[]);

  const loadReview = async () => {
    const result = await axios.get(`http://localhost:8080/review/${id}`);
    console.log(result.data);
    setReview(result.data); 
}
  return (
    <div>
      <h2>Honest Review</h2>
      <p>Rating: {review.rating} stars</p>
      <p>"{review.feedback}"</p>
    </div>
  )
}
