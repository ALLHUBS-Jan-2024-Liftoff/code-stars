// BearSafety.jsx
import React from 'react';

const BearSafety = ({ tags }) => {
    console.log(tags); 



    if (!Array.isArray(tags) || (!tags.includes('bears') && !tags.includes('bear'))) {
        return <p>No bear sightings.</p>; // Render "No bear sightings" message if 'bears' or 'bear' tag is not present
    }


    return (
        <div className="alert alert-danger" role="alert">
            <h4 className="alert-heading">Beware of Wildlife!</h4>
            <p>Important bear safety information:</p>
            <a href="https://www.nps.gov/subjects/bears/safety.htm" target="_blank" rel="noopener noreferrer" className="btn btn-primary">
                BEWARE: Bear Safety
            </a>
        </div>
    );
};



export default BearSafety;

