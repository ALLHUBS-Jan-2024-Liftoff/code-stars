import React from 'react'
import Navbar from "../components/navbar";
import RegisterForm from '../components/account/RegisterForm';

export function Register() {
  return (
    <div>
      <Navbar />
      <h1>Register</h1>
      <RegisterForm />
    </div>
  )
}
