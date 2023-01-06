import React from 'react';
import {Link} from "react-router-dom";
import SimpleLayout from "../components/layouts/SimpleLayout";

const Error = () => {
    return (
        <SimpleLayout>
            <span>Something went wrong, please </span>
            <Link to={"/login"}>
                <span className={"text-blue-600"}>go back to safety</span>
            </Link>
        </SimpleLayout>

    );
};

export default Error;