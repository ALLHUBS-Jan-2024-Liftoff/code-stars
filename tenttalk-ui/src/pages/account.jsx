import React from 'react';
import Navbar from "../components/navbar";
import AccountFunction from '../components/account/AccountFunction';
import Logout from '../components/account/Logout'; 
import Tester from '../components/favoriteCampground/Tester';

export function Account() {
  
  return (
    <div>
      <Navbar />
      <h1>Account</h1>
      <AccountFunction />
      <Logout />
      <Tester />
    </div>
  );
}


