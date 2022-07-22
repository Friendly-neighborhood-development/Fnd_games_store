import React, {FC, useEffect, useState} from 'react';
import CustomButton from "./UI/CustomButton";
import {gameProps} from "../types/Games";

interface GameCardProps {
    name: string,
    description: string,
    image: string,
    price: number | string;
}

const GameCard: FC<gameProps> = ({name, description, base64Image, price, discount}) => {
    return (
        <div className={"flex flex-col w-56 p-2.5 mb-4 mx-2 rounded-3xl bg-white"}>
            <div className={"max-h-64 w-full rounded-2xl overflow-hidden flex justify-center items-center mb-4"}>
                <img className={"w-full"} src={base64Image} alt={"game picture"}/>
            </div>
            <div className={"mx-2"}>
                <h3 className={"mb-2"}>{name}</h3>
                <div  className={"text-sm"}>
                    {discount
                        ? <div>
                            <span className={"line-through text-gray-400"}>RUB {price}</span>
                            <span>  RUB {price - discount}</span>
                        </div>
                        : <span>RUB {price}</span>}
                    {/*<CustomButton>Получить</CustomButton>*/}
                </div>
            </div>

        </div>
    );
};

export default GameCard;