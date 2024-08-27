import React from 'react'
import campground from "../../pages/campground"

const FavoriteList = ({ data, getAllCampgrounds }) => {
  return (
    <div>
      //acces header? response, array of favorites 
      {data?.content?.length=== 0 && <div>No Added Campgrounds</div>}

      <ul className = 'contact__list'>
        {data?.content?.length > 0 && data.content.map(campground => <Campground campground = {campground} key={campground.id} />)}
      </ul>
    </div>
  )
}

export default FavoriteList