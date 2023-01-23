import React from 'react';
import {Link} from "react-router-dom";
import {SimpleLayout} from "../components/layouts/SimpleLayout";
import {Footer} from "../components/Footer";
import {PaperAirplaneIcon, ShieldCheckIcon} from "@heroicons/react/20/solid";
import {NoSymbolIcon} from "@heroicons/react/24/outline";

const Error = () => {
    return (
        <SimpleLayout>
            <div className={"w-screen flex-1 flex flex-col text-2xl mt-20 items-center"}>
                <NoSymbolIcon className={"w-56 h-56 mb-10"}/>
                <div>Something went wrong, please</div>
                <Link to={"/login"}>
                    <span
                        className={"text-blue-600 duration-100 dark:text-sky-500 hover:opacity-80 flex items-center"}
                    >
                        go back to safety
                        <ShieldCheckIcon className={"w-5 h-5 ml-2"}/>
                    </span>
                </Link>
            </div>
        </SimpleLayout>

    );
};

export default Error

