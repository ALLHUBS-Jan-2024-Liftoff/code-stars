import './App.css'
import { HashRouter, Routes, Route } from 'react-router-dom'
import { Index } from './pages/index'
import { ReviewForm } from './pages/reviewform'
import { Campground } from './pages/campground'
import { Search } from './pages/search'


function App() {
  
  return (
    <HashRouter>
      <Routes>
        <Route path="/" element={<Index/>} />
        <Route path="/review" element={<ReviewForm/>} />
        <Route path="/campground" element={<Campground/>} />
        <Route path="/search" element={<Search/>} />
      </Routes>
    </HashRouter>
  )
}

export default App
