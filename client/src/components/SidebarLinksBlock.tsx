import React, {FC} from 'react';
import sidebarLinks from "../constants/sidebarLinks";
import SidebarLink, {SidebarLinkProps} from "./UI/SidebarLink";

interface SidebarLinksBlockProps {
    title?: string,
    links: Array<SidebarLinkProps>
}

const SidebarLinksBlock: FC<SidebarLinksBlockProps> = ({title, links}) => {
    return (
        <div className={"flex flex-col justify-between m-4"}>
            {title
                ? <span className={"flex mb-2 text-gray-800 uppercase text-sm"}>{title}</span>
                : <></>}
            <div className={"flex flex-col"}>
                {sidebarLinks.map(link =>
                    <SidebarLink to={link.to} title={link.title} key={link.to}/>)
                }
            </div>
        </div>

    );
};

export default SidebarLinksBlock;