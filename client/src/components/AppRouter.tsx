import React from 'react';
import {Routes, Route} from "react-router-dom";
import {authorizedRoutes, notAuthorizedRoutes} from "../constants/routes";
import SimpleLayout from "./layouts/SimpleLayout";
import {useAppSelector} from "../hooks/redux";

const AppRouter = () => {
    const {isAuth} = useAppSelector(state => state.auth)
    let routes
    if (isAuth) routes = authorizedRoutes
    else routes = notAuthorizedRoutes
    return (
        <Routes>
            {routes.map((route) => (
                <Route
                    path={route.path}
                    element={
                        <React.Suspense fallback={<SimpleLayout/>}>
                            {route.element}
                        </React.Suspense>
                    }
                    key={route.path}/>
            ))}
        </Routes>
    );
};

export default AppRouter;