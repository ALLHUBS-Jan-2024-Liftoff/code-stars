import React, { useState, useEffect } from 'react';
import axios from 'axios';

export default function AccountFunction() {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const userId = sessionStorage.getItem("userId"); // Retrieve user ID from sessionStorage

    if (userId) {
      axios.get(`http://localhost:8080/api/users/${userId}`)
        .then(response => {
          setUser(response.data);
          setLoading(false);
        })
        .catch(error => {
          console.error("There was an error fetching the user data!", error);
          setLoading(false);
        });
    } else {
      setLoading(false);
    }
  }, []);

  if (loading) {
    return <p>Loading...</p>;
  }

  if (!user) {
    return <p>No user data found.</p>;
  }

  return (
    <div>
      <h2>User Info</h2>
      <p>Username: {user.username}</p>
      <p>Email: {user.email}</p>
    </div>
  );
}







