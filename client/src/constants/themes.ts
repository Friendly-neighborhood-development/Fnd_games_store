import {ITheme} from "../models/ITheme";
import {ComputerDesktopIcon, MoonIcon, SunIcon} from "@heroicons/react/24/outline";

export const themes: Array<ITheme> = [
    {id: "1", title: 'light', Icon: SunIcon},
    {id: "2", title: 'dark', Icon: MoonIcon},
    {id: "3", title: 'system', Icon: ComputerDesktopIcon},
]