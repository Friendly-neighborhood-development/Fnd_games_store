import {ITheme} from "../models/ITheme";
import {ComputerDesktopIcon, MoonIcon, SunIcon} from "@heroicons/react/24/outline";

export const themes: Array<ITheme> = [
    {id: 1, mode: 'light', Icon: SunIcon},
    {id: 2, mode: 'dark', Icon: MoonIcon},
    {id: 3, mode: 'system', Icon: ComputerDesktopIcon},
]