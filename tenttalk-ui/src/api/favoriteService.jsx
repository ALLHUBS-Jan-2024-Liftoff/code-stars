import axios from 'axios';

const api_url = 'http://localhost:8080/favorites'

export async function saveCampground(campground) {
    return await axios.post(`${api_url}/add, campground`);
}