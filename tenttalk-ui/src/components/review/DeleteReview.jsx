import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

export default function DeleteReviewPage() {
    const [reviews, setReviews] = useState([]);
    const navigate = useNavigate();

    // Load all reviews on component mount
    useEffect(() => {
        loadReviews();
    }, []);

    const loadReviews = async () => {
        try {
            const result = await axios.get('http://localhost:8080/review/getAll');
            setReviews(result.data);
        } catch (error) {
            console.error("Error fetching reviews:", error);
        }
    };

    const handleDelete = async (id) => {
        try {
            await axios.delete(`http://localhost:8080/review/${id}`);
            setReviews(reviews.filter(review => review.id !== id));
        } catch (error) {
            console.error("Error deleting review:", error);
        }
    };

    return (
        <div className="container">
            <h1>Delete Reviews</h1>
            {reviews.length === 0 ? (
                <p>No reviews available to delete.</p>
            ) : (
                <ul className="list-group">
                    {reviews.map(review => (
                        <li key={review.id} className="list-group-item">
                            <h5>Campground ID: {review.campgroundId}</h5>
                            <p>Rating: {review.rating}</p>
                            <p>Feedback: {review.feedback}</p>
                            <button 
                                className="btn btn-danger"
                                onClick={() => handleDelete(review.id)}
                            >
                                Delete
                            </button>
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
}
