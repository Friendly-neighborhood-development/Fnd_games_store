import React, {FC} from 'react';
import './App.css';
import Sidebar from "./components/Sidebar/Sidebar";
import Navbar from "./components/Navbar/Navbar";
import GamesList from "./components/GamesList/GamesList";

const App:FC = ()=> {
  return (
      <div className="app">
          <div className="container">
              <Sidebar/>
              <div className="main-wrapper">
                  <Navbar/>
                  <GamesList/>
              </div>
          </div>
      </div>

  );
}

export default App;
