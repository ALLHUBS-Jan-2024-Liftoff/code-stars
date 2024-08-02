import Navbar from "../components/navbar";

import React from 'react';
import Share from '../components/share';
import { Link } from 'react-router-dom';
import ViewCampground from '../components/campground/ViewCampground';


export function Campground() {
    return(
    <div>
        <Navbar />
        <h1>Campground Page</h1>
        <p>Hello, Tent Talk!</p> 

        <ViewCampground />
        <Share />

    </div>
    );
}
