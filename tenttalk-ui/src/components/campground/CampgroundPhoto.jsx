import React, { useState } from 'react'
import { useEffect } from 'react';

const API_KEY = "";

export default function CampgroundPhoto({searchQuery}) {

  const [photoURL, setPhotoURL] = useState();

  useEffect(() => {
    getPhoto();
  },[]);

  async function getPhoto() {


    //creates new instance of Request with url, method, headers, and body
    const postRequest = new Request("https://places.googleapis.com/v1/places:searchText", {
      method: "POST",
      headers: {
        "X-Goog-Api-Key": API_KEY,
        "X-Goog-FieldMask": "places.photos"
      },
      body: JSON.stringify({textQuery: `${searchQuery}`})
    });


    try {
      // fetches postResponse and reads in json format
      const postResponse = await fetch(postRequest);
      const postJson = await postResponse.json();

      // sets photoName to photo name
      let photoName = postJson.places[0].photos[0].name;
      
      // fetches getResponse
      const getResponse = await fetch(new Request(`https://places.googleapis.com/v1/${photoName}/media?key=${API_KEY}&maxWidthPx=400`))
        // extracts image URL from blob and sets state of photoURL
        .then(getResponse => getResponse.blob())
        .then((blob) => {
          setPhotoURL(URL.createObjectURL(blob));
        })
      

      // throws error if either response isn't 2xx OK
      if (!postResponse.ok) {
        throw new Error(`Response status: ${postResponse.status}`);
      } 
      if (!getResponse.ok) {
        throw new Error(`Response status: ${getResponse.status}`);
      }
    } catch (error) {
      console.error(error.message);
    }


    

  }

  return (
    <div>
      <img src={photoURL} alt="Campground" />
    </div>
  )
}
