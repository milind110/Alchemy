function proxy(store) {
    return function (next) {
        return function(action) {
            if (action.type == 'fetched_blogs') {
                fetch('http://10.197.37.36:5000/api/blog')
                .then(function(response){
                    return response.json();
                })
                .then(function(data) {
                    // this gets very ugly, modify rest query to return blogs directly
                    let fetched_blogs = {
                        blogs: data.data
                    }
                    action.blogs = fetched_blogs;
                    return next(action);
                })
            }
        }
    }
}

export default proxy;