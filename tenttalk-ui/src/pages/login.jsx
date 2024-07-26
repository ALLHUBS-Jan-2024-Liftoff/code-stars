import React from 'react';
import Navbar from "../components/navbar";
import LoginForm from '../components/account/LoginForm';

export function Login() {
  return (
    <div>
      <Navbar />
      <h1>Login</h1>
      <LoginForm />
    </div>
  )
}
