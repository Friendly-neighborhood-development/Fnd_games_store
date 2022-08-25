import React, {FC} from 'react';
import {Link} from "react-router-dom";

interface IconProps {
    className: string
}

interface SmHeaderLinkProps {
    href: string,
    title: string,
    Icon: React.FC<IconProps>
}

const SmHeaderLink: FC<SmHeaderLinkProps> = ({href, title, Icon}) => {
    return (
        <Link to={href} className={"flex"}>
            <Icon className={"w-6 h-6"}/>
            <span className={"ml-2"}>{title}</span>
        </Link>
    );
};

export default SmHeaderLink;