import React, {FC} from 'react';
import {Link} from "react-router-dom";
import {BellIcon} from "@heroicons/react/outline";

interface NavbarIconProps {
    Icon: any,
    link: string,
}

const NavbarIcon: FC<NavbarIconProps> = ({Icon, link}) => {
    return (
        <Link to={link} className={""}>
            <span
                className={"rounded-full bg-white border-solid border-gray-300 border" +
                    " h-10 w-10 flex justify-center items-center dark:bg-slate-700/50" +
                    " dark:border-slate-600 dark:hover:bg-slate-500/50"}
            >
                <Icon className={"text-gray-500 dark:text-slate-400 w-3/5 h-3/5"}/>
            </span>
        </Link>
    );
};

export default NavbarIcon;