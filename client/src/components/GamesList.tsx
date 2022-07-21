import React, {FC, useEffect, useState} from 'react';
import GameCard from "./GameCard";
import {gameProps} from "../types/Games";

const GamesList: FC = () => {
    const [games, setGames] = useState(Array<gameProps>)
    useEffect(() => {
        const url = 'http://localhost:8080/games/getAll'
        // const url = 'https://jsonplaceholder.typicode.com/todos'
        const method = "GET"
        const headers: any = {}
        headers["Accept"] = "*/*"
        headers["Connection"] = "keep-alive"
        headers["Access-Control-Allow-Origin"] = "*"
        headers["Access-Control-Allow-Credentials"] = true

        fetch(url)
            .then(response => response.json())
            .then(json => setGames(json))
    }, [])

    return (
        <div className={"w-full flex flex-wrap justify-between"}>
            {games.map(game =>
                <GameCard
                    name={game.name}
                    description={game.description}
                    image={game.base64Image}
                    price={game.price}
                    key={game.id}
                />)}
        </div>
    );
};

export default GamesList;