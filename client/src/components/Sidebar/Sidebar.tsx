import React, {FC} from 'react';
import cl from "./Sidebar.module.css"
import sidebarLinks from "../../constants/sidebarLinks";
import SidebarLink from "../UI/SidebarLink/SidebarLink";
import images from "../../constants/images";
import SidebarLinksBlock from "../SidebarLinksBlock/SidebarLinksBlock";

const Sidebar: FC = () => {
    return (
        <div className={cl.sidebar}>
            <div className={cl.sidebar_logo}>
                <img src={images.logo} alt={"logo"}/>
            </div>
            <SidebarLinksBlock links={sidebarLinks}/>
            <SidebarLinksBlock title={"Профиль"} links={sidebarLinks}/>



        </div>
    );
};

export default Sidebar;