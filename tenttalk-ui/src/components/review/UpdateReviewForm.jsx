import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate, useParams } from 'react-router-dom';
import { StarInput } from './StarInput';



export default function UpdateReviewForm({id}) {
    // const { id } = useParams();
    const [starRating, setStarRating] = useState(0);
    const [review, setReview] = useState({
        campground: "",
        rating: "",
        feedback: "",
    });

    const{ campground, rating, feedback}  = review;

    const onInputChange =(e)=> {
        setReview({...review,[e.target.name]:e.target.value})
    }


    const navigate = useNavigate();

    useEffect(() => {
        if (id) {
            loadReview();
        }
    }, [id]);



    // onSubmit function sends PUT request to update review


    //pass in id of review that was opened

    const onSubmit = async (event) => {
        event.preventDefault();


        try {
            if (id) {
                const response = await axios.put(`http://localhost:8080/review/${id}`, {
                    "rating": starRating,
                    "feedback": feedback,
                    "tags": review.tags.map((tag) => tag.name) // maps tag array to correct format
                });
                console.log('Update response:', response.data);
                window.location.reload();  // Reloads after submit
            }
        } catch (error) {
            console.error('Error updating review:', {
                message: error.message,
                response: error.response?.data,
                status: error.response?.status
            });
            alert('Failed to update the review. Please try again.');
        }
    };
    

    // added error catches

    const loadReview = async () => {
        try {
            const result = await axios.get(`http://localhost:8080/review/${id}`);
            setReview(result.data);
            setStarRating(result.data.rating); 
        } catch (error) {
            console.error('Error loading review:', error);
        }
    };



return (
    <div>
        <form onSubmit={(event) => onSubmit(event)}>
            <div className="form-group">
                <label htmlFor="campground">Campground ID</label>
                <input 
                    type="text" 
                    name="campground"
                    id="campground" 
                    value={campground} 
                    onChange={(e)=>onInputChange(e)}
                    className="form-control" 
                />
            </div>

            < StarInput starRating={starRating} setStarRating={setStarRating} />
            
            <div className="form-group">
                <label htmlFor="feedback">Review</label> <br />
                <textarea 
                    id="feedback" 
                    name="feedback" 
                    value={feedback} 
                    onChange={(e)=>onInputChange(e)}
                    rows="5" 
                    cols="50" 
                    className="form-control">
                    Write review here...
                </textarea>
            </div>
            
                <button type="submit" className="btn btn-primary">Submit Changes</button>
            
            </form>
    </div>
)
}
