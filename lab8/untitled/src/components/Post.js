import React from 'react'
import './Post.css'

export const Post = (props) => {
  return (
    <div className='details'
      onClick={() => props.fetchPostIdWhenClicked(props.id)}>
      <p>Id : {props.id}</p>
      <p>Title : {props.title}</p>
      {/* <p>Content : {props.content}</p> */}
      <p>Author : {props.author}</p>
    </div>
  );
}
