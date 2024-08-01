import React, { useState } from 'react'

export default function DisplayReview({id}) {

  const [review, setReview] = useState([]);

  const loadCampgrounds = async () => {
    const result = await axios.get(`http://localhost:8080/review/${reviewId}`);
    setReview(result.data); 
}
  return (
    <div>
      
    </div>
  )
}
