import React from 'react';
import {Routes, Route} from "react-router-dom";
import {routes} from "../constants/routes";

const AppRouter = () => {
    return (
        <Routes>
            {routes.map((route) => (
                <Route path={route.path} element={route.element} key={route.path} />
            ))}
        </Routes>
    );
};

export default AppRouter;