import React from "react";
import {Navigate} from "react-router-dom";

// lazy loading for pages
const Games = React.lazy(() => import("../pages/Games"))
const GameName = React.lazy(() => import("../pages/GameName"))
const Login = React.lazy(() => import("../pages/Login"))
const Register = React.lazy(() => import("../pages/Register"))
const Cart = React.lazy(() => import("../pages/Cart"))
const Error = React.lazy(() => import("../pages/Error"))

interface routeProps {
    path: string,
    element: React.ReactElement,
    exact?: boolean
}

export const authorizedRoutes: Array<routeProps>= [
    {path: "/", element: <Games/>},
    {path: "/games/:name", element: <GameName/>},
    {path: "/cart", element: <Cart/>},
    {path: "/error", element: <Error/>},
    {path: "/login", element: <Navigate to="/"/>},
    {path: "*", element: <Navigate to="/error"/>},
]

export const notAuthorizedRoutes: Array<routeProps> = [
    {path: "/", element: <Games/>},
    {path: "/games/:name", element: <GameName/>},
    {path: "/login", element: <Login/>},
    {path: "/register", element: <Register/>},
    {path: "/error", element: <Error/>},
    {path: "*", element: <Navigate to="/error"/>},
]
