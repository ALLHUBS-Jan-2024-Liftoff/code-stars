import React from 'react'
import Campgroundcard from "./CampgroundCard"

const FavoriteList = ({ data, currentPage, getAllCampgrounds }) => {
  return (
    <div>
      {data?.content?.length=== 0 && <div>No Campgrounds</div>}

      <ul className = 'contact__list'>
        {data?.content?.length > 0 && data.content.map(campground => <Campgroundcard Campgroundcard = {campground} key={campground.id} />)}
      </ul>
    </div>
  )
}

export default FavoriteList