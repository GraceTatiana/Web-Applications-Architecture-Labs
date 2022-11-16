import { Post } from "../components/Post";


function Posts({data, fetchPostIdWhenClicked}) {
  console.log(data)

    return( <div>
      {
        data.map(post => {
          return <Post 
              fetchPostIdWhenClicked = {fetchPostIdWhenClicked}
              id = {post.id}
              title = {post.title}
              author = {post.author}
              key = {post.id}
           />
        })
      }
     </div>
    )

  }


export default Posts;