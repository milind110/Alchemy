import React from "react";
import Blog from './Blog.jsx'
import store from './store.js'

class BlogList extends React.Component {
    constructor(props) {
        super(props);
        store.subscribe( ()=> this.forceUpdate());
        store.dispatch({
            type:'fetched_blogs'
        });
    }
    render(){
        return(
            <table>
                <tbody>
                    <tr>
                    <p>
                    {
                        store.getState().blogReducer.blogs.map(b => (
                        <Blog title={b.title} contents={b.post}>
                        </Blog>
                        ))
                    }
                    </p>
                    </tr>
                </tbody>
            </table>
        );
    }
}
export default BlogList;
