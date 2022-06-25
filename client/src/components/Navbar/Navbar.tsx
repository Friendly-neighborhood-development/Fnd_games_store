import React, {FC} from 'react';
import cl from "./Navbar.module.css"
import Search from "../Search/Search";

const Navbar:FC = () => {
    return (
        <div className={cl.navbar}>
            <Search/>
        </div>
    );
};

export default Navbar;