import React from 'react'
import { DisplayRating } from '../review/DisplayRating';

export default function DisplayAverageRating({reviewArray, size}) {
    let sum = 0;
    // iterate through review array, adding each rating to sum
    for (let i = 0; i < reviewArray.length; i++) {
        sum = sum + reviewArray[i].rating;
    }
    // divide sum by reviewsArray.length, store as average
    let average = sum/reviewArray.length;
    
    // return DisplayRating with average as props
  return (
    <DisplayRating rating={average} size={size} />
  )
}
