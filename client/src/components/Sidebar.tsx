import React, {FC} from 'react';
import sidebarLinks from "../constants/sidebarLinks";
import images from "../constants/images";
import SidebarLinksBlock from "./SidebarLinksBlock";

const Sidebar: FC = () => {
    return (
        <div className={"py-1 w-52 bg-white fixed h-screen rounded-2xl flex flex-col"}>
            <div className={"w-full flex justify-center items-center mb-8"}>
                <img  className={"w-4/6"} src={images.logo} alt={"logo"}/>
            </div>
            <SidebarLinksBlock links={sidebarLinks}/>
            <SidebarLinksBlock title={"Профиль"} links={sidebarLinks}/>
        </div>
    );
};

export default Sidebar;