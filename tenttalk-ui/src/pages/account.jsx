import React from 'react';
import Navbar from "../components/navbar";
import AccountFunction from '../components/account/AccountFunction';
import Logout from '../components/account/Logout'; 

export function Account() {
  
  return (
    <div>
      <Navbar />
      <h1>Account</h1>
      <AccountFunction />
      <Logout />
    </div>
  );
}

