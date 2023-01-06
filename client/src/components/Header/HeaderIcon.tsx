import React, {FC} from 'react';
import {Link} from "react-router-dom";

interface NavbarIconProps {
    children: React.ReactNode,
    link?: string,
    onClick?: (arg0:any) => void
}

const HeaderIcon: FC<NavbarIconProps> = ({children, link, ...props}) => {
    return (
        <>
            {link ?
                <Link to={link} {...props}>
                    <span
                        className={"rounded-full bg-white border-solid border-gray-300 border h-10 w-10 flex justify-center items-center hover:bg-gray-200/30 dark:border-slate-600 dark:hover:bg-slate-500/50 dark:bg-slate-800"}
                    >
                        {children}
                    </span>
                </Link> :
                <span
                    className={"cursor-pointer rounded-full bg-white border-solid border-gray-300 border h-10 w-10 flex justify-center items-center hover:bg-gray-200/30 dark:border-slate-600 dark:hover:bg-slate-500/50 dark:bg-slate-800"}
                >
                        {children}
                    </span>
            }

        </>

    );
};

export default HeaderIcon;