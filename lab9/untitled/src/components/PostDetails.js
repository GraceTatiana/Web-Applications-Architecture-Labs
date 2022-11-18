import React from 'react'

const PostDetails = (props) => {
    console.log(props)
    return (
        <div>
            {
                props.postDetails.length > 0 && (
                    <>
                        <h1>{props.postDetails[0].title}</h1>
                        <h2>{props.postDetails[0].author}</h2>
                        <h3>This is the content in the post…{props.postDetails[0].content}</h3>

                        <button onClick={() => { props.deletePostByID() }}>Delete</button>
                    </>
                )
            }
        </div>
    )
}

export default PostDetails