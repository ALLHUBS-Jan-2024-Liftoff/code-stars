// BearSafety.jsx
import React from 'react';

//change to correct tag name

const BearSafety = ({ tags }) => {
    if (!tags.includes('bears')) {
        return null; // Don't render anything if 'bears' tag is not present
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
