import React from 'react'

const CampgroundCard = ({ campgroundCard }) => {
  return (
    <Link to={`/campgrounds/${campgroundCard.id}`} className="campground__card">
        <div className="campground__header">
            <div className="campground__img"> 
                <img src={campgroundCard.photoUrl} alt={campgroundCard.name} />
            </div>
            <div className="campground__details">
                <p className="campground_name">{campgroundCard.name.substring(0,15)}</p>
                <p className="campground_title">{campgroundCard.rating}</p>
            </div>
        </div>
        <div className="campground__body">
            <p><i className="bi bi-geo"></i> {campgroundCard.address}</p>
            <p><i className="bi bi-globe"></i> {campgroundCard.website}</p>
            <p><i className="bi bi-file-earmark-richtext"></i> {campgroundCard.reviews}</p>
            <p>{campgroundCard.status === 'Warning' ? <i className='bi bi-exclamation-diamond-fill'></i> :           <i className="bi bi-check-circle-fill"></i>} {campgroundCard.status}</p>
        </div>
    </Link>
  )
}

export default CampgroundCard