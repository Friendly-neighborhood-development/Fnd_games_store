import React, {FC} from 'react';
import Search from "./UI/Search";
import images from "../constants/images";
import {ShoppingCartIcon, BellIcon, PuzzleIcon} from "@heroicons/react/outline";
import {Link} from "react-router-dom";
import Login from "../pages/Login";

const Navbar: FC = () => {
    return (
        <header className={"w-full mb-8 px-2 flex justify-between items-center"}>
            <Link to={"/games"}>
                <div className={"mr-4 text-3xl text-blue-600 flex items-center"}>
                    <PuzzleIcon className={"w-8 h-8 text-blue-600"}/>
                    <span className={"ml-2"}>Games Store</span>
                </div>
            </Link>
            <div className={"flex"}>
                <Search className={"mr-4"} placeholder={"Поиск игры или разработчика.."}/>
                <span
                    className={"mr-4 rounded-full bg-white border-solid border-gray-300 border h-10 w-10 flex justify-center items-center"}>
                    <BellIcon className={"text-gray-500 w-3/5 h-3/5"}/>
                </span>
                <span
                    className={"mr-4 rounded-full bg-white border-solid border-gray-300 border h-10 w-10 flex justify-center items-center"}>
                    <ShoppingCartIcon className={"text-gray-500 w-3/5 h-3/5"}/>
                </span>
                <span className={"rounded-full inline-block overflow-hidden h-10 w-10 bg-white"}>
                    <img src={images.andrew} className={"w-full h-full object-cover"}/>
                </span>
            </div>
        </header>
    );
};

export default Navbar;