import React from 'react';
import Navbar from "../components/navbar";
import AccountFunction from '../components/account/AccountFunction';
import Logout from '../components/account/Logout'; 
import { useNavigate } from 'react-router-dom';

export function Account() {
  
  const navigate = useNavigate(); // Initialize useNavigate

  // Function to handle button click and navigate to the desired route
  const handleNavigate = () => {
    navigate('/favorites'); // Replace '/create-campground' with the desired route path
  };


  return (
    <div>
      <Navbar />
      <h1>Account</h1>
      <AccountFunction />
      <Logout />
      <button onClick={handleNavigate}>Go to Favorites</button>
    </div>
  );
}


