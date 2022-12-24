import React from 'react';
import images from "../constants/images";
import {PuzzlePieceIcon} from "@heroicons/react/20/solid";

const Footer = () => {
    return (
        <footer className={"bg-white dark:bg-slate-900 mt-4 w-full py-4 lg:py-6 border-t border-slate-500/30"}>
            <div className={"mx-auto flex items-center justify-between flex-col lg:flex-row-reverse"}>
                <div className={"flex items-center space-x-2"}>
                    <span className={"text-sm"}>Follow us on Github</span>
                    <span className={"bg-white rounded-full h-8 w-8 flex justify-center items-center"}>
                        <a href={"https://github.com/Friendly-neighborhood-development"}>
                            <img src={images.githubLogo} alt={"github logo"} className={"w-7 h-7"}/>
                    </a>
                    </span>
                </div>
                <div className={"flex items-center space-x-2"}>
                    <span className={"text-gray-600 dark:text-gray-400"}>Copyright &#169; 2022 FND</span>
                </div>
            </div>
        </footer>
    );
};

export default Footer;