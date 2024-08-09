import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate, useParams } from 'react-router-dom';
import { StarInput } from './StarInput';



export default function UpdateReviewForm() {

    const {id}=useParams()

    const [starRating, setStarRating] = useState(0)

    const [review, setReview] = useState({
        campground: "",
        rating: "",
        feedback: "",
    })

    const{campground, rating, feedback} = review;

    const onInputChange =(e)=> {
        setReview({...review,[e.target.name]:e.target.value})
    }


    useEffect(() => {
        loadReview();
    }, []);

    const navigate = useNavigate();

    const onSubmit = async (event) => {
        event.preventDefault();
        await axios.put(`http://localhost:8080/review/add/${id}`, {
            "campgroundId": campground,
            "rating": starRating,
            "feedback": feedback
        });
        navigate("/campground");
    };

    

    const loadReview = async () => {
        const result = await axios.get(`http://localhost:8080/review/add/${id}`);
        setReview(result.data);
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
            
                <button type="submit" className="btn btn-primary">Submit Review Changes</button>
            
            </form>
    </div>
  )
}
