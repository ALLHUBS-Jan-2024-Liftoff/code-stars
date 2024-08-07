import "./stars.css";
import { useState } from "react";

export function StarInput({ starRating, setStarRating }) {
    return (
      <div>
        {[1, 2, 3, 4, 5].map((star) => {
          return (  
            <span
              className='start'
              style={{
                cursor: 'pointer',
                color: starRating >= star ? 'dodgerblue' : 'lightgray',
                fontSize: `35px`,
              }}
              onClick={() => {
                setStarRating(star)
              }}
            >
              {' '}
              ★{' '}
            </span>
          )
        })}
      </div>
    )
  }