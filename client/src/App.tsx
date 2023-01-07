import React, {FC, useEffect} from 'react';
import {BrowserRouter as Router} from "react-router-dom";
import {AppRouter} from "./components/AppRouter";
import {useAppDispatch} from "./hooks/redux";
import {checkAuth} from "./store/reducers/authSlice";

const App: FC = () => {
    const dispatch = useAppDispatch()
    useEffect(() => {
        dispatch(checkAuth())
    })
    return (
        <Router>
            <AppRouter/>
        </Router>
    );
}

export default App;
