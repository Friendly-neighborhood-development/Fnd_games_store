import React, {FC} from 'react';
import cl from '../Search/Search.module.css'
import CustomInput from "./CustomInput";
import {GiMagnifyingGlass} from "react-icons/gi";

interface SearchProps{
    placeholder: string
}

const Search:FC<SearchProps> = ({placeholder}) => {
    return (
        <div className={"rounded-2xl bg-white mb-2 w-80 p-4 flex"}>
            <span className={"mr-4 flex justify-center"}><GiMagnifyingGlass /></span>
            <CustomInput type={"text"} placeholder={placeholder}/>
        </div>
    );
};

export default Search;