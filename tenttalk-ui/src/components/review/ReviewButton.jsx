import React from 'react'
import { Link } from 'react-router-dom'

export default function ReviewButton({campgroundId}) {
  return (
    <div>
        <Link
            className="btn btn-primary"
            to={`/review/${campgroundId}`}
        >Write a Review</Link>
    </div>
  )
}
