import Navbar from "../components/navbar";

export function ReviewForm() {
    return(
    <div>
        <Navbar />
        <h1>Review Form</h1>
        <form>
            <div class="form-group">
                <label for="campground">Campground</label>
                <input list="campground" class="form-control" />
                <datalist id="campground">
                    <option value="Campground 1" />
                    <option value="Campground 2" />
                </datalist>
            </div>

            <div class="form-group">
                <p>Rating</p>
                <div class="form-check form-check-inline">
                    <input type="radio" id="1star" name="rating" value="1" class="form-check-input"/>
                    <label for="1star" class="form-check-label">1 star</label>
                </div>
                <div class="form-check form-check-inline">
                    <input type="radio" id="2star" name="rating" value="2" class="form-check-input"/>
                    <label for="2star" class="form-check-label">2 stars</label>
                </div>
                <div class="form-check form-check-inline">
                    <input type="radio" id="3star" name="rating" value="3" class="form-check-input"/>
                    <label for="3star" class="form-check-label">3 stars</label>
                </div>
                <div class="form-check form-check-inline">
                    <input type="radio" id="4star" name="rating" value="4" class="form-check-input"/>
                    <label for="4star" class="form-check-label">4 stars</label>
                </div>
                <div class="form-check form-check-inline">
                    <input type="radio" id="5star" name="rating" value="5" class="form-check-input"/>
                    <label for="5star" class="form-check-label">5 stars</label>
                </div>
            </div>
                <br />

            <div class="form-group">
                <p>Tags</p>
                <div class="form-check form-check-inline">
                    <input type="checkbox" id="tag1" name="tag" value="tag" class="form-check-input" />
                    <label for="tag1" class="form-check-label">Tag 1</label>
                </div>
                <div class="form-check form-check-inline">
                    <input type="checkbox" id="tag2" name="tag" value="tag" class="form-check-input" />
                    <label for="tag2" class="form-check-label">Tag 2</label>
                </div>
                <div class="form-check form-check-inline">
                    <input type="checkbox" id="tag3" name="tag" value="tag" class="form-check-input" />
                    <label for="tag3" class="form-check-label">Tag 3</label>
                </div>
            </div>
            
            <div class="form-group">
                <label for="review">Review</label> <br />
                <textarea rows="5" cols="50" name="review" id="review" class="form-control">Write review here...</textarea>
            </div>
            
                <button type="submit" class="btn btn-primary">Submit</button>
            
            </form>
    </div>
    );
}