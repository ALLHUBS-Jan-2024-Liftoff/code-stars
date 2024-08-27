import React, { useState, useEffect } from 'react';
import CampgroundPhoto from '../campground/CampgroundPhoto';
import '../../favorite.css'

const UserFavorites = () => {
  const [favorites, setFavorites] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const storedUserId = sessionStorage.getItem("userId");
    console.log("Stored User ID:", storedUserId); // Debugging line

    if (storedUserId) {
      fetch(`http://localhost:8080/favorites/user/${storedUserId}`)
        .then(response => {
          if (!response.ok) {
            throw new Error('Network response was not ok');
          }
          return response.json();
        })
        .then(data => {
          console.log("Fetched Data:", data); // Debugging line
          setFavorites(data);
          setLoading(false);
        })
        .catch(error => {
          console.error("There was a problem with the fetch operation:", error);
          setLoading(false);
        });
    } else {
      console.error("User ID is not provided");
      setLoading(false);
    }
  }, []);

  if (loading) {
    return <p>Loading...</p>;
  }

  return (
    <div className="user-favorites-container">
      {favorites.length === 0 ? (
        <p>No favorites found.</p>
      ) : (
        favorites.map(favorite => (
          <div key={favorite.id} className="campground-card">
              <CampgroundPhoto searchQuery={favorite.campground.name} imageHeight={200} />
            <h2>{favorite.campground.name}</h2>
            <p>Address: {favorite.campground.address}</p>
            <p>
              Website: <a href={favorite.campground.website} target="_blank" rel="noopener noreferrer">{favorite.campground.website}</a>
            </p>
            <p>Rating: {favorite.campground.rating}</p>
          </div>
        ))
      )}
    </div>
  );
};

export default UserFavorites;


