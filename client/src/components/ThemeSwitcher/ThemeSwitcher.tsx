import React, {memo, useEffect, useState} from 'react';
import {Listbox} from "@headlessui/react";
import {ComputerDesktopIcon, MoonIcon, SunIcon} from "@heroicons/react/24/outline";
import ThemeSwitcherSection from "./ThemeSwitcherSection";
import {IIcon} from "../../types/IIcon";

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
        switchTheme(localStorage.theme)
    }, [])

    return (
        <Listbox value={selectedTheme} onChange={switchTheme}>
            <Listbox.Button>
                <selectedTheme.Icon className={"w-8 h-8 text-slate-500 dark:text-slate-400"}/>
            </Listbox.Button>
            <Listbox.Options
                className={"absolute top-full right-0 mt-2 lg:mt-8 w-36 bg-white rounded-lg py-1 shadow-xl dark:text-slate-300 dark:bg-slate-800"}>
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
                                <ThemeSwitcherSection Icon={theme.Icon} className={""} title={theme.mode}/>
                            </li>
                        )}
                    </Listbox.Option>
                ))}
            </Listbox.Options>
        </Listbox>
    );
});

export default TestThemeSwitcher;