import React from 'react'
import { useState } from 'react'
import axios from 'axios';
import { useNavigate } from 'react-router-dom';


export default function CreateCampgroundForm() {

    const[campground, setCampground] = useState({
        name: "",
        address: "",
        website: ""
    })

    const{name, address, website} = campground;

    const onInputChange=(e)=> {
        setCampground({...campground, [e.target.name]:e.target.value})
    }

    const onSubmit = async (e)=> {
        e.preventDefault;
        await axios.post("http://localhost:8080/campground", campground)
        useNavigate("/campground")
    }

  return (
    <div>
        <form onSubmit={(e)=>onSubmit(e)}>
            <div className="form-group">
                <label htmlFor="name">Campground Name</label>
                <input 
                    type="text" 
                    className="form-control" 
                    name= "name"
                    id="name" 
                    value={name}
                    onChange={(e)=>onInputChange(e)}
                />
            </div>
            <div className="form-group">
                <label htmlFor="address">Address</label>
                <input 
                    type="text" 
                    className="form-control" 
                    name="address"
                    id="address" 
                    value={address}
                    onChange={(e)=>onInputChange(e)}
                />
            </div>
            <div className="form-group">
                <label htmlFor="website">Website</label>
                <input 
                    type="text" 
                    className="form-control" 
                    name= "website"
                    id="website" 
                    value={website}
                    onChange={(e)=>onInputChange(e)}
                />
            </div>
            <button type="submit" className="btn btn-primary">Submit</button>
        </form>
    </div>
  )
}
