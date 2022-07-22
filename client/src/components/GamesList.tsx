import React, {FC, useEffect, useState} from 'react';
import GameCard from "./GameCard";
import {gameProps} from "../types/Games";

const GamesList: FC = () => {
    const [games, setGames] = useState(Array<gameProps>)
    useEffect(() => {
        const url = 'http://localhost:8080/games/getAll'
        fetch(url)
            .then(response => response.json())
            .then(json => setGames(json))
    }, [])

    return (
        <div className={"w-full flex flex-wrap"}>
            {games.map(game =>
                <GameCard
                    {...game}
                    key={game.id}
                />)}
        </div>
    );
};

export default GamesList;