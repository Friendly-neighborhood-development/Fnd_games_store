import React from 'react';
import {images} from "../constants/images";

export const Footer = () => {
    return (
        <footer className={"mt-4 w-full py-4 lg:py-6 border-t border-slate-500/30 dark:bg-slate-900"}>
            <div className={"mx-auto flex lg:items-center justify-between flex-col lg:flex-row"}>
                <div className={"flex items-center space-x-2"}>
                    <span className={"text-gray-700 text-sm dark:text-gray-400"}>Copyright &#169; 2023 Friendly neighborhood development</span>
                </div>
                <div className={"flex items-center space-x-2 mt-3 lg:mt-0"}>
                    <span className={"text-gray-800 text-sm dark:text-gray-300"}>Follow us on Github</span>
                    <span className={"bg-white rounded-full h-8 w-8 flex justify-center items-center"}>
                        <a href={"https://github.com/Friendly-neighborhood-development"}>
                            <img src={images.githubLogo} alt={"github logo"} className={"w-7 h-7"}/>
                        </a>
                    </span>
                </div>
            </div>
        </footer>
    );
};

