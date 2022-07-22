import React, {FC} from 'react';
import {Link} from "react-router-dom";

export interface SidebarLinkProps{
    to: string,
    title: string,
    icon: any
}

const SidebarLink:FC<SidebarLinkProps> = ({to, title, icon}) => {
    return (
        <div className={"flex items-center"}>
            {icon}
            <Link to={to} className={"text-gray-400 text-base font-medium my-2 cursor-pointer relative decoration-0 hover:text-blue-600 ease-linear duration-200"}>{title}</Link>
        </div>

    );
};

export default SidebarLink;