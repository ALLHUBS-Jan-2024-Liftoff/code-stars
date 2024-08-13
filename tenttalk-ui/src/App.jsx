import './App.css'
import { HashRouter, Routes, Route } from 'react-router-dom'
import { Index } from './pages/index'
import { Review } from './pages/review'
import { Campground } from './pages/campground'
import { Search } from './pages/search'
import { Login } from './pages/login'
import { Register } from './pages/register'
import { Account } from './pages/account'
import { CreateCampground } from './pages/createcampground'



function App() {
  return (
    <HashRouter>
      <Routes>
        <Route path="/" element={<Index/>} />
        <Route path="/review" element={<Review/>} />
        <Route path="/campground" element={<Campground/>} />
        <Route path="/search" element={<Search/>} />
        <Route path="/login" element={<Login/>} />
        <Route path="/register" element={<Register/>} />
        <Route path="/account" element={<Account/>} />
        <Route path="/create-campground" element={<CreateCampground/>} />
        <Route path="/campground/:id" element={<Campground />} /> 
        
      </Routes>
    </HashRouter>
  )
}

export default App
