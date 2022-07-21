import React, {FC} from 'react';
import Search from "./UI/Search";

const Navbar:FC = () => {
    return (
        <div className={"w-full mb-4"}>
            <Search placeholder={"Поиск игры или разработчика.."}/>
        </div>
    );
};

export default Navbar;