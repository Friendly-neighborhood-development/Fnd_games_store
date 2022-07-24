import React from 'react';
import {Routes, Route, Navigate} from "react-router-dom";
import {routes} from "../constants/routes";
import {RefreshIcon} from "@heroicons/react/outline";

const AppRouter = () => {
    return (
        <Routes>
            {routes.map((route) => (
                <Route
                    path={route.path}
                    element={
                        <React.Suspense fallback={<RefreshIcon/>}>
                            {route.element}
                        </React.Suspense>
                    }
                    key={route.path}/>
            ))}
        </Routes>
    );
};

export default AppRouter;