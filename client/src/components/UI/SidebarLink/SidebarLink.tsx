import React, {FC} from 'react';
import {Link} from "react-router-dom";
import cl from "./SidebarLink.module.css"

interface SidebarLinkProps{
    to: string,
    title: string
}

const SidebarLink:FC<SidebarLinkProps> = ({to, title}) => {
    return (
        <Link to={to} className={cl.link}>{title}</Link>
    );
};

export default SidebarLink;