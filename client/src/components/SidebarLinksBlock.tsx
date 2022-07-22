import React, {FC} from 'react';
import SidebarLink, {SidebarLinkProps} from "./UI/SidebarLink";
import {icons} from "react-icons";

interface SidebarLinksBlockProps {
    title?: string,
    links: Array<SidebarLinkProps>
}

const SidebarLinksBlock: FC<SidebarLinksBlockProps> = ({title, links}) => {
    return (
        <div className={"flex flex-col justify-between m-4"}>
            {title
                ? <span className={"flex mb-2 text-gray-800 uppercase text-xs"}>{title}</span>
                : <></>}
            <div className={"flex flex-col"}>
                {links.map(link =>
                    <SidebarLink to={link.to} title={link.title} key={link.to} icon={link.icon}/>)
                }
            </div>
        </div>

    );
};

export default SidebarLinksBlock;