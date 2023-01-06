import React, {FC, useEffect} from 'react';
import {useSwitchTheme} from "../../hooks/useThemeSwitch";
import {themes} from "../../constants/themes";

interface SimpleLayoutProps {
    children?: React.ReactNode
}

const SimpleLayout: FC<SimpleLayoutProps> = ({children}) => {
    const {selectedTheme, setSelectedTheme} = useSwitchTheme()
    useEffect(() => {
        setSelectedTheme(themes.find(theme => theme.title === localStorage.theme) || themes[2])
    }, [])
    return (
        <div className="text-slate-800 flex bg-white dark:bg-slate-900 dark:text-slate-400">
            <div className="container mx-auto min-h-screen flex flex-col items-center">
                {children}
            </div>
        </div>
    );
};

export default SimpleLayout;