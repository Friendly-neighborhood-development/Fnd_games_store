import React from 'react';
import {Routes, Route} from "react-router-dom";
import {routes} from "../constants/routes";
import NotLoginLayout from "./layouts/NotLoginLayout";

const AppRouter = () => {
    return (
        <Routes>
            {routes.map((route) => (
                <Route
                    path={route.path}
                    element={
                        <React.Suspense fallback={<NotLoginLayout/>}>
                            {route.element}
                        </React.Suspense>
                    }
                    key={route.path}/>
            ))}
        </Routes>
    );
};

export default AppRouter;