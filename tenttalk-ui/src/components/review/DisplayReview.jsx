import React, { useState, useEffect } from 'react'
import axios from 'axios';
import { DisplayRating } from './DisplayRating';
import UpdateReviewForm from './UpdateReviewForm';

export default function DisplayReview({ id }) {

  const [review, setReview] = useState([]);

  // updates: manages edit mode
  const [isEditing, setIsEditing] = useState(false);

  const [tags, setTags] = useState();
  const [username, setUsername] = useState("Anonymous User");

  //loads review when page is loaded
  useEffect(() => {
    loadReview();
  }, []);

  //gets review data by id via axios when review is loaded
  const loadReview = async () => {
    const result = await axios.get(`http://localhost:8080/review/${id}`);
    setReview(result.data);
    // maps tags from review into list of badges
    setTags(result.data.tags.map((tag) => <span key={tag.id} className="tag">{tag.name}</span>));
    setUsername(result.data.user.username);
  }

  // updates - handle edit button click
  const handleEditClick = () => {
    setIsEditing(true);
  };

  //delete users
  const deleteReview = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/review/${id}`);
      alert('Review deleted successfully!');
      //navigation
    } catch (error) {
      console.error('There was an error deleting the review!', error);
    }
  };


  return (
    <div className="card">
      <div className="card-header">
        <h4>{username}'s Review: <DisplayRating rating={review.rating} /></h4>

      </div>
      <div className="card-body">
        {!isEditing ? (
          <>
            <p>"{review.feedback}"</p>
            
            <p>{tags}</p>
            {/* Conditionally render the Edit button if the current user is the author */}
          {/* {currentUserId === review.authorId && ( */}
            <button onClick={handleEditClick} className="btn btn-warning">
              Edit Review
            </button>
          {/* )} */}
          </>
        ) : (
          // Render the UpdateReviewForm component when in edit mode
          <UpdateReviewForm id={id} reviewData={review} />
        )}

        <button onClick={() => deleteReview(review.id)} className="btn btn-danger mx-2" >
          Delete
        </button>

      </div>



    </div>
  );
}





