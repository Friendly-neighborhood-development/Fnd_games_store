import React, {FC} from 'react';
import cl from "./SidebarLinksBlock.module.css"
import sidebarLinks from "../../constants/sidebarLinks";
import SidebarLink, {SidebarLinkProps} from "../UI/SidebarLink/SidebarLink";

interface SidebarLinksBlockProps {
    title?: string,
    links: Array<SidebarLinkProps>
}

const SidebarLinksBlock: FC<SidebarLinksBlockProps> = ({title, links}) => {
    return (
        <div className={cl.block}>
            {title
                ? <span className={cl.title}>{title}</span>
                : <></>}
            <div className={cl.links}>
                {sidebarLinks.map(link =>
                    <SidebarLink to={link.to} title={link.title} key={link.to}/>)
                }
            </div>
        </div>

    );
};

export default SidebarLinksBlock;