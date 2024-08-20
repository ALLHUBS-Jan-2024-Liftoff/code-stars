import React from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';


export default function Logout() {
  const navigate = useNavigate();

  const handleLogout = async () => {
    try {
      await axios.get('http://localhost:8080/api/users/logout', { withCredentials: true });
      sessionStorage.clear();  // Clear session storage to remove user data
      navigate('/login');
    } catch (error) {
      console.error("Logout failed", error);
    }
  };

  return (
    <button onClick={handleLogout}>Logout</button>
  );
}

