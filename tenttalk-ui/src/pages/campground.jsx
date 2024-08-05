import Navbar from "../components/navbar";
import React from 'react';
import Share from '../components/share';
import ViewCampground from '../components/campground/ViewCampground';
import { DisplayAllReviews } from "../components/review/DisplayAllReviews";
import { DisplayRating } from "../components/review/DisplayRating";
import { Link, useParams } from "react-router-dom";
import DisplayAverateRating from "../components/campground/DisplayAverageRating";


export function Campground() {
    const { id } = useParams();

    return(
    <div>
        <Navbar />
        <ViewCampground />

        <Share />
        <DisplayAllReviews campgroundId={ id }/>
    </div>
    );
}
