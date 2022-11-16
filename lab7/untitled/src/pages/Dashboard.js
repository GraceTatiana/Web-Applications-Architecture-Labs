import { useState } from 'react';
import PostDetails from '../components/PostDetails';
import Posts from './Posts';

const Dashboard = () => {

  const [title, setTitle] =useState("")

  const [postData, setpostData] = useState([
    {id: 111, title: "Happiness", author: "John"},
    {id: 112, title: "MIU", author: "Dean"},
    {id: 113, title: "Enjoy Life", author: "Jasmine"}
  ])

  const [postDetails, setPostDetails] = useState({})

  
   const onChange = (event) => {
        event.preventDefault();
        const copy = [ ...postData ];

        copy[0].title = title == "" ? "Happiness" : title;
        console.log(copy)

        setpostData(copy);
        console.log(postData)
        setTitle("");
    }

    const fetchPostIdWhenClicked = (id) =>{
      console.log(id)
        let details = postData.filter((post) => post.id == id)
        console.log(details)

        setPostDetails(details);
    }
    
  return (
    <div>
      
        <Posts data = {postData} fetchPostIdWhenClicked = {fetchPostIdWhenClicked}/>   

        <form onSubmit={onChange}>
          <input 
          type = 'text' 
          value = {title}
          onChange={(event) => setTitle(event.target.value)}
          
          />
          <button type='submit'>Change title </button>
        </form>
        <div>
            <PostDetails postDetails ={postDetails}/>
        </div>
        
    </div>
  );
}

export default Dashboard;