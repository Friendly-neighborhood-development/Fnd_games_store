import React from 'react';
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