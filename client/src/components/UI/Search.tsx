import React, {FC} from 'react';
import CustomInput from "./CustomInput";
import {SearchIcon} from "@heroicons/react/outline";

interface SearchProps {
    placeholder: string,
    className?: string
}

const Search: FC<SearchProps> = ({placeholder, className}) => {
    const rootClasses = ["rounded-3xl bg-white w-max-80 py-2 px-4 flex dark:bg-slate-700/50", className].join(" ")
    return (
        <div className={rootClasses}>
            <span className={"mr-4 flex justify-center items-center"}>
                <SearchIcon className={"text-gray-500 h-5 w-5"}/>
            </span>
            <CustomInput type={"text"} placeholder={placeholder}/>
        </div>
    );
};

export default Search;