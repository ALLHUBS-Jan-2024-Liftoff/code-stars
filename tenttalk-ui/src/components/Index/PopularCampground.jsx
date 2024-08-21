import 'bootstrap/dist/css/bootstrap.min.css';
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Navbar from "../navbar";
import CampgroundPhoto from '../campground/CampgroundPhoto';

export default function popularCampground() {
    const [popularCampground, setPopularCampground] = useState(null);

    useEffect(() => {
        axios.get('http://localhost:8080/campground/popular')
            .then(response => {
                setPopularCampground(response.data);
            })
            .catch(error => {
                console.error("There was an error fetching the popular campground!", error);
            });
    }, []);

    return (
        <div>
            {popularCampground ? (
                <div>
                    <h2>Most Popular Campground</h2>
                    <p>Name: {popularCampground.name}</p>
                    <p>Address: {popularCampground.address}</p>
                    <p>Rating: {popularCampground.rating}</p>
                    <p>Website: {popularCampground.website}</p>
                    <CampgroundPhoto searchQuery={popularCampground.name} imageHeight={300} />
                </div>
            ) : (
                <p>No popular campground available this week.</p>
            )}
        </div>
    );
}
