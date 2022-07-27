import React, {FC, memo} from 'react';
import sidebarLinks from "../constants/sidebarLinks";
import images from "../constants/images";
import SidebarLinksBlock from "./SidebarLinksBlock";

const Sidebar: FC = memo(() => {
    return (
        <div className={"py-1 w-52 bg-white fixed h-screen flex flex-col"}>
            <div className={"w-full flex justify-center items-center my-6"}>
                <img className={"w-1/2"} src={images.logo} alt={"logo"}/>
            </div>
            <SidebarLinksBlock links={sidebarLinks}/>
            <SidebarLinksBlock title={"Профиль"} links={sidebarLinks}/>
        </div>
    );
});

export default Sidebar;