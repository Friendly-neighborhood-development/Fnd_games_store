import React, {FC} from 'react';
import Input from "./Input";
import {MagnifyingGlassIcon} from "@heroicons/react/24/outline";

interface SearchProps {
    placeholder: string,
    className?: string
}

const Search: FC<SearchProps> = ({placeholder, className}) => {
    const rootClasses = ["rounded-3xl w-max-80 py-2 px-4 flex dark:bg-slate-800 ", className].join(" ")
    return (
        <div className={rootClasses}>
            <span className={"mr-4 flex justify-center items-center"}>
                <MagnifyingGlassIcon className={"text-slate-300 h-5 w-5"}/>
            </span>
            <Input type={"text"} placeholder={placeholder} className={"dark:bg-transparent border-none"}/>
        </div>
    );
};

export default Search;