import React from 'react'

const Header = ({ toggleModal, numOfFavorites }) => {
  return (
    <header className = 'header'>
        <div>favoriteList
            <h3>Favorite List ({numOfFavorites})</h3>
            <button onClick={()=> toggleModal(true)} className = 'btn'>
                <i className ='bi bi-plus-square'></i>Add To Favorites
            </button>
        </div> 
    </header>
    
  )
}

export default Header