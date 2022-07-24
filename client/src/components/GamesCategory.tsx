import React, {FC, useEffect, useState} from 'react';
import GameCard from "./GameCard";
import {gameProps} from "../types/Games";
import {BASE_URL} from "../constants/baseURL";

const GamesCategory: FC = () => {
    const [games, setGames] = useState(Array<gameProps>)
    useEffect(() => {
        const url = `${BASE_URL}/games/getAll`
        fetch(url)
            .then(response => response.json())
            .then(json => setGames(json))
    }, [])

    return (
        <>
            <div className={"mb-2 px-4 flex justify-start w-full"}>Популярные</div>
            <div className={"flex overflow-x-auto lg:flex-wrap justify-between w-full"}>
                {games.map(game =>
                    <GameCard
                        {...game}
                        key={game.id}
                    />)}
            </div>
        </>

    );
};

export default GamesCategory;