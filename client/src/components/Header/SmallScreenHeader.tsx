import React, {FC} from 'react';
import {MenuIcon, PuzzleIcon, SearchIcon} from "@heroicons/react/outline";
import Search from "../UI/Search";
import {Link} from "react-router-dom";


const SmallScreenHeader: FC = () => {
    return (
        <header
            className={"w-full border-b border-slate-500/30 sticky top-0 z-10 bg-white dark:backdrop-blur dark:bg-slate-900/80 shadow-lg dark:shadow-none shadow-gray-500/10"}>
            <div className="container mx-auto">
                <div className={"w-full justify-between items-center flex lg:hidden py-3"}>
                    <SearchIcon className={"w-6 h-6 dark:text-gray-100"}/>
                    <Link to={"/games"} className={"flex items-center"}>
                        <PuzzleIcon className={"w-6 h-6 text-blue-500"}/>
                        <span className={"dark:text-gray-100 text-xl ml-1"}>Games Store</span>
                    </Link>
                    <MenuIcon className={"w-6 h-6 dark:text-gray-100"}/>
                </div>
            </div>
        </header>

    );
};

export default SmallScreenHeader;