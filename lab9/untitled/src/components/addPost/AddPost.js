import e from 'express';
import React from 'react'
import { useState } from 'react';

const AddPost = (props) => {

    const [formData, setFormData] = useState({
        author: "",
        title: "",
        content: ""

    })

    function handleSubmit(event) {
        event.preventDefault();
        props.addPost(formData);
    }

    return (
        <div className='Content'>
            <h2>---Create Post---</h2>
            <form onSubmit={handleSubmit}>
                <label>Author</label>
                <input
                    type='text'
                    name='Author'
                    value={formData.author}
                    onChange={(event) => {
                        formData.author = event.target.value;
                        setFormData({ ...formData })
                    }}
                ></input>

                <label>Title</label>
                <input
                    type='text'
                    name='Title'
                    value={formData.title}
                    onChange={(event) => {
                        formData.title = event.target.value;
                        setFormData({ ...formData })
                    }}
                ></input>

                <label>Content</label>
                <input
                    type='text'
                    name='Content'
                    value={formData.content}
                    onChange={(event) => {
                        formData.content = event.target.value;
                        setFormData({ ...formData })
                    }}

                ></input>
                <div>
                    <button type='submit'>Submit Post</button>
                </div>

            </form>
        </div>
    )
}

export default AddPost