import React from "react";

function Post(props) {
  return (
    <div
      style={{ margin: "1.5em" }}
      onClick={() => props.fetchPostIdWhenClicked(props.id)}
    >
      <p>Id : {props.id}</p>
      <p>Title: {props.title}</p>
      <p>Author: {props.author}</p>
    </div>
  );
}

export default Post;
