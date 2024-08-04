import Navbar from "../components/navbar";
import React from 'react';
import Share from '../components/share';
import ViewCampground from '../components/campground/ViewCampground';
import { Link, useParams } from "react-router-dom";


export function Campground() {
    const { id } = useParams();

    return(
    <div>
        <Navbar />
        <h1>Campground Page</h1>
        <p>Hello, Tent Talk!</p> 

        <ViewCampground />
        <Share />
        <DisplayReview id={1} />
        <DisplayReview id={2} />
    </div>
    );
}
