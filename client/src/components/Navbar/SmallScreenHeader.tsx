import React, {FC} from 'react';
import {Link} from "react-router-dom";
import {BellIcon, PuzzleIcon, SearchIcon, ShoppingCartIcon} from "@heroicons/react/outline";
import Search from "../UI/Search";
import ThemeSwitcher from "../UI/ThemeSwitcher";
import NavbarIcon from "./NavbarIcon";
import images from "../../constants/images";
import Header from "./Header";


const SmallScreenHeader:FC = () => {
    return (
        <header
            className={"w-full border-b border-slate-500/30 sticky top-0 z-10 bg-white dark:backdrop-blur dark:bg-slate-900/80 shadow-lg dark:shadow-none shadow-gray-500/10"}>
            <div className="container mx-auto">
                <div className={"w-full justify-between items-center flex lg:hidden"}>

                </div>
            </div>
        </header>

    );
};

export default SmallScreenHeader;