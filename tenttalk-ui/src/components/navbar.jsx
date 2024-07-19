import React from 'react'
import { Link } from 'react-router-dom'

export default function Navbar() {
  return (
    <div>
      <ul className='navbar'>
        <li><Link to="/">Home  </Link></li>
        <li><Link to="/search">Search  </Link></li>
        <li><Link to="/review">Review Form  </Link></li>
        <li><Link to="/campground">Campground Page  </Link></li>
        <li><Link to="/login">Login  </Link></li>
        <li><Link to="/register">Register  </Link></li>
        <li><Link to="/account">Account  </Link></li>
      </ul>
    </div>
  )
}
