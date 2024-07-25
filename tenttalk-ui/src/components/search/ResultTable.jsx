import React, { useState, useEffect } from 'react';
import axios from 'axios';

export default function ResultTable() {
  
    const [campgrounds, setCampgrounds] = useState([]);
    useEffect(() => {
        
    });
  
    return (
    <div>
        <table className="table">
            <thead>
                <tr>
                    <th scope="col">Campground Name</th>
                    <th scope="col">Rating</th>
                    <th scope="col">Button</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Example campground</td>
                    <td>5</td>
                    <td>Button</td>
                </tr>
            </tbody>
        </table>
    </div>
  )
}
