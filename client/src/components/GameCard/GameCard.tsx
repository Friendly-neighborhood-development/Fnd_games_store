import React, {FC, useEffect, useState} from 'react';
import cl from './GameCard.module.css'

interface GameCardProps {
    title: string,
    description: string,
    image: string
}

const GameCard:FC<GameCardProps> = ({title, description, image}) => {
    const [gameCardClasses, setGameCardClasses] = useState([cl.game_card, cl.skeleton].join(" "))
    const [gameImgClasses, setGameImgClasses] = useState([cl.game_img, cl.hide_text].join(" "))
    const [gameTitleClasses, setGameTitleClasses] = useState([cl.game_title, cl.hide_text].join(" "))
    const [gameDescriptionClasses, setGameDescriptionClasses] = useState([cl.game_description, cl.hide_text].join(" "))

    useEffect(() => {
        setTimeout(() => {
            setGameCardClasses(cl.game_card)
            setGameImgClasses(cl.game_img)
            setGameTitleClasses(cl.game_title)
            setGameDescriptionClasses(cl.game_description)
        }, 1500)
    }, [])


    return (
        <div className={gameCardClasses}>
            <div className={gameImgClasses}>
                <img src={image} alt={"game picture"}/>
            </div>
                <h3 className={gameTitleClasses}>{title}</h3>
                <p className={gameDescriptionClasses}>{description}</p>
        </div>
    );
};

export default GameCard;