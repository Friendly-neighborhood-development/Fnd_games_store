import React from 'react';
import cl from './Search.module.css'
import CustomInput from "../UI/CustomInput/CustomInput";
import {GiMagnifyingGlass} from "react-icons/gi";

const Search = () => {
    return (
        <div className={cl.search}>
            <span className={cl.icon}><GiMagnifyingGlass /></span>
            <CustomInput type={"text"} placeholder={"Поиск игры или разработчика.."}/>
        </div>
    );
};

export default Search;