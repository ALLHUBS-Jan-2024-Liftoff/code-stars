import Navbar from "../components/navbar";
import React from 'react';
import Share from '../components/share';
import ViewCampground from '../components/campground/ViewCampground';
import { DisplayAllReviews } from "../components/review/DisplayAllReviews";
import { DisplayRating } from "../components/review/DisplayRating";
import { Link, useParams } from "react-router-dom";
import axios from "axios";
import { useState, useEffect } from "react";
import CampgroundPhoto from "../components/campground/CampgroundPhoto";



export function Campground() {

    const { id } = useParams();

    const [campground, setCampground] = useState([]);

    useEffect(() => {
        loadCampground();
    },[]);

    const loadCampground = async () => {
        try {
            const result = await axios.get(`http://localhost:8080/campground/${id}`);
            setCampground(result.data);
        } catch (error) {
            console.error('Error fetching campground:', error);
        }
    };

    return(
    <div>
        <Navbar />
        <ViewCampground />
        <CampgroundPhoto campgroundName={"Gateway Arch"}/>
        <div>
            <h3>Average Rating: {(Math.round(campground.rating*10))/10 }</h3>
            <DisplayRating rating={ campground.rating } size={36} />
        </div>
        <Share />
        <DisplayAllReviews campgroundId={ id }/>
    </div>
    );
}
