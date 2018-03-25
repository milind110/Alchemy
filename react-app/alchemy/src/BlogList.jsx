import React from "react";
import ReactDOM from 'react-dom';
import Blog from './Blog.jsx'

class BlogList extends React.Component {
    render(){
        return(
            <table>
                <tbody>
                    <tr>
                        <Blog />
                    </tr>
                </tbody>
            </table>
        );
    }
}
export default BlogList;
