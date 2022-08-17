import React, {FC} from 'react';
import {Link} from "react-router-dom";
import {BellIcon, PuzzleIcon, SearchIcon, ShoppingCartIcon} from "@heroicons/react/outline";
import Search from "../UI/Search";
import ThemeSwitcher from "../UI/ThemeSwitcher";
import NavbarIcon from "./NavbarIcon";
import images from "../../constants/images";

interface SmallScreenNavbarProps{
    className?: string
}

const SmallScreenNavbar:FC<SmallScreenNavbarProps> = ({className}) => {
    const rootClasses = "w-full justify-between items-center " + className

    return (
        <header className={rootClasses}>
            SmallScreenNavbar
        </header>
    );
};

export default SmallScreenNavbar;