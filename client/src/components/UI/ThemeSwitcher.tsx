import React, {FC, useEffect, useState} from 'react';
import {MoonIcon, SunIcon} from "@heroicons/react/outline";

interface ThemeSwitcherProps {
    className: string
}

const ThemeSwitcher: FC<ThemeSwitcherProps> = ({className}) => {
    const [icon, setIcon] = useState(localStorage.getItem("theme") || "light")
    useEffect(() => {
        document.documentElement.setAttribute("class", localStorage.getItem("theme") || "light")
        localStorage.getItem("theme") === "dark"
            ? document.documentElement.style.backgroundColor = "#0f172a"
            : document.documentElement.style.backgroundColor = "#f3f4f6"
    }, [])

    const toggleTheme = () => {
        if (localStorage.getItem("theme") === "dark") {
            document.documentElement.setAttribute("class", "light")
            localStorage.setItem("theme", "light")
            setIcon("light")
            document.documentElement.style.backgroundColor = "#f3f4f6"
        } else {
            document.documentElement.setAttribute("class", "dark")
            localStorage.setItem("theme", "dark")
            setIcon("dark")
            document.documentElement.style.backgroundColor = "#0f172a"
        }
    }

    return (
        <span
            onClick={toggleTheme}
            className={"text-blue-600 dark:text-sky-500 cursor-pointer"}>
            {icon === "dark"
                ? <MoonIcon className={"w-8 h-8"}/>
                : <SunIcon className={"w-8 h-8"}/>
            }

        </span>
    );
};

export default ThemeSwitcher;