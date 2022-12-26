import React, {FC, memo} from 'react';
import images from "../../constants/images";
import {BellIcon, PuzzlePieceIcon, ShoppingCartIcon} from "@heroicons/react/24/outline";
import {Link} from "react-router-dom";
import HeaderIcon from "./HeaderIcon";
import ThemeSwitcher from "../ThemeSwitcher";
import Search from "../UI/Search";

const Header: FC = memo(() => {
    return (
        <header
            className={"w-full border-b border-slate-500/30 hidden sticky lg:block top-0 z-10 bg-white shadow-lg shadow-gray-500/10 dark:backdrop-blur dark:bg-slate-900/80 dark:shadow-none"}>
            <div className="container mx-auto">
                <div className={"w-full justify-between items-center py-4 flex"}>
                    <Link to={"/games"} className={"mr-4 flex items-center"}>
                        <PuzzlePieceIcon className={"w-10 h-10 text-blue-600 dark:text-sky-500"}/>
                        <span className={"ml-2 dark:text-white md:text-3xl text-xl"}>Games Store</span>
                    </Link>
                    <nav className={"flex items-center space-x-4 relative"}>
                        <Search placeholder={"Искать в магазине"}/>
                        <ThemeSwitcher/>
                        <HeaderIcon link={"/cart"}>
                            <ShoppingCartIcon className={"text-slate-500 w-3/5 h-3/5 dark:text-slate-300"}/>
                        </HeaderIcon>
                        <HeaderIcon link={"/notifications"}>
                            <BellIcon className={"text-slate-500 w-3/5 h-3/5 dark:text-slate-300"}/>
                        </HeaderIcon>
                        <Link to={"/login"}>
                            <span
                                className={"rounded-full inline-block overflow-hidden h-10 w-10 bg-white flex items-center dark:bg-slate-700/50"}
                            >
                                <img src={images.andrew} className={"w-full h-full object-cover"} alt={"profile pic"}/>
                            </span>
                        </Link>
                    </nav>
                </div>
            </div>
        </header>
    );
})

export default Header;