export function blogReducer(state={book:[]}, action) {
    switch (action) {
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
}

export default blogReducer;