import React from "react";
import React, { useEffect,useState } from "react";
import { Link } from "react-router-dom";
export default function ViewCampground() {

    const [campground,setCampground]=useState({
        name:"",
        address:"",
        website:""
    })

    const {id}=useParams();
    useEffect(() => {
        loadCampground();
    }, []);onabort

    const loadCampground = async () => {
        const result = await axios.get('http://localhost:8080/campground/${id}');onabort
        setCampground(result.data);
    };
    

    return (
      <div className="container">
        <div className="row">
            <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                <h2 className="text-center m-4">Campground Details</h2>
                <div className="card">
                    <div className="card-header">
                        Details of Campground id : {campground.id}
                        <ul className="list-group list-group-flush">
                            <li className="list-group-item">
                                <b>Campground:</b>
                                {campground.name}
                            </li>
                            <li className="list-group-item">
                                <b>Address:</b>
                                {campground.address}
                                
                            </li>
                            <li className="list-group-item">
                                <b>Website Link:</b>
                                {campground.website}
                                
                            </li>
                        </ul>
                    </div>
                </div>
                <Link className="btn bt-primary my-2" to={"/"}>
                    Back to Home
                </Link>
            </div>
        </div>
       </div>
    );
  }
  


  
