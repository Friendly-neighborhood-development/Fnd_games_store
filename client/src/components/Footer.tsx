import React from 'react';
import images from "../constants/images";
import {PuzzlePieceIcon} from "@heroicons/react/20/solid";

const Footer = () => {
    return (
        <footer className={"bg-white dark:bg-slate-800 mt-4 w-full py-4"}>
            <div className={"container mx-auto flex items-center justify-between"}>
                <div className={"flex items-center space-x-2"}>
                    <PuzzlePieceIcon className={"text-blue-600 dark:text-sky-500 w-8 h-8"}/>
                    <span>&#169; 2022 Friendly-neighborhood-development</span>
                </div>
                <div className={"flex items-center space-x-2"}>
                    <span>Follow us on github</span>
                    <img src={images.githubLogo} alt={"github logo"} className={"w-8 h-8 "}/>
                </div>
            </div>
        </footer>
    );
};

export default Footer;