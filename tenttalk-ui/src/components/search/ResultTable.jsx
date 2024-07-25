import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

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
                                <Link to={`/campground/${campground.id}`} className="btn btn-primary">View</Link>
                            </td>
                        </tr>
                    })
                }
                
            </tbody>
        </table>
    </div>
  )
}
