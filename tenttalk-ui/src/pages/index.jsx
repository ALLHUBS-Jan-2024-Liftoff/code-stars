import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react'
import { Link } from 'react-router-dom'
import Navbar from "../components/navbar";


export function Index() {
    return(
    <div>
        <Navbar />
        <h1>Home Page</h1>
        <p>Hello, Tent Talk!</p> 
    </div>
    );
}