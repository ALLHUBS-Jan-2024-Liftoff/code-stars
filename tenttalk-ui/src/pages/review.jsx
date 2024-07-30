import Navbar from "../components/navbar";
import ReviewForm from "../components/review/ReviewForm";

export function Review() {
    return(
    <div>
        <Navbar />
        <h1>Write a Review</h1>
        <ReviewForm />
    </div>
    );
}