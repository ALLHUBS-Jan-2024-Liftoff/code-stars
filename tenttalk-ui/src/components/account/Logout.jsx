import React from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

export default function Logout({ setAuthenticated }) {
  const navigate = useNavigate();

  const handleLogout = async () => {
    try {
      await axios.get('http://localhost:8080/api/users/logout', { withCredentials: true });

      
      sessionStorage.removeItem("userId");

      // Update the state to reflect that the user is no longer authenticated(not working properly)
      //setAuthenticated(false);

      
      navigate('/login');
    } catch (error) {
      console.error("Logout failed:", error);
    }
  };

  return (
    <button onClick={handleLogout} className="btn btn-secondary">Logout</button>
  );
}
