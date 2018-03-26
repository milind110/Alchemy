import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import BlogNavbar from './BlogNavbar.jsx';
import {BrowserRouter as Router, Route, Link} from 'react-router-dom';
import BlogList from './BlogList.jsx';
import Login from './Login.jsx';

class App extends Component {
  render() {
      return (
          <Router>
          <div className="App">
          <header className="App-header">
              <img src={logo} className="App-logo" alt="logo" />
              <h1 className="App-title">Alchemy</h1>
          </header>
          <BlogNavbar />
          <Route path='/login' component={Login}></Route>
          <Route path='/' component={BlogList}></Route>
          </div>
          </Router>
    );
  }
}

export default App;
