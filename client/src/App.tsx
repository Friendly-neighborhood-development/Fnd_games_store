import React, {FC} from 'react';
import {BrowserRouter as Router} from "react-router-dom";
import AppRouter from "./components/AppRouter";

const App:FC = ()=> {
  return (
      <React.StrictMode>
          <div className="text-slate-800 dark:text-slate-400 bg-gray-100 dark:bg-slate-900 flex">
              <Router>
                  <AppRouter />
              </Router>
          </div>
      </React.StrictMode>


  );
}

export default App;
