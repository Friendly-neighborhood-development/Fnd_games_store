import React, {FC} from 'react';
import './App.css';
import {BrowserRouter as Router} from "react-router-dom";
import AppRouter from "./components/AppRouter";

const App:FC = ()=> {
  return (
      <div className="bg-gray-50 flex">
          <Router>
              <AppRouter />
          </Router>
      </div>

  );
}

export default App;
