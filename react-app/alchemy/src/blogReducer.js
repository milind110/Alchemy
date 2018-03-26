function blogReducer(state={blogs:[]}, action) {
    switch (action.type) {
        case 'fetched_blogs':
            return action.blogs;
        break;
        default:
        return {
            blogs: []
        };
    }
};

export default blogReducer;