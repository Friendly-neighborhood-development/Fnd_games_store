import React, {FC} from 'react';
import CustomInput from "./CustomInput";
import {SearchIcon} from "@heroicons/react/outline";

interface SearchProps {
    placeholder: string
}

const Search: FC<SearchProps> = ({placeholder}) => {
    return (
        <div className={"rounded-2xl bg-white mb-2 w-80 p-4 flex"}>
            <span className={"mr-4 flex justify-center items-center"}>
                <SearchIcon className={"text-gray-500 h-5 w-5"}/>
            </span>
            <CustomInput type={"text"} placeholder={placeholder}/>
        </div>
    );
};

export default Search;