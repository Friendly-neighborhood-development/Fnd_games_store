import React from 'react';
import {Link} from "react-router-dom";

const Error = () => {
    return (
        <div className={"container"}>
            <div className={"page"}>
                <span>Something went wrong, please </span>
                <Link to={"/login"}>
                    <span>go back to safety</span>
                </Link>
            </div>


        </div>
    );
};

export default Error;