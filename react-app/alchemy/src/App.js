import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import BlogNavbar from './BlogNavbar.jsx';
import {BrowserRouter as Router, Route, Link} from 'react-router-dom';

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
          </div>
          </Router>
    );
  }
}

export default App;
