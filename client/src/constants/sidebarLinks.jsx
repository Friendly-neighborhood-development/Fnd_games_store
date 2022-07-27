import {PuzzleIcon, UserIcon} from "@heroicons/react/outline";

const iconClassName = "w-4 h-4 text-gray-400 mr-2"

export default [
    {to: "/games", title: "Games", icon: <PuzzleIcon className={iconClassName}/>},
    {to: "/login", title: "Login", icon: <UserIcon  className={iconClassName}/>}
]