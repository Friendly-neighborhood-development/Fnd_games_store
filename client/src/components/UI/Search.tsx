import React, {FC} from 'react';
import {Input} from "./Input";
import {MagnifyingGlassIcon} from "@heroicons/react/24/outline";

interface SearchProps {
    placeholder: string,
}

export const Search: FC<SearchProps> = ({placeholder}) => {
    return (
        <div className={" w-64 py-2 px-4 flex rounded-full bg-white border-solid border-gray-300 border dark:bg-slate-800 dark:border-slate-600"}>
            <span className={"mr-4 flex justify-center items-center"}>
                <MagnifyingGlassIcon className={"text-slate-500 h-5 w-5 dark:text-slate-300"}/>
            </span>
            <Input type={"text"} placeholder={placeholder} className={"dark:bg-transparent border-none"}/>
        </div>
    );
};

