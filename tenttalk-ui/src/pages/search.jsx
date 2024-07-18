import { Link } from "react-router-dom"

export function Search() {
    return(
    <div>
        <h1>Search Page</h1>
        <p>Hello, Tent Talk!</p>
        <Link to="/">Home </Link>
        <Link to="/search">Search </Link>
        <Link to="/review">Review Form </Link>
        <Link to="/campground">Campground Page</Link>
    </div>
    );
}