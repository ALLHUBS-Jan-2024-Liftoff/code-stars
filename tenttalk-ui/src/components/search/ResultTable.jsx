import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import { DisplayRating } from '../review/DisplayRating';


export default function ResultTable() {
  
    // initializes campgrounds hook
    const [campgrounds, setCampgrounds] = useState([]);

    //loads campgrounds when page is loaded
    useEffect(() => {
        loadCampgrounds();
    },[]);

    //sets state of campgrounds to the results of axios get request
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
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>

                { //creates a table row for each result in campground hook
                    campgrounds.map((campground)=>{
                        return (
                        <tr key={campground.id}>
                            <td>{campground.name}</td>
                            <td> <DisplayRating rating={campground.rating} size={20} /> </td>
                            <td>
                                <Link
                                    className="btn btn-primary"
                                    to={`/campground/${campground.id}`}
                                >View</Link>
                            </td>
                        </tr>
                        )
                    })
                }
                
            </tbody>
        </table>
    </div>
  )
}
