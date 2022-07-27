import React from 'react';
import {Link} from "react-router-dom";
import MainLayout from "../components/layouts/MainLayout";

const Error = () => {
    return (
        <MainLayout>
            <span>Something went wrong, please </span>
            <Link to={"/login"}>
                <span className={"text-blue-600"}>go back to safety</span>
            </Link>
        </MainLayout>

    );
};

export default Error;