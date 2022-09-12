import React, {memo, useEffect, useState} from 'react';
import {Listbox} from "@headlessui/react";
import {ComputerDesktopIcon, MoonIcon, SunIcon} from "@heroicons/react/24/outline";
import {IIcon} from "../types/IIcon";
import {ChevronDownIcon} from "@heroicons/react/20/solid";

interface Itheme {
    id: number,
    mode: "light" | "dark" | "system"
    Icon: React.FC<IIcon>
}

const themes: Array<Itheme> = [
    {id: 1, mode: 'light', Icon: SunIcon},
    {id: 2, mode: 'dark', Icon: MoonIcon},
    {id: 3, mode: 'system', Icon: ComputerDesktopIcon},
]

const TestThemeSwitcher = memo(() => {
    const [selectedTheme, setSelectedTheme] = useState(themes[0])
    const switchTheme = (theme: Itheme) => {
        switch (theme.mode) {
            case "light":
                localStorage.theme = "light"
                document.documentElement.classList.add('light')
                document.documentElement.classList.remove('dark')
                document.documentElement.style.backgroundColor = "#f3f4f6"
                setSelectedTheme(themes[0])
                break
            case "dark":
                localStorage.theme = 'dark'
                document.documentElement.classList.add('dark')
                document.documentElement.classList.remove('light')
                document.documentElement.style.backgroundColor = "#0f172a"
                setSelectedTheme(themes[1])
                break
            default:
                localStorage.theme = "system"
                if (window.matchMedia('(prefers-color-scheme: dark)').matches) {
                    document.documentElement.classList.add('dark')
                    document.documentElement.classList.remove('light')
                    document.documentElement.style.backgroundColor = "#0f172a"
                    setSelectedTheme(themes[2])
                } else {
                    document.documentElement.classList.add('light')
                    document.documentElement.classList.remove('dark')
                    document.documentElement.style.backgroundColor = "#f3f4f6"
                    setSelectedTheme(themes[2])
                }
        }
    }
    useEffect(() => {
        // шото с этим сделать
        switchTheme(themes.find(theme => theme.mode === localStorage.theme) || themes[2])
    }, [])

    return (
        <div className={"relative"}>
            <Listbox value={selectedTheme} onChange={switchTheme}>
                <Listbox.Button
                    className={"flex items-center border border-gray-300 h-10 px-4 space-x-1.5 text-slate-600 rounded-3xl dark:border-slate-600 dark:text-slate-300 dark:bg-slate-800"}>
                    <span className={"capitalize text-sm"}>{localStorage.theme}</span>
                    {localStorage.theme === "system"
                        ? window.matchMedia('(prefers-color-scheme: dark)').matches
                            ? <MoonIcon className={"w-6 h-6"}/>
                            : <SunIcon className={"w-6 h-6"}/>
                        : <selectedTheme.Icon className={"w-6 h-6"}/>
                    }
                    <ChevronDownIcon className={"w-3 h-3"}/>
                </Listbox.Button>
                <Listbox.Options
                    className={"absolute top-full right-0 mt-8 lg:mt-8 w-36 bg-white rounded-lg py-1 shadow-xl dark:text-slate-300 dark:bg-slate-800 overflow-hidden"}>
                    {themes.map((theme) => (
                        <Listbox.Option
                            key={theme.id}
                            value={theme}
                        >
                            {({active, selected}) => (
                                <li
                                    className={`px-2 py-1 cursor-pointer 
                                ${active ? "bg-gray-100 dark:bg-slate-700 " : ""}
                                ${selected ? "text-blue-600 dark:text-sky-500" : ""}`}
                                >
                                    <div className={"flex capitalize"}>
                                        <theme.Icon className={"w-6 h-6 mr-2"}/>
                                        {theme.mode}
                                    </div>
                                </li>
                            )}
                        </Listbox.Option>
                    ))}
                </Listbox.Options>
            </Listbox>
        </div>

    );
});

export default TestThemeSwitcher;