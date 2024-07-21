import React from 'react'
import Navbar from "../components/navbar";


export function CreateCampground () {
    return (
        <div>
            <Navbar />
            <h1>Create Campground</h1>
            <form>
                <div class="form-group">
                    <label for="name">Campground Name</label>
                    <input type="text" class="form-control" id="name" />
                </div>
                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" />
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
                
            </form>
        </div>
    )
}