import Navbar from "../components/navbar";
import DisplayReview from "../components/review/DisplayReview";

import React from 'react';
import Share from '../components/share';

export function Campground() {
    return(
    <div>
        <Navbar />
        <h1>Campground Page</h1>
        <p>Hello, Tent Talk!</p> 

        <Share />
        <DisplayReview id={1} />
    </div>
    );
}