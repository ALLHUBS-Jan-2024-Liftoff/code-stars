import Navbar from "../components/navbar";
import ReviewForm from "../components/review/ReviewForm";
import { useParams } from "react-router-dom";

export function Review() {

    const id = useParams();


    return(
    <div>
        <Navbar />
        <h1>Write a Review</h1>
        <ReviewForm campgroundId={id} />
    </div>
    );
}