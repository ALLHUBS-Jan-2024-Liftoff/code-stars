import React from 'react';
import Navbar from "../components/navbar";
import AccountFunction from '../components/account/AccountFunction';
import Logout from '../components/account/Logout'; 
import { useNavigate } from 'react-router-dom';

export function Account() {
  
  const navigate = useNavigate(); 

  const handleNavigate = () => {
    navigate('/favorites'); 
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


