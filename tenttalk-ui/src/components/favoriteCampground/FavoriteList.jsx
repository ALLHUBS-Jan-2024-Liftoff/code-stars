import React from 'react'
import Campgroundcard from "./CampgroundCard"

const FavoriteList = ({ data, getAllCampgrounds }) => {
  return (
    <div>
      //acces header? response, array of favorites 
      {data?.content?.length=== 0 && <div>No Added Campgrounds</div>}

      <ul className = 'contact__list'>
        {data?.content?.length > 0 && data.content.map(campgroundCard => <CampgroundCard campgroundCard = {campgroundCard} key={campgroundCard.id} />)}
      </ul>
    </div>
  )
}

export default FavoriteList