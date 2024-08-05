import axios from "axios";

export default async function calculateAverageRating(campgroundId) {
        let resultArray = [];
        let ratingArray = [];

         //axios request to get all reviews
        const result = await axios.get(`http://localhost:8080/campground/${campgroundId}`);
        // pushes result reviews to array
        resultArray.push(result.data.reviews);
        
        // loops over result array, pushing rating to new array
        for (let i=0; i <= resultArray.length; i++) {
            ratingArray.push(resultArray[0][i].rating);
        }

        // calculates sum of ratingArray
        let sum = 0;
        for (let i = 0; i < ratingArray.length; i++ ) {
            sum += ratingArray[i];
          }
        
        let averageRating = sum / ratingArray.length;
        return averageRating;
    }

