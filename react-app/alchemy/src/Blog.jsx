import React from "react";

class Blog extends React.Component {
    constructor(props) {
        super(props);
    }
    render(){
        return(
            <div>
                <h2>{this.props.title}</h2>
                <p>{this.props.contents}</p>
            </div>
        );
    }
}
export default Blog;
