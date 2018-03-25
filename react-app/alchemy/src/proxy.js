function proxy(store) {
    return function (next) {
        return function(action) {
            console.log('Why is this required ?');
        }
    }
}

export default proxy;