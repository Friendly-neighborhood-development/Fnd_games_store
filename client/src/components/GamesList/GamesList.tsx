import React, {FC} from 'react';
import cl from './GamesList.module.css'
import GameCard from "../GameCard/GameCard";
import images from "../../constants/images";

interface gameProps {
    title: string,
    description: string,
    image: string,
    price: number | string;
    id:number
}


const games:Array<gameProps> = [
    {title: "Minecraft", description: "Have a nice day", image: images.Minecraft,price: 1912, id: 1},
    {title: "Dota 2", description: "Have a bad day", image: images.Dota2,price: "Бесплатно", id: 2},
    {title: "GTA V", description: "Have a nice gun", image: images.GTA5,price: 1269, id: 3},
    {title: "Fortnite", description: "Have a pride day", image: images.Fortnite,price: "Бесплатно", id: 4},
    {title: "Valorant", description: "Have a quick day", image: images.Valorant,price: "Бесплатно", id: 5},
    {title: "Farming Simulator 22", description: "Have a farm day", image: images.FarmingSimulator,price:2256, id: 6},
    {title: "Cyberpunk 2077", description: "Have a bug day", image: images.Cyberpunk, price: 2839, id: 7},

]

const GamesList:FC = () => {
    return (
        <div className={cl.gamesList}>
            {games.map(game =>
                <GameCard
                    title={game.title}
                    description={game.description}
                    image={game.image}
                    price={game.price}
                    key={game.id}
                />)}
        </div>
    );
};

export default GamesList;