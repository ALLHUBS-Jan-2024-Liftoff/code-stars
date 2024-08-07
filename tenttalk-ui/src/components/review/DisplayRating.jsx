import React from 'react'

export function DisplayRating ({rating, size}) {
  let starRating;

  if (rating >= 4.6) {
    starRating = ("★★★★★")
  } else if (rating >= 3.6) {
    starRating = ("★★★★☆")
  } else if (rating >= 2.6) {
    starRating = ("★★★☆☆")
  } else if (rating >= 1.6) {
    starRating = ("★★☆☆☆") 
  } else if (rating > 0) {
    starRating = ("★☆☆☆☆")
  } else {
    return ("Rating not available")
  }

  return (
    <p style={{fontSize: `${size}px`}}>{starRating}</p>
  )
}
