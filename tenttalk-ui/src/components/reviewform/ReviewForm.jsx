import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

export default function ReviewForm() {

    const [review, setReview] = useState({
        campground: "",
        rating: "",
        feedback: "",
    })

    const{campground, rating, feedback} = review;

    const onInputChange =(e)=> {
        setReview({...review,[e.target.name]:e.target.value})
    }

    const onSubmit = async (event) => {
        event.preventDefault();
        await axios.post("http://localhost:8080/review", review);
        useNavigate("/campground");
    };

  return (
    <div>
        <form onSubmit={(event) => onSubmit(event)}>
            <div className="form-group">
                <label htmlFor="campground">Campground</label>
                <input 
                    type="text" 
                    name="campground"
                    id="campground" 
                    value={campground} 
                    onChange={(e)=>onInputChange(e)}
                    className="form-control" 
                />
            </div>

            <div className="form-group">
                <label htmlFor="rating">Rating</label>
                <select
                    name="rating"
                    id="rating"
                    value={rating}
                    onChange={(e)=>onInputChange(e)}
                >
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
            </div>
            
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
            
                <button type="submit" className="btn btn-primary">Submit</button>
            
            </form>
    </div>
  )
}
