import React from "react";
import Post from "../Post/Post";
import "./posts.css";

function Posts({ data, fetchPostIdWhenClicked }) {
  // console.log(props);
  return (
    <div className="details">
      {data.map((post) => {
        return (
          <Post
            fetchPostIdWhenClicked={fetchPostIdWhenClicked}
            id={post.id}
            title={post.title}
            author={post.author}
            key={post.id}
          />
        );
      })}
    </div>
  );
}

export default Posts;
