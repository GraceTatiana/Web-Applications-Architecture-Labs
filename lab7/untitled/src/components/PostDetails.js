import React from 'react'

const PostDetails = (props) => {
    console.log(props)
    return (
        <div>
            <h2>MIU</h2>
            <h5>This is the content in the post… {props.postDetails == {} ? "" : props.postDetails[0].title}</h5>
        </div>
    )
}

export default PostDetails