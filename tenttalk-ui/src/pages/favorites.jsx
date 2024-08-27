import React from 'react'
import Navbar from "../components/navbar";
import UserFavorites from '../components/favoriteCampground/userFavorites';

export function Favorites() {
  
    return (
       
        <div>
             <Navbar />
            <h1>Favorite Campground's</h1>
            <UserFavorites />
        </div>
    )
  }