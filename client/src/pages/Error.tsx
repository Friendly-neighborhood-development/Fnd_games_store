import React from 'react';
import {Link} from "react-router-dom";

const Error = () => {
    return (
        <div className={"container"}>
            <span>Something went wrong, please </span>
            <Link to={"/login"} className="navbar__link">
                <span>go back to safety</span>
            </Link>

        </div>
    );
};

export default Error;