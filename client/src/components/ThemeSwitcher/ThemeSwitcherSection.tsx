import React, {FC} from 'react';
import {IIcon} from "../../types/IIcon";

interface ThemeSwitcherSectionProps{
    className?: string,
    Icon: React.FC<IIcon>
    title: string
}

const ThemeSwitcherSection:FC<ThemeSwitcherSectionProps> = ({className, Icon, title}) => {
    return (
        <div className={"flex capitalize"}>
            <Icon className={"w-6 h-6 mr-2"}/>
            {title}
        </div>
    );
};

export default ThemeSwitcherSection;