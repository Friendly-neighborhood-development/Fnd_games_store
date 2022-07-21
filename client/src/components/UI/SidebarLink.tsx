import React, {FC} from 'react';
import {Link} from "react-router-dom";
import cl from "./SidebarLink/SidebarLink.module.css"

export interface SidebarLinkProps{
    to: string,
    title: string
}

const SidebarLink:FC<SidebarLinkProps> = ({to, title}) => {
    return (
        <Link to={to} className={"text-gray-400 text-base font-medium my-2 cursor-pointer relative decoration-0 hover:text-blue-600 ease-linear duration-200"}>{title}</Link>
    );
};

export default SidebarLink;