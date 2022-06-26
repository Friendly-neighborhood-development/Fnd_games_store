import React from 'react';
import Sidebar from "../components/Sidebar/Sidebar";
import Navbar from "../components/Navbar/Navbar";
import GamesList from "../components/GamesList/GamesList";

const Games = () => {
    return (
        <div className="container">
            <Sidebar/>
            <div className="main-wrapper">
                <Navbar/>
                <GamesList/>
            </div>
        </div>
    );
};

export default Games;