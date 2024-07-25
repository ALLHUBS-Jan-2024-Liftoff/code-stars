import React from 'react'
import Navbar from "../components/navbar";
import CreateCampgroundForm from '../components/campground/CreateCampgroundForm';


export function CreateCampground () {
    return (
        <div>
            <Navbar />
            <h1>Create Campground</h1>
            <CreateCampgroundForm />
        </div>
    )
}