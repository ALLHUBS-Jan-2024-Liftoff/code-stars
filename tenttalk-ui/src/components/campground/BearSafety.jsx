// BearSafety.jsx
import React from 'react';

const BearSafety = ({ tags }) => {
    console.log(tags); 


    return (
        <div className="alert alert-danger" role="alert">
            <h4 className="alert-heading">Beware of Wildlife!</h4>
            <p>Important bear safety information:</p>
            <a href="https://www.nps.gov/subjects/bears/safety.htm" target="_blank" rel="noopener noreferrer" className="btn btn-danger">
                BEWARE: Bear Safety
            </a>
        </div>
    );
};


export default BearSafety;

