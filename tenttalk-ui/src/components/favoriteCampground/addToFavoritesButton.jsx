import React from 'react';

const AddToFavoritesButton = ({ campgroundId }) => {
  const handleAddToFavorites = () => {
    const userId = sessionStorage.getItem("userId"); // Retrieve the user ID from session storage

    if (!userId) {
      console.error("User ID is not provided");
      return;
    }

    // Make a POST request to add the campground to the user's favorites
    fetch(`http://localhost:8080/favorites/add`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        userId: userId,
        campId: campgroundId
      })
    })
      .then(response => {
        if (!response.ok) {
          throw new Error('Failed to add the campground to favorites');
        }
        return response.json();
      })
      .then(data => {
        alert("Campground added to favorites successfully!");
        console.log(data); // Optional: Handle the response data
      })
      .catch(error => {
        console.error('Error adding campground to favorites:', error);
      });
  };

  return (
    <button onClick={handleAddToFavorites} className="add-to-favorites-button">
      Add to Favorites
    </button>
  );
};

export default AddToFavoritesButton;