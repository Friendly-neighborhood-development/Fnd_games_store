import React, {FC, useEffect, useState} from 'react';
import CustomButton from "./UI/CustomButton";

interface GameCardProps {
    name: string,
    description: string,
    image: string,
    price: number | string;
}

const GameCard: FC<GameCardProps> = ({name, description, image, price}) => {
    return (
        <div className={"flex flex-col w-64 p-2.5 mb-4 rounded-3xl bg-white"}>
            <div className={"h-52 w-full rounded-2xl overflow-hidden flex justify-center items-center mb-4"}>
                <img className={"w-full"} src={image} alt={"game picture"}/>
            </div>
            <div className={"mx-2"}>
                <h3 className={"mb-2 font-bold"}>{name}</h3>
                <div className={"flex justify-between items-center"}>
                    <p className={"w-2/5 text-gray-500"}>{price === "Бесплатно"
                        ? price
                        : price + " ₽"}</p>
                    <CustomButton>Получить</CustomButton>
                </div>
            </div>

        </div>
    );
};

export default GameCard;