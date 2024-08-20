import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

export default function AccountFunction() {
  const [userId, setUserId] = useState();

  const [user, setUser] = useState(null);
  const navigate = useNavigate();


  const fetchUserData = async () => {
    // try {
      setUserId(sessionStorage.getItem("user"))
    //   if (!userId) {
      
    //     return;
    //   }

    await axios.get(`http://localhost:8080/api/users/account`, { withCredentials: true });
    setUser(response.data);

    // } catch (error) {
    //   console.error('Error fetching user data:', error);
    //   navigate('/login'); // Redirect to login if not authenticated
    // }
  };

  useEffect(() => {
    // Fetch user information
    fetchUserData();
  }, []);

  // if (!user) return <p>Loading...</p>;

  return (
    <div>
      <h2>User ID: {userId} </h2>
      {/* <p>Username: {user.username}</p>
      <p>Email: {user.email}</p> */}
    </div>
  );
}

