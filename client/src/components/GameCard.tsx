import React, {FC} from 'react';
import {gameProps} from "../types/Games";
import {Link} from "react-router-dom";


const GameCard: FC<gameProps> = ({name, description, base64Image, price, discount}) => {
    return (
        <Link to={`/games/${name}`}
              className={"flex w-60 flex-wrap lg:w-1/6 mb-4 mx-1 bg-white justify-between rounded-md"}>
            <div className={"h-72 md:h-56 w-60 overflow-hidden flex justify-center items-center mb-4 rounded-md"}>
                <img className={"w-full pointer-events-none"} src={base64Image} alt={"game picture"}/>
            </div>
            <div className={"px-2 pb-2 w-full"}>
                <div className={"h-10 text-ellipsis whitespace-nowrap overflow-hidden"}>{name}</div>
                <div className={"text-sm"}>
                    {price === 0
                        ? <div>Бесплатно</div>
                        : (discount
                            ? <div className={"flex justify-between items-center"}>
                                <span
                                    className={"flex items-center p-2 bg-blue-600 text-white rounded-lg text-2xs"}>-{discount}%</span>
                                <div className={"ml-1 flex-wrap flex justify-end items-center"}>
                                    <div className={"line-through text-gray-400 font-bold"}>{price} ₽</div>
                                    <div className={"ml-1"}>  {+(price - price * discount / 100).toFixed(2)} ₽</div>
                                </div>

                            </div>
                            : <div>{price} ₽</div>)}
                </div>
            </div>

        </Link>
    );
};

export default GameCard;