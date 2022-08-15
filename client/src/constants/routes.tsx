import React from "react";
import {Navigate} from "react-router-dom";
import Test from "../pages/Test";

// lazy loading for pages
const Games = React.lazy(() => import("../pages/Games"))
const GameName = React.lazy(() => import("../pages/GameName"))
const Login = React.lazy(() => import("../pages/Login"))
const Cart = React.lazy(() => import("../pages/Cart"))
const Notifications = React.lazy(() => import("../pages/Notifications"))
const Error = React.lazy(() => import("../pages/Error"))

interface routeProps {
    path: string,
    element: React.ReactElement,
    exact?: boolean
}

export const routes: Array<routeProps> = [
    {path: "/games", element: <Games/>},
    {path: "/games/:name", element: <GameName/>},
    {path: "/login", element: <Login/>},
    {path: "/cart", element: <Cart/>},
    {path: "/notifications", element: <Notifications/>},
    {path: "/error", element: <Error/>},
    {path: "/test", element: <Test/>},
    {path: "*", element: <Navigate to="/error"/>},
]