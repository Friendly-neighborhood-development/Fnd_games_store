import React from 'react';
import {Link} from "react-router-dom";
import MainLayout from "../components/layouts/MainLayout";
import NotLoginLayout from "../components/layouts/NotLoginLayout";

const Error = () => {
    return (
        <NotLoginLayout>
            <span>Something went wrong, please </span>
            <Link to={"/login"}>
                <span className={"text-blue-600"}>go back to safety</span>
            </Link>
        </NotLoginLayout>

    );
};

export default Error;