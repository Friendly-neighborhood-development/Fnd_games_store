import React from 'react';
import Sidebar from "../components/Sidebar";
import Navbar from "../components/Navbar";
import GamesList from "../components/GamesList";
import MainLayout from "../components/layouts/MainLayout";

const Games = () => {
    return (
        <MainLayout>
            <GamesList/>
        </MainLayout>

    );
};

export default Games;