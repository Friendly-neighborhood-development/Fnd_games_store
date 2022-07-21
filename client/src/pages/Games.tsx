import React from 'react';
import Sidebar from "../components/Sidebar";
import Navbar from "../components/Navbar";
import GamesList from "../components/GamesList";

const Games = () => {
    return (
        <div className="container mx-auto">
            <Sidebar/>
            <div className="flex flex-col items-center pl-56">
                <Navbar/>
                <GamesList/>
            </div>
        </div>
    );
};

export default Games;