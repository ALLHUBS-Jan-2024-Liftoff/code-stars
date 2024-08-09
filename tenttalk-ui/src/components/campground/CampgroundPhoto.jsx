import React from 'react'
import axios from 'axios'
import { useEffect } from 'react';

export default function CampgroundPhoto({campgroundName}) {

  useEffect(() => {
    loadPhoto();
  },[]);

  async function loadPhoto() {
    const postRequestHeaders = {
        "X-Goog-Api-Key": "{key}",
        "X-Goog-FieldMask": "places.photos"
    }

    const postRequestData = {
      textQuery: `${campgroundName}`
    }

    await axios.post("https://places.googleapis.com/v1/places:searchText", postRequestData, {
      headers : postRequestHeaders
    });
    console.log(response.data);

  }

  return (
    <div>CampgroundPhoto</div>
  )
}
