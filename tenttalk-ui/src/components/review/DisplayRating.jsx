import React from 'react'

export function DisplayRating ({rating}) {
  if (rating >= 4.6) {
    return ("★★★★★")
  } else if (rating >= 3.6) {
    return ("★★★★☆")
  } else if (rating >= 2.6) {
    return ("★★★☆☆")
  } else if (rating >= 1.6) {
    return ("★★☆☆☆") 
  } else if (rating > 0) {
    return ("★☆☆☆☆")
  } else {
    return ("Rating not available")
  }
}
