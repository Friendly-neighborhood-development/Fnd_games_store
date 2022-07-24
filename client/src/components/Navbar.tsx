import React, {FC} from 'react';
import Search from "./UI/Search";
import images from "../constants/images";
import {ShoppingCartIcon, BellIcon} from "@heroicons/react/outline";

const Navbar: FC = () => {
    return (
        <header className={"w-full mb-6 px-2 flex justify-between items-center"}>
            <Search placeholder={"Поиск игры или разработчика.."}/>
            <div className={"flex"}>
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