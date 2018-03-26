function blogReducer(state={blogs:[]}, action) {
    switch (action.type) {
        case 'fetched_blogs':
            return action.blogs;
        default:
        return {
            blogs: []
        };
    }
};

export default blogReducer;