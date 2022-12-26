import React, {memo, useEffect} from 'react';
import {Listbox} from "@headlessui/react";
import {MoonIcon, SunIcon} from "@heroicons/react/24/outline";
import {ChevronDownIcon} from "@heroicons/react/20/solid";
import {useSwitchTheme} from "../hooks/useThemeSwitch";
import {themes} from "../constants/themes";

const ThemeSwitcher = memo(() => {
    const {selectedTheme, setSelectedTheme} = useSwitchTheme()
    useEffect(() => {
        setSelectedTheme(themes.find(theme => theme.mode === localStorage.theme) || themes[2])
    }, [])

    return (
        <div className={"relative"}>
            <Listbox value={selectedTheme} onChange={setSelectedTheme}>
                <Listbox.Button
                    className={"flex items-center border border-gray-300 h-10 px-4 space-x-1.5 text-slate-600 rounded-3xl hover:bg-gray-200/30 dark:hover:bg-slate-500/50 dark:border-slate-600 dark:text-slate-300 dark:bg-slate-800"}>
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
                    className={"absolute top-full right-0 mt-8 lg:mt-8 w-36 bg-white rounded-lg py-1 shadow-xl overflow-hidden dark:text-slate-300 dark:bg-slate-800"}>
                    {themes.map((theme) => (
                        <Listbox.Option
                            key={theme.id}
                            value={theme}
                        >
                            {({active, selected}) => (
                                <div
                                    className={`px-2 py-1 cursor-pointer 
                                ${active ? "bg-gray-100 dark:bg-slate-700 " : ""}
                                ${selected ? "text-blue-600 dark:text-sky-500" : ""}`}
                                >
                                    <div className={"flex capitalize"}>
                                        <theme.Icon className={"w-6 h-6 mr-2"}/>
                                        {theme.mode}
                                    </div>
                                </div>
                            )}
                        </Listbox.Option>
                    ))}
                </Listbox.Options>
            </Listbox>
        </div>

    );
});

export default ThemeSwitcher;