import React, {FC, memo, useEffect, useState} from 'react';
import {ComputerDesktopIcon, DevicePhoneMobileIcon, MoonIcon, SunIcon} from "@heroicons/react/24/outline";
import {ChevronDownIcon} from "@heroicons/react/20/solid";

const ThemeSwitcher: FC = memo(() => {
    const [modal, setModal] = useState(false)
    const switchTheme = (theme: string) => {
        switch (theme) {
            case "dark":
                localStorage.theme = 'dark'
                document.documentElement.classList.add('dark')
                document.documentElement.classList.remove('light')
                document.documentElement.style.backgroundColor = "#0f172a"
                break
            case "light":
                localStorage.theme = "light"
                document.documentElement.classList.add('light')
                document.documentElement.classList.remove('dark')
                document.documentElement.style.backgroundColor = "#f3f4f6"
                break
            default:
                localStorage.theme = "system"
                if (window.matchMedia('(prefers-color-scheme: dark)').matches) {
                    document.documentElement.classList.add('dark')
                    document.documentElement.classList.remove('light')
                    document.documentElement.style.backgroundColor = "#0f172a"
                } else {
                    document.documentElement.classList.add('light')
                    document.documentElement.classList.remove('dark')
                    document.documentElement.style.backgroundColor = "#f3f4f6"
                }
        }
    }
    useEffect(() => {
        switchTheme(localStorage.theme)
    }, [])

    const activeClass = " text-blue-600 dark:text-sky-500"

    return (
        <div
            className={"text-blue-600 cursor-pointer border lg:border-none border-slate-300 rounded-lg p-2 lg:p-0 dark:text-sky-500 dark:border-slate-600"}
            onClick={() => setModal(!modal)}
        >
            <div className={"flex items-center justify-between space-x-2"}>
                {localStorage.theme === "system"
                    ? window.matchMedia('(prefers-color-scheme: dark)').matches
                        ? <MoonIcon className={"w-6 h-6 lg:w-8 lg:h-8 text-slate-400"}/>
                        : <SunIcon className={"w-6 h-6 lg:w-8 lg:h-8 text-slate-500"}/>
                    : localStorage.theme === "dark"
                        ? <MoonIcon className={"w-6 h-6 lg:w-8 lg:h-8"}/>
                        : <SunIcon className={"w-6 h-6 lg:w-8 lg:h-8"}/>
                }
                <span className={"lg:hidden text-slate-800 capitalize font-semibold dark:text-slate-300"}>
                    {localStorage.theme}
                </span>
                <ChevronDownIcon className={"lg:hidden w-3 h-3 text-slate-500 dark:text-slate-400"}/>
            </div>
            {modal &&
                <ul className={"absolute top-full right-0 mt-2 lg:mt-8 font-semibold text-slate-700 text-sm z-50 w-36 py-1 rounded-lg bg-white overflow-hidden shadow-xl dark:text-slate-300 dark:bg-slate-800"}>
                    <li
                        className={"flex px-2 py-1 cursor-pointer items-center hover:bg-gray-100 dark:hover:bg-slate-700" + (localStorage.theme === "light" ? activeClass : "")}
                        onClick={() => switchTheme("light")}
                    >
                        <SunIcon className={"w-6 h-6 mr-2"}/>
                        Light
                    </li>
                    <li
                        className={"flex px-2 py-1 cursor-pointer items-center hover:bg-gray-100 dark:hover:bg-slate-700" + (localStorage.theme === "dark" ? activeClass : "")}
                        onClick={() => switchTheme("dark")}
                    >
                        <MoonIcon className={"w-6 h-6 mr-2"}/>
                        Dark
                    </li>
                    <li
                        className={"flex px-2 py-1 cursor-pointer items-center hover:bg-gray-100 dark:hover:bg-slate-700" + (localStorage.theme === "system" ? activeClass : "")}
                        onClick={() => switchTheme("system")}
                    >
                        <ComputerDesktopIcon className={"w-6 h-6 mr-2 hidden lg:block"}/>
                        <DevicePhoneMobileIcon className={"w-6 h-6 mr-2 lg:hidden"}/>
                        System
                    </li>
                </ul>
            }
        </div>
    );
});

export default ThemeSwitcher;