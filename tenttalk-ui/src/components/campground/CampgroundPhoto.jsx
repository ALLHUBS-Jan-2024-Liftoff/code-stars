import React from 'react'
import axios from 'axios'
import { useEffect } from 'react';

export default function CampgroundPhoto({searchQuery}) {

  useEffect(() => {
    getPhoto();
  },[]);

  async function getPhoto() {

    //creates new instance of Request with url, method, headers, and body
    const postRequest = new Request("https://places.googleapis.com/v1/places:searchText", {
      method: "POST",
      headers: {
        "X-Goog-Api-Key": "api key here",
        "X-Goog-FieldMask": "places.photos"
      },
      body: JSON.stringify({textQuery: `${searchQuery}`})
    })

    let photoName = "";


    try {
      // fetches postResponse and reads in json format
      const postResponse = await fetch(postRequest);
      const postJson = await postResponse.json();

      console.log(postJson.places[0].photos[0]);
      if (!postResponse.ok) {
        throw new Error(`Response status: ${postResponse.status}`);
      } 
    } catch (error) {
      console.error(error.message);
    }


    

  }

  return (
    <div>CampgroundPhoto</div>
  )
}
