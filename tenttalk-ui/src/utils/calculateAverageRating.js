import axios from "axios";

export function calculateAverageRating(campgroundId) {
    let resultArray = [];
    let ratingArray= [];

    //axios request to get all reviews
    const loadReviews = async () => {
        const result = await axios.get("http://localhost:8080/review/getAll");
        console.log("reviews loaded");
        resultArray.push(result.data);
    }

    //iterates through response. if id matches campgroundId, push rating to ratingArray
    async function findAverage() {
        await loadReviews();
        console.log(resultArray[0][0].campground);
    }
    //add all items in array, divide by ratingArray.length

    //return average campground rating
    findAverage();
    return "averageRating";
}

calculateAverageRating(1);
