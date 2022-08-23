import React, {FC, memo} from 'react';
import Search from "../UI/Search";
import images from "../../constants/images";
import {ShoppingCartIcon, BellIcon, PuzzlePieceIcon, MagnifyingGlassIcon} from "@heroicons/react/24/outline";
import {Link} from "react-router-dom";
import HeaderIcon from "./HeaderIcon";
import ThemeSwitcher from "../UI/ThemeSwitcher";
import SmallScreenHeader from "./SmallScreenHeader";

const Header: FC = memo(() => {
    return (
        <header
            className={"w-full border-b border-slate-500/30 hidden sticky lg:block top-0 z-10 bg-white dark:backdrop-blur dark:bg-slate-900/80 shadow-lg dark:shadow-none shadow-gray-500/10"}>
            <div className="container mx-auto">
                <div className={"w-full justify-between items-center py-4 flex"}>
                    <Link to={"/games"}>
                        <div className={"mr-4 text-blue-600 dark:text-sky-500 flex items-center"}>
                            <PuzzlePieceIcon className={"w-8 h-8"}/>
                            <span className={"ml-2 dark:text-white md:text-3xl text-xl"}>Games Store</span>
                        </div>
                    </Link>
                    <nav className={"flex items-center space-x-4"}>
                        <Search className={"hidden sm:flex bg-white border border-slate-500/30"}
                                placeholder={"Искать в магазине.."}/>
                        <MagnifyingGlassIcon className={"sm:hidden w-6 h-6 text-gray-500"}/>
                        <ThemeSwitcher/>
                        <HeaderIcon Icon={BellIcon} link={"/notifications"}/>
                        <HeaderIcon Icon={ShoppingCartIcon} link={"/cart"}/>
                        <Link to={"/login"}>
                            <span className={"rounded-full inline-block overflow-hidden h-10 w-10 bg-white" +
                                " dark:bg-slate-700/50 flex items-center"}>
                                <img src={images.andrew} className={"w-full h-full object-cover"}/>
                            </span>
                        </Link>
                    </nav>
                </div>
            </div>
        </header>
    );
})

export default Header;