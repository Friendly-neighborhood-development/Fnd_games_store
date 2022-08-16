import React, {FC} from 'react';
import Input from "./Input";
import {SearchIcon} from "@heroicons/react/outline";

interface SearchProps {
    placeholder: string,
    className?: string
}

const Search: FC<SearchProps> = ({placeholder, className}) => {
    const rootClasses = ["rounded-3xl bg-white w-max-80 py-2.5 px-4 flex dark:bg-slate-700/50", className].join(" ")
    return (
        <div className={rootClasses}>
            <span className={"mr-4 flex justify-center items-center"}>
                <SearchIcon className={"text-gray-500 h-5 w-5"}/>
            </span>
            <Input type={"text"} placeholder={placeholder} className={"dark:bg-transparent text-slate-300 border-none"}/>
        </div>
    );
};

export default Search;