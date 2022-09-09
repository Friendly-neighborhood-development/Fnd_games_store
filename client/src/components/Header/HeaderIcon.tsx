import React, {FC} from 'react';
import {Link} from "react-router-dom";

interface NavbarIconProps {
    Icon: any,
    link: string,
}

const HeaderIcon: FC<NavbarIconProps> = ({Icon, link}) => {
    return (
        <Link to={link} className={""}>
            <span
                className={"rounded-full bg-white border-solid border-gray-300 border h-10 w-10 flex justify-center items-center hover:bg-gray-200/30 dark:border-slate-600 dark:hover:bg-slate-500/50 dark:bg-slate-800"}
            >
                <Icon className={"text-slate-500 w-3/5 h-3/5 dark:text-slate-400"}/>
            </span>
        </Link>
    );
};

export default HeaderIcon;