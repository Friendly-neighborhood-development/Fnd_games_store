import React, {FC} from 'react';
import cl from './GamesList.module.css'
import GameCard from "../GameCard/GameCard";
import images from "../../constants/images";

interface gameProps {
    title: string,
    description: string,
    image: string,
    id:number
}


const games:Array<gameProps> = [
    {title: "Minecraft", description: "Have a nice day", image: images.Minecraft, id: 1},
    {title: "Dota 2", description: "Have a bad day", image: images.Dota2, id: 2},
    {title: "GTA V", description: "Have a nice gun", image: images.GTA5, id: 3},
    {title: "Fortnite", description: "Have a pride day", image: images.Fortnite, id: 4},
    {title: "Valorant", description: "Have a quick day", image: images.Valorant, id: 5},
    {title: "Farming Simulator 22", description: "Have a farm day", image: images.FarmingSimulator, id: 6},
    {title: "Cyberpunk 2077", description: "Have a bug day", image: images.Cyberpunk, id: 7},

]

const GamesList:FC = () => {
    return (
        <div className={cl.gamesList}>
            {games.map(game =>
                <GameCard
                    title={game.title}
                    description={game.description}
                    image={game.image}
                    key={game.id}
                />)}
        </div>
    );
};

export default GamesList;