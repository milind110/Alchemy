import React from "react";
import ReactDOM from 'react-dom';
import Blog from './Blog.jsx'

class BlogList extends React.Component {
    render(){
        return(
            <table>
                <tbody>
                    <tr>
                        <Blog title="Blog Title" contents="Blog Contents.....................">
                        </Blog>
                    </tr>
                </tbody>
            </table>
        );
    }
}
export default BlogList;
