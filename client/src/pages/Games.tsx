import React from 'react';
import GamesList from "../components/GamesList";
import MainLayout from "../components/layouts/MainLayout";

const Games = () => {
    return (
        <MainLayout>
            <div className={"w-full flex flex-col"}>
                <GamesList/>
            </div>
        </MainLayout>
    );
};

export default Games;