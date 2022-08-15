import React, {FC, memo} from 'react';
import Search from "./UI/Search";
import images from "../constants/images";
import {ShoppingCartIcon, BellIcon, PuzzleIcon, SearchIcon} from "@heroicons/react/outline";
import {Link} from "react-router-dom";
import NavbarIcon from "./UI/NavbarIcon";

const Navbar: FC = memo(() => {
    return (
        <header className={"w-full flex justify-between items-center"}>
            <Link to={"/games"}>
                <div className={"mr-4  text-blue-600 dark:text-sky-500 flex items-center"}>
                    <PuzzleIcon className={"w-8 h-8"}/>
                    <span className={"ml-2 dark:text-white md:text-3xl text-xl"}>Games Store</span>
                </div>
            </Link>
            <nav className={"flex items-center"}>
                <Search className={"mr-4 hidden sm:flex"} placeholder={"Искать в магазине.."}/>
                <SearchIcon className={"sm:hidden w-6 h-6 text-gray-500"}/>
                <NavbarIcon Icon={BellIcon} link={"/notifications"}/>
                <NavbarIcon Icon={ShoppingCartIcon} link={"/cart"}/>
                <Link to={"/login"}>
                    <span className={"rounded-full inline-block overflow-hidden h-10 w-10 bg-white" +
                        " dark:bg-slate-700/50 flex items-center"}>
                        <img src={images.andrew} className={"w-full h-full object-cover"}/>
                    </span>
                </Link>
            </nav>
        </header>
    );
})

export default Navbar;