import React from "react";

function PostDetails(props) {
  return (
    <div>
      {props.postDetails.length > 0 && (
        <>
          <h1>{props.postDetails[0].title}</h1>
          <h3>{props.postDetails[0].author}</h3>
          <p>
            This is the content in the post: by {props.postDetails[0].author}
          </p>

          <div>
            <button>Edit</button>
            <button>Delete</button>
          </div>
        </>
      )}
    </div>
  );
}

export default React.memo(PostDetails);
