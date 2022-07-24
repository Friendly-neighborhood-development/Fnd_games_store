import React, {FC} from "react";
import Games from "../pages/Games";
import Login from "../pages/Login";
import {Navigate} from "react-router-dom";
import Error from "../pages/Error";

interface routeProps {
    path: string,
    element: React.ReactElement,
    exact?: boolean
}

export const routes: Array<routeProps> = [
    {path: "/games", element: <Games/>},
    {path: "/login", element: <Login/>},
    {path: "/error", element: <Error/>},
    {path: "*", element: <Navigate to="/error"/>},
]