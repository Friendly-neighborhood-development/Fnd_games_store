import React from "react";
import {Navigate} from "react-router-dom";

// lazy loading for pages
const Games = React.lazy(() => import("../pages/Games"))
const Login = React.lazy(() => import("../pages/Login"))
const Error = React.lazy(() => import("../pages/Error"))

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