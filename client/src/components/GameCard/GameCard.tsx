import React, {FC} from 'react';
import cl from './GameCard.module.css'

interface GameCardProps {
    title: string,
    description: string
}

const GameCard:FC<GameCardProps> = ({title, description}) => {
    return (
        <div className={cl.card}>
            <h3>{title}</h3>
            <p>{description}</p>
        </div>
    );
};

export default GameCard;