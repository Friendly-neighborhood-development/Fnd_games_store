import React, {FC} from 'react';
import './App.css';
import {BrowserRouter as Router} from "react-router-dom";
import AppRouter from "./components/AppRouter";

const App:FC = ()=> {
  return (
      <React.StrictMode>
          <div className="bg-gray-100 flex">
              <Router>
                  <AppRouter />
              </Router>
          </div>
      </React.StrictMode>


  );
}

export default App;
