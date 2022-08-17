import React, {FC} from 'react';
import {BrowserRouter as Router} from "react-router-dom";
import AppRouter from "./components/AppRouter";

const App: FC = () => {
    return (
        <React.StrictMode>
            <Router>
                <AppRouter/>
            </Router>
        </React.StrictMode>


    );
}

export default App;
