import React, {FC, useEffect, useState} from 'react';
import {MoonIcon, SunIcon} from "@heroicons/react/outline";

interface ThemeSwitcherProps {
    className: string
}

const ThemeSwitcher: FC<ThemeSwitcherProps> = ({className}) => {
    const [icon, setIcon] = useState("light")
    useEffect(() => {
        document.documentElement.setAttribute("class", localStorage.getItem("theme") || "light")
    }, [])

    const toggleTheme = () => {
        if (localStorage.getItem("theme") === "dark") {
            document.documentElement.setAttribute("class", "light")
            localStorage.setItem("theme", "light")
            setIcon("light")
        } else {
            document.documentElement.setAttribute("class", "dark")
            localStorage.setItem("theme", "dark")
            setIcon("dark")
        }
    }

    return (
        <span onClick={toggleTheme}>
            {icon === "dark"
                ? <MoonIcon className={"w-8 h-8 text-blue-600 dark:text-sky-500 cursor-pointer"}/>
                : <SunIcon className={"w-8 h-8 text-blue-600 dark:text-sky-500 cursor-pointer"}/>
            }

        </span>
    );
};

export default ThemeSwitcher;