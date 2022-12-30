import React, {memo, useEffect} from 'react';
import {ListBox} from "./UI/ListBox";
import {MoonIcon, SunIcon} from "@heroicons/react/24/outline";
import {useSwitchTheme} from "../hooks/useThemeSwitch";
import {themes} from "../constants/themes";

const ThemeSwitcher = memo(() => {
    const {selectedTheme, setSelectedTheme} = useSwitchTheme()
    useEffect(() => {
        setSelectedTheme(themes.find(theme => theme.title === localStorage.theme) || themes[2])
    }, [])
    return (
        <div className={"relative"}>
            <ListBox selectedValue={selectedTheme} setSelectedValue={setSelectedTheme} values={themes}>
                <span className={"capitalize text-sm"}>{localStorage.theme}</span>
                {localStorage.theme === "system"
                    ? window.matchMedia('(prefers-color-scheme: dark)').matches
                        ? <MoonIcon className={"w-6 h-6"}/>
                        : <SunIcon className={"w-6 h-6"}/>
                    : <selectedTheme.Icon className={"w-6 h-6"}/>
                }
            </ListBox>
        </div>

    );
});

export default ThemeSwitcher;