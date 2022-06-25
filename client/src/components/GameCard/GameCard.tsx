import React, {FC} from 'react';
import cl from './GameCard.module.css'

interface GameCardProps {
    title: string,
    description: string,
    image: string
}

const GameCard:FC<GameCardProps> = ({title, description, image}) => {
    return (
        <div className={cl.game_card}>
            <div className={cl.game_img}>
                <img src={image} alt={"game picture"}/>
            </div>
            <div className={cl.game_details}>
                <h3>{title}</h3>
                <p>{description}</p>
            </div>
        </div>
    );
};

export default GameCard;