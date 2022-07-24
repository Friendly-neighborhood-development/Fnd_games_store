import React, {FC, useEffect, useState} from 'react';
import {gameProps} from "../types/Games";


const GameCard: FC<gameProps> = ({name, description, base64Image, price, discount}) => {
    return (
        <div className={"flex flex-col w-56 mb-4 mx-2 bg-white justify-between rounded-1"}>
            <div className={"h-56 w-full overflow-hidden flex justify-center items-center mb-4"}>
                <img className={"w-full pointer-events-none"} src={base64Image} alt={"game picture"}/>
            </div>
            <div className={"px-2 pb-2"}>
                <h3 className={"mb-2 text-ellipsis whitespace-nowrap overflow-hidden"}>{name}</h3>
                <div className={"text-sm"}>
                    {price===0
                        ?<div>Бесплатно</div>
                        :(discount
                        ? <div className={"flex justify-between items-center"}>
                            <span className={"flex items-center p-2 bg-blue-600 text-white rounded-lg text-2xs"}>-{discount}%</span>
                            <div className={"ml-1 flex-wrap flex justify-end items-center"}>
                                <div className={"line-through text-gray-400 font-bold"}>{price} ₽</div>
                                <div className={"ml-1"}>  {+(price - price*discount/100).toFixed(2)} ₽</div>
                            </div>

                        </div>
                        : <div>{price} ₽</div>)}
                </div>
            </div>

        </div>
    );
};

export default GameCard;