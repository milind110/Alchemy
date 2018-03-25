import React from "react";
import ReactDOM from 'react-dom';
import Blog from './Blog.jsx'
import {createStore} from 'redux';
import store from './store.js'

class BlogList extends React.Component {
    render(){
        return(
            <table>
                <tbody>
                    <p>
                    {
                        store.getState().blogReducer.blogs.map(b => (
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
