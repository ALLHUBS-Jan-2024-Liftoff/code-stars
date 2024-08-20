import React from 'react'
import { Link } from 'react-router-dom'
import Logout from './account/Logout'

export default function Navbarr({ authenticated, setAuthenticated }) {
  return (
    <div>
      <ul className='navbar'>
        <li><Link to="/">Home  </Link></li>
        <li><Link to="/search">Search  </Link></li>
        <li><Link to="/login">Login  </Link></li>
        <li><Link to="/register">Register  </Link></li>
        <li><Link to="/account">Account  </Link></li>
        <li><Link to="/create-campground">Create Campground  </Link></li>
        <li><Logout setAuthenticated={setAuthenticated} /></li>
      </ul>
    </div>
  )
}
