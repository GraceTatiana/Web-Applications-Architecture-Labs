import React, { useState } from "react";
import PostDetails from "../components/PostDetails/PostDetails";
import Posts from "../components/Posts/Posts";

const postDataDummy = [
  { id: 111, title: "Happiness", author: "John" },
  { id: 112, title: "MIU", author: "Dean" },
  { id: 113, title: "Enjoy Life", author: "Jasmine" },
];

function Dashboard() {
  const [title, setTitle] = useState("");

  const [postData, setPostData] = useState(postDataDummy);

  const [postDetails, setPostDetails] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();

    const copy = [...postData];

    copy[0].title = title === "" ? "Happiness" : title;

    setPostData(copy);
    setTitle("");
  };

  const fetchPostIdWhenClicked = (id) => {
    // console.log(id);

    let details = postData.filter((post) => post.id === id);

    setPostDetails(details);
  };

  return (
    <div>
      <Posts data={postData} fetchPostIdWhenClicked={fetchPostIdWhenClicked} />

      <form onSubmit={handleSubmit}>
        <input
          type="text"
          value={title}
          onChange={(event) => setTitle(event.target.value)}
        />
        <button>Change Name</button>
      </form>

      <div>
        <PostDetails postDetails={postDetails} />
      </div>
    </div>
  );
}

export default Dashboard;
