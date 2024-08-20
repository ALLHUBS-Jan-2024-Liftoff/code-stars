import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

export default function AccountFunction() {
  const [user, setUser] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    // Fetch user information
    const fetchUserData = async () => {
      try {
        const userId = sessionStorage.getItem("user"); 
        if (!userId) {
        
          return;
        }

        const userResponse = await axios.get(`http://localhost:8080/api/users/account`, { withCredentials: true });
        setUser(userResponse.data);
      } catch (error) {
        console.error('Error fetching user data:', error);
        navigate('/login'); // Redirect to login if not authenticated
      }
    };

    fetchUserData();
  }, [navigate]);

  if (!user) return <p>Loading...</p>;

  return (
    <div>
      <h2>User Info</h2>
      <p>Username: {user.username}</p>
      <p>Email: {user.email}</p>
    </div>
  );
}

