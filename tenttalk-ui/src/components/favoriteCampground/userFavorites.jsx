import { useState } from "react";

const UserFavorites = () => {
  const [blogs, setBlogs] = useState([
    { title: 'CAMP1', author: 'mario', id: 1 },
    { title: 'CAMP2', author: 'yoshi', id: 2 },
    { title: 'CAMP3', author: 'mario', id: 3 }
  ])

  return (
    <div className="UserFavorites">
      {blogs.map(blog => (
        <div key={blog.id} >
          <h2>{ blog.title }</h2>
          <p>Written by { blog.author }</p>
        </div>
      ))}
    </div>
  );
}
 
export default UserFavorites;