import { createStore, applyMiddleware} from 'redux';
import rootReducer from './reducer.js'
import proxy from './proxy.js'

const store = createStore(rootReducer, applyMiddleware(proxy));

export default store;