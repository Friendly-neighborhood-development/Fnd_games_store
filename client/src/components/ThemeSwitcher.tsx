import React, {FC, memo, useEffect, useState} from 'react';
import {ComputerDesktopIcon, MoonIcon, SunIcon} from "@heroicons/react/24/outline";

const ThemeSwitcher: FC = memo(() => {
    const [modal, setModal] = useState(false)
    const switchTheme = (theme: string) => {
        switch (theme) {
            case "dark":
                localStorage.theme = 'dark'
                document.documentElement.classList.add('dark')
                document.documentElement.classList.remove('light')
                break
            case "light":
                localStorage.theme = "light"
                document.documentElement.classList.add('light')
                document.documentElement.classList.remove('dark')
                break
            default:
                localStorage.theme = "system"
                if (window.matchMedia('(prefers-color-scheme: dark)').matches) {
                    document.documentElement.classList.add('dark')
                    document.documentElement.classList.remove('light')
                } else {
                    document.documentElement.classList.add('light')
                    document.documentElement.classList.remove('dark')
                }
        }
    }
    useEffect(() => {
        switchTheme(localStorage.theme)
    }, [])



    return (
        <div
            className={"text-blue-600 cursor-pointer dark:text-sky-500"}
            onClick={() => setModal(!modal)}
        >
            {localStorage.theme === "system"
                ? window.matchMedia('(prefers-color-scheme: dark)').matches
                    ? <MoonIcon className={"w-8 h-8 text-slate-300"}/>
                    : <SunIcon className={"w-8 h-8 text-slate-500"}/>
                : localStorage.theme === "dark"
                    ? <MoonIcon className={"w-8 h-8"}/>
                    : <SunIcon className={"w-8 h-8"}/>
            }
            {modal &&
                <ul className={"absolute top-full right-0 mt-8 font-semibold text-slate-700 text-sm z-50 w-36 py-1 rounded-lg bg-white overflow-hidden shadow-xl dark:text-slate-300 dark:bg-slate-800"}>
                    <li
                        className={"flex px-2 py-1 cursor-pointer items-center hover:bg-gray-100 dark:hover:bg-slate-700"}
                        onClick={() => switchTheme("light")}
                    >
                        <SunIcon className={"w-6 h-6 mr-2 text-slate-500"}/>
                        Light
                    </li>
                    <li
                        className={"flex px-2 py-1 cursor-pointer items-center hover:bg-gray-100 dark:hover:bg-slate-700"}
                        onClick={() => switchTheme("dark")}
                    >
                        <MoonIcon className={"w-6 h-6 mr-2 text-slate-500"}/>
                        Dark
                    </li>
                    <li
                        className={"flex px-2 py-1 cursor-pointer items-center hover:bg-gray-100 dark:hover:bg-slate-700"}
                        onClick={() => switchTheme("system")}
                    >
                        <ComputerDesktopIcon className={"w-6 h-6 mr-2 text-slate-500"}/>
                        System
                    </li>
                </ul>
            }

        </div>
    );
});

export default ThemeSwitcher;