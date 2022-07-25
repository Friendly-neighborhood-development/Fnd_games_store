import React from 'react';
import {Routes, Route, Navigate} from "react-router-dom";
import {routes} from "../constants/routes";
import MainLayout from "./layouts/MainLayout";

const AppRouter = () => {
    return (
        <Routes>
            {routes.map((route) => (
                <Route
                    path={route.path}
                    element={
                        <React.Suspense fallback={<MainLayout/>}>
                            {route.element}
                        </React.Suspense>
                    }
                    key={route.path}/>
            ))}
        </Routes>
    );
};

export default AppRouter;