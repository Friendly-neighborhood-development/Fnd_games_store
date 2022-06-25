import React, {FC} from 'react';
import cl from './GamesList.module.css'
import GameCard from "../GameCard/GameCard";

interface gameProps {
    title: string,
    description: string,
    id:number
}


const games:Array<gameProps> = [
    {title: "Minecraft", description: "Have a nice day", id: 1},
    {title: "Dota 2", description: "Have a bad day", id: 2},
    {title: "GTA V", description: "Have a nice gun", id: 3},
    {title: "Fortnite", description: "Have a pride day", id: 4},
    {title: "Valorant", description: "Have a quick day", id: 5},
    {title: "Farming Simulator 22", description: "Have a farm day", id: 6},
    {title: "Cyberpunk 2077", description: "Have a bug day", id: 7},
    {title: "Battlefield 6", description: "Have a war day", id: 8},

]

const GamesList:FC = () => {
    return (
        <div className={cl.gamesList}>
            {games.map(game =>
                <GameCard
                    title={game.title}
                    description={game.description}
                    key={game.id}
                />)}
        </div>
    );
};

export default GamesList;