import React, { useState, useEffect } from 'react';
import axios from 'axios';

export default function ResultTable() {
  
    const [campgrounds, setCampgrounds] = useState([]);

    useEffect(() => {
        loadCampgrounds();
    },[]);

    const loadCampgrounds = async () => {
        const result = await axios.get("http://localhost:8080/campground/getAll");
        setCampgrounds(result.data);
    }
  
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

                {
                    campgrounds.map((campground, index)=>{
                        <tr>
                            <td>{campground.name}</td>
                            <td>{campground.rating}</td>
                            <td>
                                <button className="btn btn-primary">View</button>
                            </td>
                        </tr>
                    })
                }
                
            </tbody>
        </table>
    </div>
  )
}
