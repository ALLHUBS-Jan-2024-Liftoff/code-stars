import Navbar from "../components/navbar";
import React from 'react';
import Share from '../components/share';
import ViewCampground from '../components/campground/ViewCampground';
import { DisplayAllReviews } from "../components/review/DisplayAllReviews";
import { DisplayRating } from "../components/review/DisplayRating";
import SavePDF from "../components/campground/SavePDF";
import { Link, useParams } from "react-router-dom";
import axios from "axios";
import { useState, useEffect } from "react";
import CampgroundPhoto from "../components/campground/CampgroundPhoto";
import ReviewButton from "../components/review/ReviewButton";
import BearSafety from '../components/campground/BearSafety'; 
import AddToFavoritesButton from '../components/favoriteCampground/addToFavoritesButton'; 



export function Campground() {
    const { id } = useParams();
    const [campground, setCampground] = useState([]);
    const [tags, setTags] = useState([]); // State to handle tags
    const [hasBears, setHasBears] = useState(false);

    useEffect(() => {
        loadCampground();
    },[]);



//tags
// manage tags using useState and update them within the loadCampground function
// "tags": campground.tags.map((tag) => tag.name) // maps tag array to correct format
//nested loop through reviews and then through tags

    const loadCampground = async () => {
        try {
            const result = await axios.get(`http://localhost:8080/campground/${id}`);
           // console.log('Full API response:', result.data);
            setCampground(result.data);
            

            // Set the tags directly from the campground data if available
            if (result.data.tags) {
                const tagNames = result.data.tags.map(tag => tag.name);
                setTags(tagNames);
                //console.log('Tags set:', tagNames);
            }

            //nested for loop
            for (let i = 0; i < result.data.reviews.length; i++) {
                const review = result.data.reviews[i];
                // console.log(review);
                for (let j = 0; j < review.tags.length; j++) {
                    const tag = review.tags[j];
                    // console.log(tag);
                    if (tag.name === 'bears') {
                        // console.log("Has bears!");
                        setHasBears(true);
                    }
                    
                }
            }

        } catch (error) {
            console.error('Error fetching campground:', error);
        }
    };


    return(
    <div>
        <Navbar />
        <div id="pdf">
            <ViewCampground />
            <CampgroundPhoto searchQuery={campground.name} imageHeight={400} />
            <div>
                <h3>Average Rating: {(Math.round(campground.rating*10))/10 }</h3>
                <DisplayRating rating={ campground.rating } size={36} />
            </div>

        </div>
        
        {/* //boolean and terinary */}
        {hasBears ? <BearSafety tags={campground.tags} /> : <p> No Bear Sightings! </p>}

        <SavePDF />
        <Share />
        <AddToFavoritesButton campgroundId={campground.id} />
        <ReviewButton campgroundId={ id }/>
        <DisplayAllReviews campgroundId={ id }/>
    </div>
    );
    
}
