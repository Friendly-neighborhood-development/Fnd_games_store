import React, {FC, useEffect, useState} from 'react';
import cl from './GameCard.module.css'
import CustomButton from "../UI/CustomButton/CustomButton";

interface GameCardProps {
    title: string,
    description: string,
    image: string,
    price: number | string;
}

const GameCard: FC<GameCardProps> = ({title, description, image, price}) => {
    const [gameCardClasses, setGameCardClasses] = useState([cl.game_card, cl.skeleton].join(" "))
    const [gameImgClasses, setGameImgClasses] = useState([cl.game_img, cl.hide_text].join(" "))
    const [gameTitleClasses, setGameTitleClasses] = useState([cl.game_title, cl.hide_text].join(" "))
    const [gamePriceClasses, setGamePriceClasses] = useState([cl.game_price, cl.hide_text].join(" "))
    const [gameButtonClasses, setGameButtonClasses] = useState(cl.hide_text)


    useEffect(() => {
        setTimeout(() => {
            setGameCardClasses(cl.game_card)
            setGameImgClasses(cl.game_img)
            setGameTitleClasses(cl.game_title)
            setGamePriceClasses(cl.game_price)
            setGameButtonClasses("")
        }, 1500)
    }, [])


    return (
        <div className={gameCardClasses}>
            <div className={gameImgClasses}>
                <img src={image} alt={"game picture"}/>
            </div>
            <div className={cl.game_details}>
                <h3 className={gameTitleClasses}>{title}</h3>
                <div className={cl.game_sale}>
                    <p className={gamePriceClasses}>{price === "Бесплатно"
                        ? price
                        : price + " ₽"}</p>
                    <CustomButton>Получить</CustomButton>
                </div>
            </div>

        </div>
    );
};

export default GameCard;