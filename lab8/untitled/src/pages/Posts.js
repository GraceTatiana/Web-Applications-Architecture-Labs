import { Post } from "../components/Post";
import './Posts.css'


function Posts({ data, fetchPostIdWhenClicked }) {
  console.log(data)

  return (<div className="posts">
    {
      data.map(post => {
        return <Post
          fetchPostIdWhenClicked={fetchPostIdWhenClicked}
          id={post.id}
          title={post.title}
          // content={post.content}
          author={post.author}
          key={post.id}
        />
      })
    }
  </div>
  )

}


export default Posts;