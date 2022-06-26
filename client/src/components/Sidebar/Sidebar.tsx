import React, {FC} from 'react';
import cl from "./Sidebar.module.css"
import sidebarLinks from "../../constants/sidebarLinks";
import SidebarLink from "../UI/SidebarLink/SidebarLink";

const Sidebar: FC = () => {
    return (
        <div className={cl.sidebar}>
            {sidebarLinks.map(link =>
                <SidebarLink to={link.to} title={link.title}/>)}
        </div>
    );
};

export default Sidebar;