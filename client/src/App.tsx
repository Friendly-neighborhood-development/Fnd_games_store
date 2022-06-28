import React, {FC} from 'react';
import './App.css';
import Navbar from "./components/Navbar/Navbar";
import {BrowserRouter as Router} from "react-router-dom";
import AppRouter from "./components/AppRouter";

const App:FC = ()=> {
  return (
      <div className="app">
          <Router>
              <AppRouter />
          </Router>
      </div>

  );
}

export default App;
