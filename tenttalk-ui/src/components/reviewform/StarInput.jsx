import "./stars.css"
import { useState } from "react";

const COUNT = 5;
const ICON = "★";
const SELECTED_COLOR = "dodgerblue";
const UNSELECTED_COLOR = "lightgrey";

export default function StarInput({defaultRating, iconSize}) {
    const [rating, setRating] = useState(defaultRating); // use state for clicked stars
    const [temporaryRating, setTemporaryRating] = useState(0); // use state for stars on hover

    let stars = Array(COUNT).fill(ICON);
    
    return <div className="starsContainer">
        
        {stars.map((item, index) => { //iterates over stars array
            const isActiveColor = (rating || temporaryRating) &&
            (index < rating || index < temporaryRating);
            let elementColor = "";

            if (isActiveColor) {
                elementColor = SELECTED_COLOR;
            } else {
                elementColor = UNSELECTED_COLOR;
            }
            
            return (
            <div 
                className="star" 
                key={index}
                style={{ fontSize: iconSize ? `${iconSize}px` : "24px", color: elementColor}} //sets size to 24px unless iconSize passed in
                onMouseEnter={() => setTemporaryRating(index + 1)} //selects stars on hover
                onMouseLeave={() => setTemporaryRating(0)} //deselects stars without hover
                onClick={() => setRating(index + 1)} //sets rating on click
            >
                {ICON}
            </div>
        );
        })}
    </div>;
    
}