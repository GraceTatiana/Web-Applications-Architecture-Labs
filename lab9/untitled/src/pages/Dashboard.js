import axios from 'axios';
import { useEffect, useState } from 'react';
import PostDetails from '../components/PostDetails';
import Posts from './Posts';
import "./dashboard.css"
import AddPost from '../components/addPost/AddPost';

const Dashboard = () => {

  const [title, setTitle] = useState("")

  const [postData, setpostData] = useState([
    { id: 111, title: "Happiness", author: "John" },
    { id: 112, title: "MIU", author: "Dean" },
    { id: 113, title: "Enjoy Life", author: "Jasmine" }
  ])

  const [postDetails, setPostDetails] = useState({})
  const [postId, setPostId] = useState(0);
  const [trackDelete, setTrackDelete] = useState(false);

  // useEffect(() => {
  //   async function fetchData() {
  //     let data = await fetch("http://localhost:8089/api/v1/posts")
  //     console.log(data);
  //   }
  //   fetchData();
  // }, [])

  const fetchPostIdWhenClicked = (id) => {

    let details = postData.filter((post) => post.id == id)
    setPostId(id);
    setPostDetails(details);
  }
  useEffect(() => {
    function fetchData() {
      axios
        .get("http://localhost:8089/api/v1/posts")
        .then((response) => setpostData(response.data))
        .catch(new Error())
    }
    fetchData();
  }, [trackDelete])

  function deletePostByID() {

    axios.delete(`http://localhost:8089/api/v1/${postId}`)
      .then(() => {
        setTrackDelete(!trackDelete)
        setPostDetails([])
      })

  }

  function addPost(post) {
    axios.post(`http://localhost:8089/api/v1/posts`, post)
  }

  const onChange = (event) => {
    event.preventDefault();
    const copy = [...postData];

    copy[0].title = title == "" ? "Happiness" : title;

    setpostData(copy);

    setTitle("");
  }

  return (
    <div className="dashboard">

      {/* <Posts data={postData} fetchPostIdWhenClicked={fetchPostIdWhenClicked} /> */}

      <form onSubmit={onChange}>
        <input
          type='text'
          value={title}
          onChange={(event) => setTitle(event.target.value)}

        />
        <button type='submit'>Change title </button>
      </form>
      <div>
        {/* <PostDetails postDetails={postDetails} deletePostByID={deletePostByID} /> */}
      </div>

      <div>
        {/* <AddPost addPost={addPost} /> */}
      </div>
    </div>
  );
}

export default Dashboard;