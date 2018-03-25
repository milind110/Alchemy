import React from "react";
import ReactDOM from 'react-dom';
import Blog from './Blog.jsx'
import {createStore} from 'redux';

const store = createStore(blogsReducer);

function blogsReducer(state={blogs:[]}, action) {
    switch(action.type) {
        default:
        return {
            blogs: [{
                "title": "Blog Title 001",
                "contents": "Blog contents.........................."
            },
            {
                "title": "Blog Title 002",
                "contents": "Blog contents.........................."
            },
            {
                "title": "Blog Title 003",
                "contents": "Blog contents.........................."
            }
        ]
        };
    }
};

class BlogList extends React.Component {
    render(){
        return(
            <table>
                <tbody>
                    <p>
                    {
                        store.getState().blogs.map(b => (
                        <Blog title={b.title} contents={b.contents}>
                        </Blog>
                        ))
                    }
                    </p>
                </tbody>
            </table>
        );
    }
}
export default BlogList;
