import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { StarInput } from './StarInput';

export default function ReviewForm({campgroundId}) {

    const [starRating, setStarRating] = useState(0)

    const [review, setReview] = useState({
        campground: "",
        rating: "",
        feedback: "",
    })

    const [tags, setTags] = useState([]);
    const [availableTags, setAvailableTags] = useState([]);

    const{campground, rating, feedback} = review;

    const onInputChange =(e)=> {
        setReview({...review,[e.target.name]:e.target.value})
    }

    const navigate = useNavigate();

    useEffect(() => {
        // Fetch available tags from the backend
        axios.get("http://localhost:8080/tag/getAll")
            .then(response => {
                //console.log('Fetched tags:', response.data); // Debugging 
                setAvailableTags(response.data);
            })
            .catch(error => {
                console.error("Error fetching tags:", error);
            });
    }, []);
    
    // sends review to backend
    const onSubmit = async (event) => {
        event.preventDefault();
        await axios.post("http://localhost:8080/review/add", {
            "campgroundId": campgroundId.id,
            "rating": starRating,
            "feedback": feedback,
            "tags": tags
        });
        navigate("/campground");
    };

    const handleCheckboxChange = (event) => {
        const { value, checked } = event.target;
        if (checked) {
            setTags([...tags, value]); 
        } else {
            setTags(tags.filter(tag => tag !== value));  
        }
    };

  return (
    <div>
        <form onSubmit={(event) => onSubmit(event)}>
            {/* <div className="form-group">
                <label htmlFor="campground">Campground ID</label>
                <input 
                    type="text" 
                    name="campground"
                    id="campground" 
                    value={campground} 
                    onChange={(e)=>onInputChange(e)}
                    className="form-control" 
                />
            </div> */}

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

            <div className="form-group">
                    <label>Tags</label>
                    <div style={{
                        border: '1px solid #ced4da',
                        padding: '10px',
                        borderRadius: '4px',
                        height: '100px', 
                        overflowY: 'scroll',
                        msOverflowStyle: 'none',  // IE and Edge
                        scrollbarWidth: 'none',  // Firefox
                    }}>
                        {availableTags.map(tag => (
                            <div key={tag.id} className="form-check">
                                <input
                                    className="form-check-input"
                                    type="checkbox"
                                    id={`tag-${tag.id}`}
                                    value={tag.name}
                                    onChange={handleCheckboxChange}
                                />
                                <label className="form-check-label" htmlFor={`tag-${tag.id}`}>
                                    {tag.name}
                                </label>
                            </div>
                        ))}
                    </div>
                </div>
            
                <button type="submit" className="btn btn-primary">Submit</button>
            
            </form>
    </div>
  )
}
